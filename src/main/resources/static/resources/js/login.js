layui.use(['form', 'jquery','layer'], function(form,$,layer){
  //监听提交
  form.on('submit(loginBtn)', function(data){
    $.ajax({
      url: '/login',
      method: 'post',
      data: data.field,//当前容器的全部表单字段，名值对形式：{name: value}
      success: function (result) {
        if (result.success) {
          layer.msg(result.data, {
            icon: 6, // 0-6,6:开心
            time: 500 // 500ms后调用回调
          }, function(){
            parent.location.href = '/toMain';
          })
        }else {
          layer.open({
            content: result.errMsg,
            icon: 5, // 快哭了
            anim: 6 // 0-6 不同的效果
          });
        }
      }
    });
    return false;
  });
  // 避免session失效后登录页面嵌入在iframe中
  function loadTopWindow(){
    if (window.top!=null && window.top.document.URL!==document.URL){
      window.top.location.href = document.URL;
    }
  }
  loadTopWindow();
});
