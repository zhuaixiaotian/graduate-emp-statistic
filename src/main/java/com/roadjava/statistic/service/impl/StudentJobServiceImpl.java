package com.roadjava.statistic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roadjava.statistic.bean.dto.StudentDTO;
import com.roadjava.statistic.bean.dto.StudentJobDTO;
import com.roadjava.statistic.bean.entity.Student;
import com.roadjava.statistic.bean.entity.StudentJob;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.vo.StudentVO;
import com.roadjava.statistic.mapper.StudentJobMapper;
import com.roadjava.statistic.mapper.StudentMapper;
import com.roadjava.statistic.service.StudentJobService;
import com.roadjava.statistic.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学生业务类
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Service
@Slf4j
public class StudentJobServiceImpl implements StudentJobService {
    @Resource
    private StudentJobMapper studentJobMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<String> add(StudentJobDTO dto) {
        StudentJob entity = dto.toEntity();
        int count = studentJobMapper.insert(entity);
        if (count != 1) {
            return ResultDTO.buildFailure("添加失败");
        }else {
            return ResultDTO.buildSuccess("添加成功");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<String> deleteById(Long id) {
        studentJobMapper.deleteById(id);
        return ResultDTO.buildSuccess("删除成功");
    }
}
