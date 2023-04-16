package com.roadjava.statistic.bean.vo;

import lombok.Data;

/**
 * 公司前端视图对象
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
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
