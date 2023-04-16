package com.roadjava.statistic.bean.entity;

import lombok.Data;

/**
 * 学生信息
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Data
public class Student {
    /**
     * 主键
     */
    private Long id;
    /**
     * 学生名称
     */
    private String studentName;
    /**
     * 性别: M:男 F:女
     */
    private String sex;
    /**
     * 班级id
     */
    private Long clazzId;
}
