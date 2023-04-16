layui.use(['form', 'jquery','layer'], function(form,$,layer){
  /*
   * 专业就业率排行榜
   */
  // 年份选择条件
  $.ajax({
    url:'/statistic/selectGraduateYears',
    method:'post',
    success:function (result) {
      if (!result.success) {
        return;
      }
      var arr = result.data;
      var html = buildOptionHtml(arr,"graduateYear","graduateYear",true);
      $("select[name=graduateYear]").html(html);
      // 动态插入的表单需要重新渲染
      form.render("select","rankSearchForm");
      form.render("select","companySearchForm");
      form.render("select","sexSearchForm");
      if (arr && arr.length > 0) {
        loadRankChart(arr[0]["graduateYear"]);
        loadCompanyRatio(arr[0]["graduateYear"]);
        loadSexEmpRatio(arr[0]["graduateYear"]);
      }
    }
  });
  // 排行榜年份选择条件变化时
  form.on('select(rankGraduateYear)', function(data){
    var selectedValue = data.value; //得到被选中的值
    updateRank(selectedValue);
  });
  // 就业去向年份变化时
  form.on('select(companyGraduateYear)', function(data){
    var selectedValue = data.value; //得到被选中的值
    updateCompanyRatio(selectedValue);
  });
  // 性别占比年份变化时
  form.on('select(sexGraduateYear)', function(data){
    var selectedValue = data.value; //得到被选中的值
    updateSexRatio(selectedValue);
  });
  var rankChart;
  function loadRankChart(graduateYear) {
    // 基于准备好的dom，初始化echarts实例
    rankChart = echarts.init(document.getElementById('rank'));
    // 指定图表的配置项和数据
    var option = {
      title: {
        text: '专业就业率排行榜',
        subtext: "展示所有专业的就业率,就业率统计口径:专业内已就业人数/专业总人数",
        padding:[10,10,10,20],
        textStyle:{
          color:'#5FB878'
        },
        subtextStyle:{
          color:'#888'
        }
      },
      tooltip: {
        // {a}:系列名 {b}:x轴的值  {c}:y轴的值
        formatter:'{b}的就业率:{c}%'
      },
      grid:{
        show:true,
        top:90 //坐标系距离整个chart顶部90px
      },
      legend: {
        show:false
      },
      xAxis: {
        name:'专业名称',
        data: ['a','b']
      },
      yAxis: {
        type:'value',
        name:'就业率%',
        axisLine:{
          show:true // 显示y轴坐标轴线
        }
      },
      series: [{
        name:'series-rank',
        type: 'bar',
        data: [1,2.3],
        // 设置柱条宽度,避免过少时很宽;过多时重叠
        barMaxWidth:40
      }]
    };
// 使用刚指定的配置项和数据显示图表。
    rankChart.setOption(option);
    updateRank(graduateYear);
  }
  function updateRank(graduateYear) {
    $.ajax({
      url:'/statistic/loadAllMajorEmpRatioRank',
      method:'post',
      data:{"graduateYear":graduateYear},
      success:function (result) {
        if (!result.success) {
          return;
        }
        rankChart.setOption({
          xAxis: {
            data: result.data.xAxisData
          },
          series: [{
            name: 'series-rank',
            data: result.data.seriesData
          }]
        });
      }
    });
  }
  /*
  专业历年就业率走势图
   */
  // 专业复选框选择条件
  $.ajax({
    url:'/major/selectAll',
    method:'post',
    success:function (result) {
      if (!result.success) {
        return;
      }
      var arr = result.data;
      var html = buildCheckboxHtml(arr,"id","majorName",true,"majorId");
      $("#trendMajorCheckboxContainer").html(html);
      // 动态插入的表单需要重新渲染
      form.render("checkbox","trendSearchForm");
      if (arr && arr.length > 0) {
        loadTrend(getMajorCheckboxSelected());
      }
    }
  });
  // 使用form.val("trendSearchForm")获取到的复选框不好用
  function getMajorCheckboxSelected() {
    var selectedIds=[];
    $('input[name=majorId]:checked').each(function(){
      selectedIds.push($(this).val());
    });
    return selectedIds;
  }
  // 复选框选择条件变化时
  form.on('checkbox(trendMajorInput)', function(data){
    var selectedValue = data.value; //得到被选中的值
    updateTrend(getMajorCheckboxSelected());
  });
  var trendChart;
  var trendOption;
  function loadTrend(majorIds) {
    trendChart = echarts.init(document.getElementById('trend'));
    trendOption = {
      title: {
        text: '专业历年就业率走势图',
        subtext: "专业在所有年份的就业率统计,就业率统计口径:专业内已就业人数/专业总人数",
        padding:[10,10,10,20],
        textStyle:{
          color:'#5FB878'
        },
        subtextStyle:{
          color:'#888'
        }
      },
      tooltip: {
        formatter:'{b}年{a}的就业率:{c}%'
      },
      grid:{
        show:true,
        top:90 //坐标系距离整个chart顶部90px
      },
      legend: {
        data:['x专业']
      },
      xAxis: {
        name:'年份',
        type: 'category',
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
      },
      yAxis: {
        type: 'value',
        name:'就业率%',
        axisLine:{
          show:true // 显示y轴坐标轴线
        }
      },
      series: [{
        name:'x专业',
        data: [820, 932, 901, 934, 1290, 1330, 1320],
        type: 'line',
        smooth: true
      }]
    };
    // true:表示不进行合并,全部更新，老的删除
    trendChart.setOption(trendOption,true);
    updateTrend(majorIds);
  }
  function updateTrend(majorIds) {
    $.ajax({
      url:'/statistic/loadTrend',
      method:'post',
      contentType:"application/json",
      data:JSON.stringify({"majorIds":majorIds}),
      success:function (result) {
        if (!result.success) {
          return;
        }
        trendOption.legend.data = result.data.legendData;
        trendOption.xAxis.data = result.data.xAxisData;
        trendOption.series = result.data.series;
        // 设置真实数据
        trendChart.setOption(trendOption,true);
      }
    });
  }
  /**
   * 加载就业去向分析
   */
  var companyRatioChart;
  function loadCompanyRatio(graduateYear) {
    companyRatioChart = echarts.init(document.getElementById('companyRatio'));
    var option = {
      title: {
        text: '就业去向分析',
        subtext: '各个公司招聘所占比重,比重统计口径:该公司就业人数/就业总人数',
        left: 'center'
      },
      tooltip: {
        trigger: 'item'
      },
      legend: {
        orient: 'vertical',
        left: 'left',
      },
      series: [
        {
          name: '就业去向分析',
          type: 'pie',
          radius: '50%',
          data: [
            {value: 1048, name: '搜索引擎'},
            {value: 735, name: '直接访问'},
            {value: 580, name: '邮件营销'},
            {value: 484, name: '联盟广告'},
            {value: 300, name: '视频广告'}
          ],
          emphasis: {
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
          }
        }
      ]
    };
    companyRatioChart.setOption(option);
    updateCompanyRatio(graduateYear);
  }
  function updateCompanyRatio(graduateYear) {
    $.ajax({
      url:'/statistic/loadCompanyRatio',
      method:'post',
      data:{"graduateYear":graduateYear},
      success:function (result) {
        if (!result.success) {
          return;
        }
        companyRatioChart.setOption({
          series: [{
            name: '就业去向分析',
            data: result.data.seriesData
          }]
        });
      }
    });
  }
  /**
   * 加载男女就业率比重统计
   */
  var sexRatioChart;
  function loadSexEmpRatio(graduateYear) {
    sexRatioChart = echarts.init(document.getElementById('sexEmpRatio'));
    var option = {
      title: {
        text: '男女就业率比重统计',
        subtext: '男女就业率比重统计口径:某个性别就业人数/就业总人数',
        left: 'center'
      },
      tooltip: {
        trigger: 'item'
      },
      legend: {
        orient: 'vertical',
        left: 'left',
      },
      series: [
        {
          name: '男女就业率比重统计',
          type: 'pie',
          radius: '50%',
          data: [
            {value: 1048, name: '搜索引擎'},
            {value: 735, name: '直接访问'},
            {value: 580, name: '邮件营销'},
            {value: 484, name: '联盟广告'},
            {value: 300, name: '视频广告'}
          ],
          emphasis: {
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
          }
        }
      ]
    };
    sexRatioChart.setOption(option);
    updateSexRatio(graduateYear);
  }
  function updateSexRatio(graduateYear) {
    $.ajax({
      url:'/statistic/loadSexRatio',
      method:'post',
      data:{"graduateYear":graduateYear},
      success:function (result) {
        if (!result.success) {
          return;
        }
        sexRatioChart.setOption({
          series: [{
            name: '男女就业率比重统计',
            data: result.data.seriesData
          }]
        });
      }
    });
  }
});
