package com.roadjava.statistic.bean.entity;

import lombok.Data;

/**
 * 学生就业信息实体类
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Data
public class StudentJob {
    /**
     * 主键
     */
    private Long id;
    /**
     * 学生id
     */
    private Long studentId;
    /**
     * 岗位id
     */
    private Long jobId;
}
