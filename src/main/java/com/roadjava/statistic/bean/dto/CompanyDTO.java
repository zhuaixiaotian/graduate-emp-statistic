package com.roadjava.statistic.bean.dto;

import com.roadjava.statistic.bean.entity.Company;
import com.roadjava.statistic.bean.entity.Major;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Data
public class CompanyDTO extends BaseDTO {
    /**
     * 主键
     */
    private Long id;
    /**
     * 公司名
     */
    private String companyName;

    public Company toEntity() {
        Company entity = new Company();
        BeanUtils.copyProperties(this,entity);
        return entity;
    }
}
