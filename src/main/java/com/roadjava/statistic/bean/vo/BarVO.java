package com.roadjava.statistic.bean.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 柱状图视图对象
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Data
public class BarVO {
    /**
     * jackson默认返回的xaxisData
     */
    @JsonProperty("xAxisData")
    private List<String> xAxisData = new ArrayList<>();
    private List<Double> seriesData = new ArrayList<>();
}
