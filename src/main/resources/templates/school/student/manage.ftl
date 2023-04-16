<html>
<head>
  <title>系别管理</title>
  <#include "../../common/common_resources.ftl"/>
</head>
<body>
<section class="d-none" id="addStudentJobDia">
  <form class="layui-form layui-form-pane" lay-filter="addStudentJobForm">
    <!--每次打开弹窗时设置要被增加就业信息的学生id-->
    <input type="hidden" name="studentId"/>
    <!--每次打开弹窗时弹窗的索引id-->
    <input type="hidden" name="dialogId"/>
    <div class="layui-form-item mt-d7">
      <label class="layui-form-label">入职公司</label>
      <div class="layui-input-block">
        <select name="companyId" lay-filter="companySelect"></select>
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">就职岗位</label>
      <div class="layui-input-block">
        <select name="jobId"></select>
      </div>
    </div>
    <div class="layui-form-item">
      <div class="layui-input-block">
        <button type="submit" class="layui-btn" lay-submit lay-filter="confirmAddStudentJobBtn">确认</button>
      </div>
    </div>
  </form>
</section>
<div class="cont">
  <!--头部按钮区域新增、编辑、搜索-->
  <div class="header-bar">
    <!--必须放在layui-form中，select样式才生效-->
    <form class="layui-form" action="" lay-filter="searchForm" style="margin-top: 5px">
      <!--多个条件按row和col布局,比layui-inline更通用-->
      <section class="layui-row">
        <div class="layui-col-xs4">
          <label class="layui-form-label">毕业年份:</label>
          <div class="layui-input-inline">
            <input type="text" name="graduateYear" id="graduateYear"
                   readonly class="layui-input">
          </div>
        </div>
        <div class="layui-col-xs4">
          <label class="layui-form-label">所属专业:</label>
          <div class="layui-input-inline">
            <select name="majorId" readonly></select>
          </div>
        </div>
        <div class="layui-col-xs4">
          <label class="layui-form-label">性别:</label>
          <div class="layui-input-inline">
            <select name="sex">
              <option value="">--全部--</option>
              <option value="M">男</option>
              <option value="F">女</option>
            </select>
          </div>
        </div>
      </section>
      <section class="layui-row mt-d7">
        <div class="layui-col-xs4">
          <label class="layui-form-label">学生姓名:</label>
          <div class="layui-input-inline">
            <input class="layui-input" name="studentName" placeholder="按学生姓名模糊检索"/>
          </div>
        </div>
        <div class="layui-col-xs4">
          <label class="layui-form-label">就业情况:</label>
          <div class="layui-input-inline">
            <select name="hasJob">
              <option value="">--全部--</option>
              <option value="Y">已就业</option>
              <option value="N">尚未就业</option>
            </select>
          </div>
        </div>
        <div class="layui-col-xs4">
          <div class="layui-inline" style="padding-left: 30px">
            <button class="layui-btn" id="searchBtn">
              <i class="layui-icon layui-icon-search">搜索</i>
            </button>
            <button type="button" class="layui-btn  layui-btn" id="addBtn">
              <i class="layui-icon layui-icon-addition">添加</i>
            </button>
            <button type="button" class="layui-btn  layui-btn" id="editBtn">
              <i class="layui-icon layui-icon-edit">编辑</i>
            </button>
          </div>
        </div>
      </section>
    </form>
  </div>
  <!-- 行工具栏 -->
  <script type="text/html" id="operationBar">
    {{#  if(d.studentJobId){ }}
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delStudentJob">删除就业信息</a>
    {{#  } else { }}
      <a class="layui-btn layui-btn-xs" lay-event="openAddStudentJobDia">增加就业信息</a>
    {{#  } }}
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
  </script>
  <!--表格区域-->
  <section>
    <table id="table" lay-filter="test"></table>
  </section>
</div>
<script type="text/javascript" src="${rc.contextPath}/resources/js/school/student/manage.js"></script>
</body>
</html>
