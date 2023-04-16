package com.roadjava.statistic.service;

import com.roadjava.statistic.bean.dto.ChartDTO;
import com.roadjava.statistic.bean.dto.StudentJobDTO;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.vo.BarVO;
import com.roadjava.statistic.bean.vo.ClazzVO;
import com.roadjava.statistic.bean.vo.LineVO;
import com.roadjava.statistic.bean.vo.PieVO;

import java.util.List;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
public interface StatisticService {
    /**
     * 查询所有的毕业年份
     * @return
     */
    ResultDTO<List<ClazzVO>> selectGraduateYears();

    ResultDTO<BarVO> loadAllMajorEmpRatioRank(ChartDTO dto);

    ResultDTO<LineVO> loadTrend(ChartDTO dto);

    ResultDTO<PieVO> loadCompanyRatio(ChartDTO dto);

    ResultDTO<PieVO> loadSexRatio(ChartDTO dto);
}
