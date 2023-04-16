package com.roadjava.statistic.mapper;

import com.roadjava.statistic.bean.dto.ClazzDTO;
import com.roadjava.statistic.bean.dto.MajorDTO;
import com.roadjava.statistic.bean.entity.Clazz;
import com.roadjava.statistic.bean.entity.Major;
import com.roadjava.statistic.bean.vo.ClazzVO;
import com.roadjava.statistic.bean.vo.MajorVO;

import java.util.List;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
public interface ClazzMapper {
    /**
     * 分页查询列表
     * @param dto
     * @return
     */
    List<ClazzVO> listByPage(ClazzDTO dto);

    /**
     * 插入一条记录
     */
    int insert(Clazz entity);

    /**
     * 按主键id删除一条记录
     */
    void deleteById(Long id);
    /**
     * 按主键id查询一条记录
     */
    ClazzVO selectOneById(Long id);

    /**
     * 按主键更新
     */
    int update(Clazz entity);

    List<Long> selectClazzIdsByMajorId(Long majorId);

    void deleteByIds(List<Long> clazzIds);
}
