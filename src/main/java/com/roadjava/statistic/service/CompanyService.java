package com.roadjava.statistic.service;

import com.roadjava.statistic.bean.dto.CompanyDTO;
import com.roadjava.statistic.bean.dto.MajorDTO;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.vo.CompanyVO;
import com.roadjava.statistic.bean.vo.MajorVO;

import java.util.List;

/**
 * 企业业务类
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
public interface CompanyService {
    /**
     * 加载表格
     * @param dto
     * @return
     */
    ResultDTO<List<CompanyVO>> loadTable(CompanyDTO dto);

    /**
     * 新增
     * @param dto
     * @return
     */
    ResultDTO<String> add(CompanyDTO dto);

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
    ResultDTO<CompanyVO> selectOneById(Long id);

    ResultDTO<String> update(CompanyDTO dto);

    ResultDTO<List<CompanyVO>> selectAll();
}
