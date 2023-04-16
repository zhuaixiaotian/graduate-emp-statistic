package com.roadjava.statistic.bean.dto;

import com.roadjava.statistic.bean.entity.Clazz;
import com.roadjava.statistic.bean.entity.Job;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

/**
 * 岗位信息
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Data
public class JobDTO extends BaseDTO{
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

    public Job toEntity() {
        Job entity = new Job();
        BeanUtils.copyProperties(this,entity);
        return entity;
    }
}
