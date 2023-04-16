package com.roadjava.statistic.bean.vo;

import lombok.Data;

/**
 * 公司前端视图对象
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Data
public class CompanyVO {
    /**
     * 主键
     */
    private Long id;
    /**
     * 公司名
     */
    private String companyName;
}
