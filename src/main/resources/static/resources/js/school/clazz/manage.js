layui.use(['table', 'jquery', 'form','layer','laydate'], function (table,$,form,layer,laydate) {
  // 日期控件渲染
  laydate.render({
    elem:"#graduateYear",
    type:'year', // year为只有年份
    format:'yyyy',
    isPreview:false // 左下角的预览是否显示
  });
  // 专业下拉框
  $.ajax({
    url:'/major/selectAll',
    method:'post',
    success:function (result) {
      if (!result.success) {
        return;
      }
      var majorArr = result.data;
      majorArr.unshift({"id":-1,"majorName":"--全部专业--"});
      var html = buildOptionHtml(majorArr,"id","majorName",true);
      $("select[name=majorId]").html(html);
      // 动态插入的表单需要重新渲染
      form.render("select","searchForm");
    }
  });
  // 表格渲染
  var options = $.extend(true,{},tbDefaultOptions,{
    url: '/clazz/loadTable'
    // 表单取值查询条件
    , where: form.val("searchForm")
    , cols: [[ //表头
      {type: 'checkbox'}
      , {field: 'id', title: '系统标识', sort: true,width:110}
      , {field: 'clazzName', title: '班级名称'}
      , {field: 'graduateYear', title: '毕业年份'}
      , {field: 'majorName', title: '所属专业'}
      , {title:'操作', align: 'center', toolbar: '#operationBar'}
    ]]
  });
  table.render(options);
  // 行工具条事件
  table.on('tool(test)', function (obj) {
    var rowData = obj.data; //获得当前行数据
    var layEvent = obj.event; //获得 lay-event 对应的值
    if (layEvent === 'del') { //删除
      layer.confirm('确定要删除吗?', function (index) {
        $.ajax({
          url: '/clazz/deleteById',
          method: 'post',
          data: {"idToDelete":rowData.id},
          success: function (data) {
            if (data.success) {
              reloadTable(1);
              layer.close(index);
            } else {
              layer.msg(data.msg);
            }
          }
        });
      });
    }
  });
  //单击行勾选checkbox事件
  registerTrClick($);
  // 新增按钮点击
  $("#addBtn").click(function () {
    layer.open({
       type:2
      ,title:'添加'
      ,area: ['400px', '450px']
      ,content: ['/clazz/toAdd', 'no']
    });
  });
  // 编辑按钮点击
  $("#editBtn").click(function () {
    //table 即为基础参数 id 对应的值,不指定会找table标签的id
    var checkStatus = table.checkStatus('tb');
    // checkStatus.data获取表格选中的行数据
    if (checkStatus.data.length !== 1) {
      layer.msg("一次只能编辑一行");
      return false;
    }
    layer.open({
      type:2
      ,title:'编辑'
      ,area: ['400px', '450px']
      ,content: ['/clazz/toEdit?selectedId='+checkStatus.data[0].id, 'no']
    });
  });
  // 搜索
  $("#searchBtn").click(function () {
    reloadTable(1);
    // 按钮放在layui-form中点击就会触发提交,这里返回false不让他提交
    return false;
  });
  // 默认是在弹出框弹出时的那个pageNow reload
  function reloadTable(toPageNum) {
    table.reload("tb",{
      where: form.val("searchForm"),
      page:{
        curr:toPageNum
      }
    });
  }
});