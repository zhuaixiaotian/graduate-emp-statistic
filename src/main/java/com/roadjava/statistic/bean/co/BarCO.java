package com.roadjava.statistic.bean.co;

import lombok.Data;

/**
 * 柱状图返回视图前的中间中转对象
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Data
public class BarCO {
    /**
     * 如: majorName
     */
    private String xAxisName;
    /**
     * 如: majorEmpRatio
     */
    private Double yAxisValue;
}
