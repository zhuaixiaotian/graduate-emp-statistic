package com.roadjava.statistic.bean.vo;

import lombok.Data;

/**
 * 系别返回前端的视图对象
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Data
public class MajorVO {
    /**
     * 主键
     */
    private Long id;
    /**
     * 专业名称
     */
    private String majorName;
}
