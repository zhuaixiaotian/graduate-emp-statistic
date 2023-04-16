package com.roadjava.statistic.mapper;



import com.roadjava.statistic.bean.dto.CompanyDTO;
import com.roadjava.statistic.bean.dto.MajorDTO;
import com.roadjava.statistic.bean.entity.Company;
import com.roadjava.statistic.bean.entity.Major;
import com.roadjava.statistic.bean.vo.CompanyVO;
import com.roadjava.statistic.bean.vo.MajorVO;

import java.util.List;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
public interface CompanyMapper {
    /**
     * 分页查询列表
     * @param dto
     * @return
     */
    List<CompanyVO> listByPage(CompanyDTO dto);
    /**
     * 插入一条记录
     */
    int insert(Company entity);
    /**
     * 按主键id删除一条记录
     */
    void deleteById(Long id);

    /**
     * 按主键id查询一条记录
     */
    CompanyVO selectOneById(Long id);

    /**
     * 按主键更新
     */
    int update(Company entity);
}
