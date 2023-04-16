package com.roadjava.statistic.bean.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 岗位视图对象
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Data
public class JobVO {
    /**
     * 主键
     */
    private Long id;
    /**
     * 岗位名称
     */
    private String jobName;
    /**
     * 任职要求
     */
    private String requirements;
    /**
     * 月薪,单位:元
     */
    private BigDecimal monthlyPay;
    /**
     * 公司id
     */
    private Long companyId;
    /**
     * 公司名称
     */
    private String companyName;
}
