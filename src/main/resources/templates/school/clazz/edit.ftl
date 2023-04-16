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
<script src="${rc.contextPath}/resources/js/school/clazz/edit.js"></script>
</body>
</html>
