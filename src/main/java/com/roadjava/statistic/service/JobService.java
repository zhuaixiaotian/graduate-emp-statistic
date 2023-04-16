package com.roadjava.statistic.service;

import com.roadjava.statistic.bean.dto.JobDTO;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.vo.JobVO;

import java.util.List;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
public interface JobService {
    /**
     * 加载表格
     * @param dto
     * @return
     */
    ResultDTO<List<JobVO>> loadTable(JobDTO dto);

    /**
     * 新增
     * @param dto
     * @return
     */
    ResultDTO<String> add(JobDTO dto);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    ResultDTO<String> deleteById(Long id);

    /**
     * 根据主键查询一个对象
     * @param id
     * @return
     */
    ResultDTO<JobVO> selectOneById(Long id);

    ResultDTO<String> update(JobDTO dto);

    ResultDTO<List<JobVO>> selectByCompanyId(Long companyId);
}
