package com.roadjava.statistic.service.impl;

import com.roadjava.statistic.bean.entity.Admin;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.mapper.AdminMapper;
import com.roadjava.statistic.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;
    @Override
    public ResultDTO<Admin> login(Admin admin) {
        // 密码密文校验
        admin.setPwd(DigestUtils.md5DigestAsHex(admin.getPwd().getBytes()));
        log.info("密文--------------{}",admin.getPwd());
        Admin result = adminMapper.validateLogin(admin);
        if (result == null) {
            return ResultDTO.buildFailure("用户名或密码不正确");
        }else {
            return ResultDTO.buildSuccess(result);
        }
    }
}
