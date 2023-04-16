<html lang="zh-CN">
<head>
  <title>毕业生就业统计</title>
  <#include "common/common_resources.ftl">
</head>
<body>
<div id="main" class="layui-layout layui-layout-admin">
  <header class="layui-header">
    <div class="layui-logo layui-hide-xs layui-bg-black">
      毕业生就业统计
    </div>
    <!-- 头部区域（可配合layui 已有的水平导航） -->
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item layui-hide layui-show-md-inline-block">
        <a href="javascript:;">
          你好,${Session.user.userName}
        </a>
        <dl class="layui-nav-child">
          <dd><a href="${rc.contextPath}/logout">退出</a></dd>
        </dl>
      </li>
    </ul>
  </header>
  <aside class="layui-side layui-bg-black">
    <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
    <ul class="layui-nav layui-nav-tree" lay-filter="test">
      <li class="layui-nav-item layui-this">
        <a href="${rc.contextPath}/statistic/toManage" target="main">统计分析</a>
      </li>
      <li class="layui-nav-item layui-nav-itemed">
        <a href="javascript:;">学校基础数据</a>
        <dl class="layui-nav-child">
          <dd>
            <a href="${rc.contextPath}/major/toManage" target="main">
              专业管理
            </a>
          </dd>
          <dd>
            <a href="${rc.contextPath}/clazz/toManage" target="main">
              班级管理
            </a>
          </dd>
          <dd>
            <a href="${rc.contextPath}/student/toManage" target="main">
              学生管理
            </a>
          </dd>
        </dl>
      </li>
      <li class="layui-nav-item layui-nav-itemed">
        <a href="javascript:;">企业基础数据</a>
        <dl class="layui-nav-child">
          <dd>
            <a href="${rc.contextPath}/company/toManage" target="main">
              公司管理
            </a>
          </dd>
          <dd>
            <a href="${rc.contextPath}/job/toManage" target="main">
              岗位管理
            </a>
          </dd>
        </dl>
      </li>
    </ul>
  </aside>
  <main  class="layui-body">
    <iframe src="${rc.contextPath}/statistic/toManage" name="main"
            height="100%" width="100%" frameborder="0" scrolling="auto">
    </iframe>
  </main>
  <#include "common/footer.ftl">
</div>
</body>
</html>
