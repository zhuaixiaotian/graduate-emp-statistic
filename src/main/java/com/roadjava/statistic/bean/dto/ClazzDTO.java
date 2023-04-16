package com.roadjava.statistic.bean.dto;

import com.roadjava.statistic.bean.entity.Clazz;
import com.roadjava.statistic.bean.entity.Major;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * 班级信息
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Data
public class ClazzDTO extends BaseDTO{
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

    public Clazz toEntity() {
        Clazz entity = new Clazz();
        BeanUtils.copyProperties(this,entity);
        return entity;
    }
}
