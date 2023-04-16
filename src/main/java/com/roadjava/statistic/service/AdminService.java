package com.roadjava.statistic.service;

import com.roadjava.statistic.bean.entity.Admin;
import com.roadjava.statistic.bean.res.ResultDTO;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
public interface AdminService {
    /**
     * 登录
     * @param admin
     * @return
     */
    ResultDTO<Admin> login(Admin admin);
}
