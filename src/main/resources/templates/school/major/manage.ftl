<html>
<head>
  <title>系别管理</title>
  <#include "../../common/common_resources.ftl"/>
</head>
<body>
<div class="cont">
  <!--头部按钮区域新增、编辑、搜索-->
  <div class="layui-row text-center mt-d7 header-bar">
    <section class="layui-col-xs5">
      <div class="layui-btn-group">
        <button type="button" class="layui-btn  layui-btn" id="addBtn">
          <i class="layui-icon layui-icon-addition">添加</i>
        </button>
        <button type="button" class="layui-btn  layui-btn" id="editBtn">
          <i class="layui-icon layui-icon-edit">编辑</i>
        </button>
      </div>
    </section>
    <section class="layui-col-xs7">
      <!--必须放在layui-form中，select样式才生效-->
      <form class="layui-form" action="" lay-filter="searchForm" style="margin-top: 5px">
        <div class="layui-inline">
          <section class="layui-form-item">
            <div class="layui-input-inline">
              <input class="layui-input" name="majorName" placeholder="按专业名称模糊搜索">
            </div>
            <div class="layui-input-inline">
              <button class="layui-btn" id="searchBtn">
                <i class="layui-icon layui-icon-search">搜索</i>
              </button>
            </div>
          </section>
        </div>
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
<script type="text/javascript" src="${rc.contextPath}/resources/js/school/major/manage.js"></script>
</body>
</html>
