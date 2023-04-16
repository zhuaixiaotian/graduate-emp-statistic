<html>
<head>
  <title>编辑班级信息</title>
  <#include "../../common/common_resources.ftl"/>
</head>
<body>
<div class="cont">
  <form class="layui-form layui-form-pane" lay-filter="editForm">
    <input type="hidden" name="id" disabled class="layui-input">
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
        <input type="radio" name="sex" value="M" title="男"/>
        <input type="radio" name="sex" value="F" title="女" />
      </div>
    </div>
    <div class="layui-form-item">
      <div class="layui-input-block">
        <button type="submit" class="layui-btn" lay-submit lay-filter="editSubmit">
          确认修改
        </button>
      </div>
    </div>
  </form>
</div>
<script>
  var idToShow = "${Request.selectedId}";
</script>
<script src="${rc.contextPath}/resources/js/school/student/edit.js"></script>
</body>
</html>
