package com.roadjava.statistic.bean.dto;

import lombok.Data;

import java.util.List;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Data
public class ChartDTO {
    private Integer graduateYear;
    private List<Long> majorIds;
}
