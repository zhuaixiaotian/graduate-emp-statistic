<html>
<head>
  <title>编辑院系信息</title>
  <#include "../../common/common_resources.ftl"/>
</head>
<body>
<div class="cont">
  <form class="layui-form layui-form-pane" lay-filter="editForm">
    <input type="hidden" name="id" disabled class="layui-input">
    <div class="layui-form-item">
      <label class="layui-form-label">专业名称</label>
      <div class="layui-input-block">
        <input type="text" name="majorName" class="layui-input" lay-verify="required"/>
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
<script src="${rc.contextPath}/resources/js/school/major/edit.js"></script>
</body>
</html>
