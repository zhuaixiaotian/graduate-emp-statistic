<html>
<head>
  <title>统计分析</title>
    <#include "../common/common_resources.ftl"/>
</head>
<body>
<section class="layui-row">
  <div class="layui-col-xs12">
    <div class="layui-col-xs4 layui-col-xs-offset4">
      <form class="layui-form" action="" lay-filter="rankSearchForm" style="margin-top: 5px">
        <div class="layui-form-item">
          <label class="layui-form-label">统计年份:</label>
          <div class="layui-input-inline">
            <select name="graduateYear" lay-filter="rankGraduateYear"></select>
          </div>
        </div>
      </form>
    </div>
  </div>
</section>
<div class="layui-row">
  <div class="layui-col-xs12 " style="height:500px;" id="rank"></div>
</div>
<hr style="border-bottom: 1px solid #aaaaaa !important;"/>
<section class="layui-row">
  <form class="layui-form" action="" lay-filter="trendSearchForm">
    <div class="layui-form-item" pane="">
      <label class="layui-form-label">统计专业:</label>
      <div class="layui-input-block" id="trendMajorCheckboxContainer">
      </div>
    </div>
  </form>
</section>
<div class="layui-row">
  <div class="layui-col-xs12" style="height:500px;" id="trend"></div>
</div>
<hr style="border-bottom: 1px solid #aaaaaa !important;"/>
<div class="layui-row">
  <div class="layui-col-xs6" >
    <!--居中-->
    <section class="layui-row">
      <div class="layui-col-xs6 layui-col-xs-offset3">
        <form class="layui-form" action="" lay-filter="companySearchForm" style="margin-top: 5px">
          <div class="layui-form-item">
            <label class="layui-form-label">统计年份:</label>
            <div class="layui-input-inline">
              <select name="graduateYear" lay-filter="companyGraduateYear"></select>
            </div>
          </div>
        </form>
      </div>
    </section>
    <div style="height:500px;" id="companyRatio"></div>
  </div>
  <div class="layui-col-xs5">
    <section class="layui-row">
      <div class="layui-col-xs8 layui-col-xs-offset3">
        <form class="layui-form" action="" lay-filter="sexSearchForm" style="margin-top: 5px">
          <div class="layui-form-item">
            <label class="layui-form-label">统计年份:</label>
            <div class="layui-input-inline">
              <select name="graduateYear" lay-filter="sexGraduateYear"></select>
            </div>
          </div>
        </form>
      </div>
    </section>
    <div style="height:500px;" id="sexEmpRatio"></div>
  </div>
</div>
<script type="text/javascript" src="${rc.contextPath}/resources/js/statistic/statistic.js"></script>
</body>
</html>
