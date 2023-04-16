package com.roadjava.statistic.bean.dto;

import lombok.Data;

import java.util.List;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Data
public class ChartDTO {
    private Integer graduateYear;
    private List<Long> majorIds;
}
