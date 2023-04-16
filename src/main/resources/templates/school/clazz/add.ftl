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
      <label class="layui-form-label">毕业年份</label>
      <div class="layui-input-block">
        <input type="text" name="graduateYear" id="graduateYear"
               readonly class="layui-input" lay-verify="required|number">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">所属专业</label>
      <div class="layui-input-inline">
        <select name="majorId" readonly lay-verify="required"></select>
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">班级名称</label>
      <div class="layui-input-block">
        <input type="text" name="clazzName" class="layui-input" lay-verify="required">
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
<script src="${rc.contextPath}/resources/js/school/clazz/add.js"></script>
</body>
</html>
