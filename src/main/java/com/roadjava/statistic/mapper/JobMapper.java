package com.roadjava.statistic.mapper;

import com.roadjava.statistic.bean.dto.ClazzDTO;
import com.roadjava.statistic.bean.dto.JobDTO;
import com.roadjava.statistic.bean.entity.Clazz;
import com.roadjava.statistic.bean.entity.Job;
import com.roadjava.statistic.bean.vo.ClazzVO;
import com.roadjava.statistic.bean.vo.JobVO;

import java.util.List;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
public interface JobMapper {
    /**
     * 分页查询列表
     * @param dto
     * @return
     */
    List<JobVO> listByPage(JobDTO dto);

    /**
     * 插入一条记录
     */
    int insert(Job entity);

    /**
     * 按主键id删除一条记录
     */
    void deleteById(Long id);
    /**
     * 按主键id查询一条记录
     */
    JobVO selectOneById(Long id);

    /**
     * 按主键更新
     */
    int update(Job entity);

    /**
     * 通过公司id删除该id下所有的岗位
     * @param companyId 公司id
     */
    void deleteByCompanyId(Long companyId);
}
