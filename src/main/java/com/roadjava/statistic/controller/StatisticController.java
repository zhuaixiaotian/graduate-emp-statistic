package com.roadjava.statistic.controller;

import com.roadjava.statistic.bean.dto.ChartDTO;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.vo.*;
import com.roadjava.statistic.service.StatisticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学生控制器
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Controller
@RequestMapping("/statistic")
@Slf4j
public class StatisticController {
    @Resource
    private StatisticService statisticService;

    @PostMapping("/selectGraduateYears") @ResponseBody
    public ResultDTO<List<ClazzVO>> selectGraduateYears(){
        return statisticService.selectGraduateYears();
    }

    /**
     * 所有专业就业率排行榜
     */
    @PostMapping("/loadAllMajorEmpRatioRank") @ResponseBody
    public ResultDTO<BarVO> loadAllMajorEmpRatioRank(ChartDTO dto){
        return statisticService.loadAllMajorEmpRatioRank(dto);
    }

    /**
     * 专业历年就业率走势图
     */
    @PostMapping("/loadTrend") @ResponseBody
    public ResultDTO<LineVO> loadTrend(@RequestBody ChartDTO dto){
        return statisticService.loadTrend(dto);
    }

    /**
     * 就业去向分析
     * @param dto
     * @return
     */
    @PostMapping("/loadCompanyRatio") @ResponseBody
    public ResultDTO<PieVO> loadCompanyRatio(ChartDTO dto){
        return statisticService.loadCompanyRatio(dto);
    }

    /**
     * 男女就业率比重统计
     * @param dto
     * @return
     */
    @PostMapping("/loadSexRatio") @ResponseBody
    public ResultDTO<PieVO> loadSexRatio(ChartDTO dto){
        return statisticService.loadSexRatio(dto);
    }
}
