package com.roadjava.statistic.bean.entity;

import lombok.Data;

/**
 * 学生信息
 * @author 时天晔
 * @data: 2023/4/16
 * description:
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
