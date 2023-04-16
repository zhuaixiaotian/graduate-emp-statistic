package com.roadjava.statistic.bean.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 柱状图视图对象
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Data
public class LineVO {
    /**
     * 和系列的名字一一对应,如:a专业,b专业
     */
    private List<String> legendData = new ArrayList<>();
    /**
     * x轴的数据,如:2012,2013
     */
    @JsonProperty("xAxisData")
    private List<String> xAxisData = new ArrayList<>();
    /**
     * 折线图的系列,每一个系列的结构如下:
     * map
     *  key:value
     *   name:系列名,如:a专业,b专业
     *   data:数据列表,如就业率:30,40
     *   type:line
     *   smooth:true
     */
    private List<Map<String,Object>> series = new ArrayList<>();
}
