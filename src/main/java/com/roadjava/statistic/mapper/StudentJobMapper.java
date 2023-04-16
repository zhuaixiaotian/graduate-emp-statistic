package com.roadjava.statistic.mapper;

import com.roadjava.statistic.bean.dto.StudentDTO;
import com.roadjava.statistic.bean.entity.Student;
import com.roadjava.statistic.bean.entity.StudentJob;
import com.roadjava.statistic.bean.vo.StudentVO;

import java.util.List;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
public interface StudentJobMapper {

    /**
     * 插入一条记录
     */
    int insert(StudentJob entity);

    /**
     * 按主键id删除一条记录
     */
    void deleteById(Long id);
}
