package com.roadjava.statistic.ex;

import com.roadjava.statistic.bean.res.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常拦截
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@ControllerAdvice
@Slf4j
public class ExAdvice {

    /**
     * 处理未精准匹配的异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultDTO<String> handleEx(Exception e) {
        log.error("统一异常处理:",e);
        return ResultDTO.buildFailure("系统运行出错,请联系工作人员排查");
    }
}
