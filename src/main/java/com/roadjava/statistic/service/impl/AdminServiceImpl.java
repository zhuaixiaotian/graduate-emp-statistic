package com.roadjava.statistic.service.impl;

import com.roadjava.statistic.bean.entity.Admin;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.mapper.AdminMapper;
import com.roadjava.statistic.service.AdminService;
import com.roadjava.statistic.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    @Override
    public ResultDTO<Admin> login(Admin admin) {
        Admin result = adminMapper.validateLogin(admin);
        if (result == null) {
            return ResultDTO.buildFailure("用户名或密码不正确");
        }else {
            return ResultDTO.buildSuccess(result);
        }
    }
}
