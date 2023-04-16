<html>
<head>
  <title>系别管理</title>
  <#include "../../common/common_resources.ftl"/>
</head>
<body>
<div class="cont">
  <!--头部按钮区域新增、编辑、搜索-->
  <div class="layui-row text-center mt-d7 header-bar">
    <section class="layui-col-xs2">
      <div class="layui-btn-group">
        <button type="button" class="layui-btn  layui-btn" id="addBtn">
          <i class="layui-icon layui-icon-addition">添加</i>
        </button>
        <button type="button" class="layui-btn  layui-btn" id="editBtn">
          <i class="layui-icon layui-icon-edit">编辑</i>
        </button>
      </div>
    </section>
    <section class="layui-col-xs10">
      <!--必须放在layui-form中，select样式才生效-->
      <form class="layui-form" action="" lay-filter="searchForm" style="margin-top: 5px">
        <!--内联表单在一行的就放在一个layui-form-item里面,各个之间用layui-inline隔开-->
        <section class="layui-form-item">
          <div class="layui-inline">
            <label class="layui-form-label">所属专业:</label>
            <div class="layui-input-inline">
              <select name="majorId" readonly></select>
            </div>
          </div>
          <div class="layui-inline">
            <label class="layui-form-label">毕业年份:</label>
            <div class="layui-input-inline">
              <input type="text" name="graduateYear" id="graduateYear"
                     readonly class="layui-input">
            </div>
          </div>
          <div class="layui-inline">
            <div class="layui-input-inline">
              <input class="layui-input" name="clazzName" placeholder="按班级名模糊检索">
            </div>
            <div class="layui-input-inline">
              <button class="layui-btn" id="searchBtn">
                <i class="layui-icon layui-icon-search">搜索</i>
              </button>
            </div>
          </div>
        </section>
      </form>
    </section>
  </div>
  <!-- 行工具栏 -->
  <script type="text/html" id="operationBar">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
  </script>
  <!--表格区域-->
  <section>
    <table id="table" lay-filter="test"></table>
  </section>
</div>
<script type="text/javascript" src="${rc.contextPath}/resources/js/school/clazz/manage.js"></script>
</body>
</html>
