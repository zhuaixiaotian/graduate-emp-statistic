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
      <label class="layui-form-label">所属公司</label>
      <div class="layui-input-inline">
        <select name="companyId" readonly lay-verify="required"></select>
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">岗位名称</label>
      <div class="layui-input-block">
        <input type="text" name="jobName" class="layui-input" lay-verify="required">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">任职要求</label>
      <div class="layui-input-block">
        <textarea name="requirements" lay-verify="required"
                  rows="6"
                  class="layui-textarea">
        </textarea>
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">月薪</label>
      <div class="layui-input-inline">
        <input type="text" name="monthlyPay" class="layui-input" lay-verify="required">
      </div>
      <div class="layui-form-mid layui-word-aux">元</div>
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
<script src="${rc.contextPath}/resources/js/enterprise/job/edit.js"></script>
</body>
</html>
