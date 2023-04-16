package com.roadjava.statistic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roadjava.statistic.bean.dto.StudentDTO;
import com.roadjava.statistic.bean.entity.Student;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.vo.StudentVO;
import com.roadjava.statistic.mapper.StudentMapper;
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
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public ResultDTO<List<StudentVO>> loadTable(StudentDTO dto) {
        PageHelper.startPage(dto.getPageNow(),dto.getPageSize());
        List<StudentVO> list = studentMapper.listByPage(dto);
        PageInfo<StudentVO> pageInfo = new PageInfo<>(list);
        return ResultDTO.buildSuccess(list,pageInfo.getTotal());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<String> add(StudentDTO dto) {
        Student entity = dto.toEntity();
        int count = studentMapper.insert(entity);
        if (count != 1) {
            return ResultDTO.buildFailure("添加失败");
        }else {
            return ResultDTO.buildSuccess("添加成功");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<String> deleteById(Long id) {
        studentMapper.deleteById(id);
        return ResultDTO.buildSuccess("删除成功");
    }

    @Override
    public ResultDTO<StudentVO> selectOneById(Long id) {
        StudentVO vo = studentMapper.selectOneById(id);
        if (vo == null) {
            return ResultDTO.buildFailure("目标对象不存在");
        }else {
            return ResultDTO.buildSuccess(vo);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<String> update(StudentDTO dto) {
        Student entity = dto.toEntity();
        int count = studentMapper.update(entity);
        if (count != 1) {
            return ResultDTO.buildFailure("更新失败");
        }else {
            return ResultDTO.buildSuccess("更新成功");
        }
    }

}
