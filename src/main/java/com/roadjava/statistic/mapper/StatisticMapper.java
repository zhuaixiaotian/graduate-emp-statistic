package com.roadjava.statistic.mapper;

import com.roadjava.statistic.bean.co.BarCO;
import com.roadjava.statistic.bean.dto.ChartDTO;
import com.roadjava.statistic.bean.vo.ClazzVO;

import java.util.List;
import java.util.Map;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
public interface StatisticMapper {
    List<ClazzVO> selectGraduateYears();

    List<BarCO> loadAllMajorEmpRatioRank(ChartDTO dto);

    List<Map<String,Object>> loadTrend(ChartDTO dto);

    List<Map<String, Object>> loadCompanyRatio(ChartDTO dto);
    List<Map<String, Object>> loadSexRatio(ChartDTO dto);
}
