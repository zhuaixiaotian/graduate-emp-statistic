package com.roadjava.statistic.service;

import com.roadjava.statistic.bean.dto.ClazzDTO;
import com.roadjava.statistic.bean.dto.StudentDTO;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.vo.ClazzVO;
import com.roadjava.statistic.bean.vo.StudentVO;

import java.util.List;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
public interface StudentService {
    /**
     * 加载表格
     * @param dto
     * @return
     */
    ResultDTO<List<StudentVO>> loadTable(StudentDTO dto);

    /**
     * 新增
     * @param dto
     * @return
     */
    ResultDTO<String> add(StudentDTO dto);

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
    ResultDTO<StudentVO> selectOneById(Long id);

    ResultDTO<String> update(StudentDTO dto);
}
