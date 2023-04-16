package com.roadjava.statistic.mapper;

import com.roadjava.statistic.bean.entity.Admin;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
public interface AdminMapper {
    /**
     * 登录
     */
    Admin validateLogin(Admin admin);
}
