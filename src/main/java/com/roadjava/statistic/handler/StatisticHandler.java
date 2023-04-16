package com.roadjava.statistic.handler;

import com.roadjava.statistic.bean.dto.ChartDTO;
import com.roadjava.statistic.bean.dto.StudentDTO;
import com.roadjava.statistic.bean.dto.StudentJobDTO;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.res.TableResult;
import com.roadjava.statistic.bean.vo.*;
import com.roadjava.statistic.service.StatisticService;
import com.roadjava.statistic.service.StudentJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学生控制器
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Controller
@RequestMapping("/statistic")
@Slf4j
public class StatisticHandler {
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
