package com.roadjava.statistic.controller;

import com.roadjava.statistic.bean.dto.StudentJobDTO;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.service.StudentJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 学生控制器
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Controller
@RequestMapping("/studentJob")
@Slf4j
public class StudentJobController {
    @Resource
    private StudentJobService studentJobService;

    @PostMapping("/add") @ResponseBody
    public ResultDTO<String> add(StudentJobDTO dto){
        return studentJobService.add(dto);
    }
    /**
     * 根据id删除
     */
    @PostMapping("/deleteById") @ResponseBody
    public ResultDTO<String> deleteById(@RequestParam("idToDelete") Long id){
        if (id == null) {
            return ResultDTO.buildFailure("id必传");
        }
        return studentJobService.deleteById(id);
    }
}
