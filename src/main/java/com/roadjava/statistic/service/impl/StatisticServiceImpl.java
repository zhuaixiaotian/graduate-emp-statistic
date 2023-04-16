package com.roadjava.statistic.service.impl;

import com.roadjava.statistic.bean.co.BarCO;
import com.roadjava.statistic.bean.dto.ChartDTO;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.vo.BarVO;
import com.roadjava.statistic.bean.vo.ClazzVO;
import com.roadjava.statistic.bean.vo.LineVO;
import com.roadjava.statistic.bean.vo.PieVO;
import com.roadjava.statistic.mapper.MajorMapper;
import com.roadjava.statistic.mapper.StatisticMapper;
import com.roadjava.statistic.service.StatisticService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 学生业务类
 *
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Service
@Slf4j
public class StatisticServiceImpl implements StatisticService {
    @Resource
    private StatisticMapper statisticMapper;
    @Resource
    private MajorMapper majorMapper;


    @Override
    public ResultDTO<List<ClazzVO>> selectGraduateYears() {
        List<ClazzVO> list = statisticMapper.selectGraduateYears();
        return ResultDTO.buildSuccess(list);
    }

    @Override
    public ResultDTO<BarVO> loadAllMajorEmpRatioRank(ChartDTO dto) {
        List<BarCO> list = statisticMapper.loadAllMajorEmpRatioRank(dto);
        BarVO vo = new BarVO();
        list.forEach(co -> {
            vo.getXAxisData().add(co.getXAxisName());
            vo.getSeriesData().add(co.getYAxisValue());
        });
        return ResultDTO.buildSuccess(vo);
    }

    @Override
    public ResultDTO<LineVO> loadTrend(ChartDTO dto) {
        if (CollectionUtils.isEmpty(dto.getMajorIds())) {
            return ResultDTO.buildSuccess(new LineVO());
        }
        List<Map<String, Object>> maps = statisticMapper.loadTrend(dto);
        List<String> majorNames = maps.stream()
                .map(map -> map.get("majorName").toString())
                .distinct()
                .collect(Collectors.toList());
        List<String> years = maps.stream()
                .map(map -> map.get("graduateYear").toString())
                .distinct()
                // 年份从低到高排序
                .sorted(Comparator.comparing(Integer::valueOf))
                .collect(Collectors.toList());

        LineVO lineVO = new LineVO();
        lineVO.setLegendData(majorNames);
        lineVO.setXAxisData(years);
        List<Map<String, Object>> series = new ArrayList<>();
        Map<String, List<Map<String, Object>>> majorNameMap = maps.stream()
                .collect(Collectors.groupingBy(map -> map.get("majorName").toString()));

        for (String majorName : majorNames) {
            Map<String, Object> oneSeries = new HashMap<>();
            oneSeries.put("name", majorName);
            oneSeries.put("type", "line");
            oneSeries.put("smooth", true);
            // 每个专业历年就业率
            List<Map<String, Object>> yearRatioList = majorNameMap.get(majorName);
            // 按年份转为map结构
            Map<String, Double> yearRatioMap = yearRatioList.stream()
                    .collect(Collectors.toMap(m -> m.get("graduateYear").toString(),
                            m -> Double.valueOf(m.get("ratio").toString()),
                            (a, b) -> b));
            // 历年就业率
            List<Double> oneSeriesData = new ArrayList<>();
            for (String year : years) {
                // 如果该专业在该年份没有值,则补0,不然数据就错位了
                oneSeriesData.add(yearRatioMap.getOrDefault(year, 0.0d));
            }
            oneSeries.put("data", oneSeriesData);
            series.add(oneSeries);
        }
        lineVO.setSeries(series);
        return ResultDTO.buildSuccess(lineVO);
    }

    @Override
    public ResultDTO<PieVO> loadCompanyRatio(ChartDTO dto) {
        List<Map<String, Object>> list = statisticMapper.loadCompanyRatio(dto);
        // 年份内已就业学生总数
        int hasJobStudentCount = list.stream()
                .mapToInt(map -> Integer.parseInt(map.get("companyHireCount").toString()))
                .sum();
        for (Map<String, Object> map : list) {
            // 企业招聘占比=该企业雇佣人数/年份内已就业学生总数
            double companyRatioDouble = Double.parseDouble(map.get("companyHireCount").toString()) / hasJobStudentCount;
            BigDecimal b = new BigDecimal(String.valueOf(companyRatioDouble*100));
            String companyRatio = b.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
            map.put("value", companyRatio);
        }
        PieVO vo = new PieVO();
        vo.setSeriesData(list);
        return ResultDTO.buildSuccess(vo);
    }

    @Override
    public ResultDTO<PieVO> loadSexRatio(ChartDTO dto) {
        List<Map<String, Object>> list = statisticMapper.loadSexRatio(dto);
        // 年份内已就业学生总数
        int hasJobStudentCount = list.stream()
                .mapToInt(map -> Integer.parseInt(map.get("sexHasJobCount").toString()))
                .sum();
        for (Map<String, Object> map : list) {
            // 某个性别就业占比=该性别就业人数/年份内已就业学生总数
            double companyRatioDouble = Double.parseDouble(map.get("sexHasJobCount").toString()) / hasJobStudentCount;
            BigDecimal b = new BigDecimal(String.valueOf(companyRatioDouble*100));
            String companyRatio = b.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
            map.put("value", companyRatio);
            String name = map.get("name").toString();
            if ("M".equals(name)) {
                map.put("name","男");
            }else {
                map.put("name","女");
            }
        }
        PieVO vo = new PieVO();
        vo.setSeriesData(list);
        return ResultDTO.buildSuccess(vo);
    }
}
