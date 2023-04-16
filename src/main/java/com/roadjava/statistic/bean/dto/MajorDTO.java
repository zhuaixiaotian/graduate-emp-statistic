package com.roadjava.statistic.bean.dto;

import com.roadjava.statistic.bean.entity.Major;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Data
public class MajorDTO extends BaseDTO{
    /**
     * 主键
     */
    private Long id;
    /**
     * 专业名称
     */
    private String majorName;

    public Major toEntity() {
        Major entity = new Major();
        BeanUtils.copyProperties(this,entity);
        return entity;
    }
}
