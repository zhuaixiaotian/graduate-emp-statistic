package com.roadjava.statistic.bean.vo;

import lombok.Data;

/**
 * 学生视图对象
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Data
public class StudentVO {
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
    /**
     * student_job主键
     */
    private Long studentJobId;
    /**
     * 岗位名称
     */
    private String jobName;
    /**
     * 公司名称
     */
    private String companyName;
}
