package com.roadjava.statistic.bean.entity;

import lombok.Data;

/**
 * 班级信息
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Data
public class Clazz {
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
}
