package com.roadjava.statistic.bean.vo;

import lombok.Data;

/**
 * 班级信息
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Data
public class ClazzVO {
    /**
     * 主键
     */
    private Long id;
    /**
     * 班级名称
     */
    private String clazzName;
    /**
     * 毕业年份,第几届,格式:yyyy
     */
    private Integer graduateYear;
    /**
     * 专业id
     */
    private Long majorId;
    /**
     * 专业名称
     */
    private String majorName;
}
