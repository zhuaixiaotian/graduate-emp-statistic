<html>
<head>
  <title>添加系别</title>
  <#include "../../common/common_resources.ftl"/>
</head>
<body>
<div class="mt-d7">
  <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
  <form class="layui-form layui-form-pane" lay-filter="addForm">
    <div class="layui-form-item">
      <label class="layui-form-label">所在班级</label>
      <div class="layui-input-block">
        <select name="clazzId" readonly lay-verify="required"></select>
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">学生姓名</label>
      <div class="layui-input-block">
        <input type="text" name="studentName" class="layui-input" lay-verify="required">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">性别</label>
      <div class="layui-input-block">
        <input type="radio" name="sex" value="M" title="男" checked/>
        <input type="radio" name="sex" value="F" title="女" />
      </div>
    </div>
    <div class="layui-form-item">
      <div class="layui-input-block">
        <!--lay-submit绑定触发提交的元素,无需填写值-->
        <button type="submit" class="layui-btn" lay-submit lay-filter="addSubmit">确认添加</button>
      </div>
    </div>
  </form>
</div>
<script src="${rc.contextPath}/resources/js/school/student/add.js"></script>
</body>
</html>
