layui.use(['jquery', 'form','laydate'], function ($,form,laydate) {
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
      var html = buildOptionHtml(result.data,"id","majorName",true);
      $("select[name=majorId]").html(html);
      // 查询要回显的内容
      echoOne();
      form.render("select","editForm");
    }
  });
  function echoOne() {
    $.ajax({
      url: '/clazz/selectOneById',
      method: 'post',
      data: {id: idToShow},
      success: function (result) {
        if (result.success) {
          var selectedData = result.data;
          form.val("editForm", selectedData);
        } else {
          layer.msg(result.errMsg);
        }
      }
    });
  }

  // 编辑书籍类型表单提交事件
  form.on('submit(editSubmit)', function (data) {
    $.ajax({
      url: '/clazz/update',
      method: 'post',
      data: data.field,
      success: function (result) {
        if (result.success) {
          parent.layui.table.reload("tb"); // 在当前页刷新即可
          var index = parent.layer.getFrameIndex(window.name);
          parent.layer.close(index);
        } else {
          layer.msg(result.errMsg);
        }
      }
    });
    return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
  });
});