package com.roadjava.statistic.bean.entity;

import lombok.Data;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Data
public class Admin {
    private Long id;
    /**
     * 管理员账号
     */
    private String userName;
    /**
     * 密码
     */
    private String pwd;
}
