layui.use(['jquery', 'form'], function ($,form) {
  $.ajax({
    url: '/company/selectOneById',
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
  // 编辑书籍类型表单提交事件
  form.on('submit(editSubmit)', function (data) {
    $.ajax({
      url: '/company/update',
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