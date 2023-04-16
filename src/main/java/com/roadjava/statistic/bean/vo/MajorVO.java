package com.roadjava.statistic.bean.vo;

import lombok.Data;

/**
 * 系别返回前端的视图对象
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
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
