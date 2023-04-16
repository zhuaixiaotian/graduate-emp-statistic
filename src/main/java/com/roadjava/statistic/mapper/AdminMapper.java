package com.roadjava.statistic.mapper;

import com.roadjava.statistic.bean.entity.Admin;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
public interface AdminMapper {
    /**
     * 登录
     */
    Admin validateLogin(Admin admin);
}
