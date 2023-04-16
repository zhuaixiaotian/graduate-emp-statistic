package com.roadjava.statistic.bean.entity;

import lombok.Data;

/**
 * 学生就业信息实体类
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
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
