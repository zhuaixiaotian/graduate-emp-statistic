package com.roadjava.statistic.service;

import com.roadjava.statistic.bean.dto.MajorDTO;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.vo.MajorVO;

import java.util.List;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
public interface MajorService {
    /**
     * 加载表格
     * @param dto
     * @return
     */
    ResultDTO<List<MajorVO>> loadTable(MajorDTO dto);

    /**
     * 新增
     * @param dto
     * @return
     */
    ResultDTO<String> add(MajorDTO dto);

    /**
     * 根据主键删除专业
     *   删除该专业下所有班级里的学生
     *   删除班级
     *   删除专业
     * @param id
     * @return
     */
    ResultDTO<String> deleteById(Long id);

    /**
     * 根据主键查询一个对象
     * @param id
     * @return
     */
    ResultDTO<MajorVO> selectOneById(Long id);

    ResultDTO<String> update(MajorDTO dto);

    ResultDTO<List<MajorVO>> selectAll();
}
