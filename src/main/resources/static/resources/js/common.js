/**
 * 完成layui table tr单击选中行首复选框的功能
 */
function registerTrClick($) {
  $(document).on("click",".layui-table-body table.layui-table tbody tr", function () {
    var index = $(this).attr('data-index');//获取当前行的data-index备用
    var tableDiv = $(this).parents(".layui-table-body.layui-table-main");
    var checkCell = tableDiv.find("tr[data-index=" + index + "]").find("td div.laytable-cell-checkbox div.layui-form-checkbox i");
    if (checkCell) {
      checkCell.click();
    }
  });

  $(document).on("click", "td div.laytable-cell-checkbox div.layui-form-checkbox", function (e) {
    return false;
  });
}

/**
 * 生成select 选择框的option标签
 * @param arr 要操作的array
 * @param valueName option的value属性的值要用arr里元素的哪个属性
 * @param textName option的文本要用arr里元素的哪个属性
 * @param selectedFirst 是否选中第一个,true:用于新增  false:用于回显
 */
function buildOptionHtml(arr,valueName,textName,selectedFirst) {
  if (!arr) {
    return "";
  }
  var len = arr.length;
  var html='';
  for (var i = 0;i<len;i++) {
    var one = arr[i];
    if (i === 0) {
      if (selectedFirst) {
        html += '<option value='+one[valueName]+' selected>'+one[textName]+'</option>';
      }else {
        html += '<option value='+one[valueName]+'>'+one[textName]+'</option>';
      }
    } else {
      html += '<option value='+one[valueName]+'>'+one[textName]+'</option>';
    }
  }
  return html;
}
/**
 * 生成checkbox 复选框
 * @param arr 要操作的array
 * @param valueName option的value属性的值要用arr里元素的哪个属性
 * @param textName option的文本要用arr里元素的哪个属性
 * @param selected 是否选中
 * @param fieldItemName name属性的值
 */
function buildCheckboxHtml(arr,valueName,textName,selected,fieldItemName) {
  if (!arr) {
    return "";
  }
  var len = arr.length;
  var html='';
  for (var i = 0;i<len;i++) {
    var one = arr[i];
    if (selected) {
      html += '<input type="checkbox" lay-skin="primary"  lay-filter="trendMajorInput" name="'+fieldItemName+'" title="'+one[textName]+'" value="'+one[valueName]+'" checked/>';
    } else {
      html += '<input type="checkbox" lay-skin="primary" lay-filter="trendMajorInput" name="'+fieldItemName+'" title="'+one[textName]+'" value="'+one[valueName]+'"/>';
    }
  }
  return html;
}


// layui 表格通用配置
var tbDefaultOptions = {
  elem: '#table'
  // 不指定的话就用elem对应元素的id:table
  , id:"tb"
  // 高度为屏幕高度-70px
  ,height: 'full-70'
  , method: "post"
  , page: true
  , cellMinWidth: 80
  , even:true
  ,parseData: function (res) { //res 即url返回的数据
    return {
      "code": res.success ? 0 : -1, //解析接口状态
      "msg": "正在解析...", //解析提示文本
      "count": res.data.totalCount, // 总条数
      "data": res.data.rows //解析数据列表
    };
  },
  request: {
    pageName: 'pageNow', //页码的参数名称，默认：page
    limitName: 'pageSize' //每页数据量的参数名，默认：limit
  }
};