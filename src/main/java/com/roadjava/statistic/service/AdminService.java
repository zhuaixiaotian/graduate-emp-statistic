package com.roadjava.statistic.service;

import com.roadjava.statistic.bean.entity.Admin;
import com.roadjava.statistic.bean.res.ResultDTO;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
public interface AdminService {
    /**
     * 登录
     * @param admin
     * @return
     */
    ResultDTO<Admin> login(Admin admin);
}
