<html lang="zh-cn">
<head>
  <meta charset="utf-8">
  <title>登录</title>
  <#include "common/common_resources.ftl"/>
</head>
<body id="login-bg">
<div class="layui-fluid mt-7">
  <div class="layui-row">
    <div class="layui-col-xs4 layui-col-xs-offset4">
      <h1 class="white system-title">毕业生就业统计系统</h1>
      <form class="layui-form" action="" method="post" id="loginForm">
        <div class="layui-form-item">
          <label class="layui-form-label white">用户名</label>
          <div class="layui-input-block">
            <input type="text" name="userName" lay-verify="required" class="layui-input" />
          </div>
        </div>
        <div class="layui-form-item mt-2">
          <label class="layui-form-label white">密码</label>
          <div class="layui-input-block">
            <input type="password" name="pwd" lay-verify="required" class="layui-input"/>
          </div>
        </div>
        <div class="layui-form-item  mt-3">
          <div class="layui-input-block text-center">
            <button class="layui-btn" lay-submit lay-filter="loginBtn">登录</button>
            <button style="margin-left: 100px;" type="reset" class="layui-btn">重置</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
<script src="${rc.contextPath}/resources/js/login.js"></script>
</body>
</html>
