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
public class PieVO {
    /**
     * {value: 1048, name: '搜索引擎'}
     */
    private List<Map<String,Object>> seriesData;
}
