package com.roadjava.statistic.bean.entity;

import lombok.Data;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
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
