package com.roadjava.statistic.bean.dto;

import com.roadjava.statistic.util.Constants;
import lombok.Data;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Data
public abstract class BaseDTO {
    /**
     * 当前是第几页
     */
    private Integer pageNow;
    /**
     * 每页展示多少条
     */
    private Integer pageSize;

    /**
     * limit 0,10
     * @return
     */
    public Integer getStart() {
        if (getPageNow() == null) {
            return null;
        }
        return (getPageNow() - 1) * getPageSize();
    }

    public Integer getPageSize() {
        return pageSize != null ? pageSize : Constants.PAGE_SIZE;
    }
}
