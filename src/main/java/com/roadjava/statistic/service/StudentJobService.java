package com.roadjava.statistic.service;

import com.roadjava.statistic.bean.dto.StudentDTO;
import com.roadjava.statistic.bean.dto.StudentJobDTO;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.vo.StudentVO;

import java.util.List;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
public interface StudentJobService {
    /**
     * 新增
     * @param dto
     * @return
     */
    ResultDTO<String> add(StudentJobDTO dto);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    ResultDTO<String> deleteById(Long id);
}
