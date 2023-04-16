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
    url: '/student/loadTable'
    , height: 480
    // 表单取值查询条件
    , where: form.val("searchForm")
    , cols: [[ //表头
      {type: 'checkbox'}
      , {field: 'id', title: '系统标识', sort: true,width:110}
      , {field: 'studentName', title: '学生姓名'}
      // templet: 格式化列显示
      , {field: 'sex', title: '性别',templet:function (rowData) {
          if (rowData.sex === "M") {
            return "男";
          }else {
            return "女";
          }
        }}
      , {field: 'clazzName', title: '所在班级'}
      , {field: 'graduateYear', title: '毕业年份'}
      , {field: 'majorName', title: '所属专业'}
      , {field: 'jobName', title: '就业情况',templet:function (rowData) {
          if (rowData.studentJobId) {
            return rowData.companyName + "-" + rowData.jobName;
          }else {
            return "尚未就业";
          }
        }}
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
          url: '/student/deleteById',
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
    }else if (layEvent === 'delStudentJob') {
      layer.confirm('确定要删除该学生的就业信息吗?', function (index) {
        $.ajax({
          url: '/studentJob/deleteById',
          method: 'post',
          data: {"idToDelete":rowData.studentJobId},
          success: function (data) {
            if (data.success) {
              table.reload("tb"); // 当前页加载
              layer.close(index);
            } else {
              layer.msg(data.msg);
            }
          }
        });
      });
    }else if (layEvent === 'openAddStudentJobDia') {
      // 打开前加载公司下拉框
      $.ajax({
        url:'/company/selectAll',
        method:'post',
        success:function (result) {
          if (!result.success) {
            return;
          }
          var arr = result.data;
          var html = buildOptionHtml(arr,"id","companyName",true);
          $("select[name=companyId]").html(html);
          form.render("select","addStudentJobForm");
          if (arr && arr.length > 0) {
            loadJobByCompanyId(arr[0]["id"]);
          }
        }
      });
      // 页面层弹出窗口
      var dialogId = layer.open({
         type:1
        ,title:'添加就业信息'
        ,area: ['450px', '450px']
        ,content: $("#addStudentJobDia")
      });
      // 设置表单的订单id
      form.val("addStudentJobForm",{
        "studentId":rowData.id,
        "dialogId":dialogId
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
      ,content: ['/student/toAdd', 'no']
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
      ,content: ['/student/toEdit?selectedId='+checkStatus.data[0].id, 'no']
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
  // 根据公司id查询该公司发布的所有岗位
  function loadJobByCompanyId(companyId) {
    $.ajax({
      url:'/job/selectByCompanyId',
      method:'post',
      data:{"companyId":companyId},
      success:function (result) {
        if (!result.success) {
          return;
        }
        var html = buildOptionHtml(result.data,"id","jobName",true);
        $("select[name=jobId]").html(html);
        form.render("select","addStudentJobForm");
      }
    });
  }
  // 公司选择时级联改变岗位下拉列表
  form.on('select(companySelect)', function(data){
    var selectedValue = data.value; //得到被选中的值
    loadJobByCompanyId(selectedValue);
  });
  /*
  注意:
  form的事件(如select/submit)的过滤器是写在元素上的lay-filter的值。
  不是写在class="layui-form"所在元素的lay-filter,render的时候才是它。
   */
  form.on('submit(confirmAddStudentJobBtn)', function (data) {
    var addStudentJobFormData = data.field;
    $.ajax({
      url: '/studentJob/add',
      method: 'post',
      data: addStudentJobFormData,
      success: function (data) {
        if (data.success) {
          table.reload("tb"); // 当前页加载
          layer.close(index);
        } else {
          layer.msg(data.msg);
        }
      }
    });
    layer.close(addStudentJobFormData["dialogId"]);
    return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
  });
});