package com.roadjava.statistic.controller;

import com.roadjava.statistic.bean.entity.Admin;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.service.AdminService;
import com.roadjava.statistic.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 管理员控制器
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Controller
public class AdminController {
    @Resource
    private AdminService adminService;

    @GetMapping(value = {"/", ""})
    public String toLogin() {
        return "login";
    }
    /**
     * 登录
     */
    @PostMapping("/login") @ResponseBody
    public ResultDTO<String> login(Admin admin,HttpSession session) {
        // 校验登录
        ResultDTO<Admin> resultDTO = adminService.login(admin);
        if (resultDTO.getSuccess()) {
            Admin data = resultDTO.getData();
            session.setAttribute(Constants.USER_SESSION_KEY,data);
            return ResultDTO.buildSuccess("登录成功");
        }else {
            return ResultDTO.buildFailure(resultDTO.getErrMsg());
        }
    }

    @GetMapping("/toMain")
    public String toMain() {
        return "main";
    }
    /**
     * 退出登录
     */
    @GetMapping("/logout")
    public String login(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
