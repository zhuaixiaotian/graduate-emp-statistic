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
      // 动态插入的表单需要重新渲染,
      // select:表单项的类型 addForm:为 class="layui-form" 所在元素的 lay-filter="" 的值
      form.render("select","addForm");
    }
  });
  // 点击添加表单事件
  form.on('submit(addSubmit)', function (data) {
    $.ajax({
      url: '/clazz/add',
      method: 'post',
      data: data.field,//当前容器的全部表单字段，名值对形式：{name: value}
      success: function (result) {
        if (result.success) {
          // 传入第一页刷新表格
          parent.layui.table.reload("tb",{
            page:{
              curr:1
            }
          });
          // window.name:layui-layer-iframe1 会被layui改写
          var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
          parent.layer.close(index); //再执行关闭
        } else {
          layer.msg(result.errMsg);
        }
      }
    });
    return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
  });
});