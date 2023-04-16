layui.use(['table', 'jquery', 'form','layer'], function (table,$,form,layer) {
  // 公司下拉框
  $.ajax({
    url:'/company/selectAll',
    method:'post',
    success:function (result) {
      if (!result.success) {
        return;
      }
      var majorArr = result.data;
      majorArr.unshift({"id":-1,"companyName":"--全部公司--"});
      var html = buildOptionHtml(majorArr,"id","companyName",true);
      $("select[name=companyId]").html(html);
      // 动态插入的表单需要重新渲染
      form.render("select","searchForm");
    }
  });
  // 表格渲染
  var options = $.extend(true,{},tbDefaultOptions,{
    url: '/job/loadTable'
    // 表单取值查询条件
    , where: form.val("searchForm")
    , cols: [[ //表头
      {type: 'checkbox'}
      , {field: 'id', title: '系统标识', sort: true,width:110}
      , {field: 'jobName', title: '岗位名称'}
      , {field: 'requirements', title: '任职要求'}
      , {field: 'monthlyPay', title: '月薪/元'}
      , {field: 'companyName', title: '公司名称'}
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
          url: '/job/deleteById',
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
      ,area: ['600px', '450px']
      ,content: ['/job/toAdd', 'no']
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
      ,area: ['600px', '450px']
      ,content: ['/job/toEdit?selectedId='+checkStatus.data[0].id, 'no']
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