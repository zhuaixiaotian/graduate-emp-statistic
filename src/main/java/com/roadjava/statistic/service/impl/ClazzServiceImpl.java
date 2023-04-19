package com.roadjava.statistic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roadjava.statistic.bean.dto.ClazzDTO;
import com.roadjava.statistic.bean.dto.MajorDTO;
import com.roadjava.statistic.bean.entity.Clazz;
import com.roadjava.statistic.bean.entity.Major;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.vo.ClazzVO;
import com.roadjava.statistic.bean.vo.MajorVO;
import com.roadjava.statistic.mapper.ClazzMapper;
import com.roadjava.statistic.mapper.StudentMapper;
import com.roadjava.statistic.service.ClazzService;
import com.roadjava.statistic.service.MajorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 系别业务类
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Service
@Slf4j
public class ClazzServiceImpl implements ClazzService {
    @Resource
    private ClazzMapper clazzMapper;
    @Resource
    private StudentMapper studentMapper;

    @Override
    public ResultDTO<List<ClazzVO>> loadTable(ClazzDTO dto) {
        PageHelper.startPage(dto.getPageNow(),dto.getPageSize());
        List<ClazzVO> list = clazzMapper.listByPage(dto);
        PageInfo<ClazzVO> pageInfo = new PageInfo<>(list);
        return ResultDTO.buildSuccess(list,pageInfo.getTotal());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<String> add(ClazzDTO dto) {
//        // 为班级名称添加年份
//        String newName = new StringBuilder(dto.getClazzName()).append("(").append(dto.getGraduateYear()).append(")").toString();
//        dto.setClazzName(newName);
        Clazz entity = dto.toEntity();
        int count = clazzMapper.insert(entity);
        if (count != 1) {
            return ResultDTO.buildFailure("添加失败");
        }else {
            return ResultDTO.buildSuccess("添加成功");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<String> deleteById(Long id) {
        // 删除该班级里的学生
        List<Long> clazzIds = new ArrayList<>();
        clazzIds.add(id);
        studentMapper.deleteByClazzIds(clazzIds);
        // 删除班级本身
        clazzMapper.deleteById(id);
        return ResultDTO.buildSuccess("删除成功");
    }

    @Override
    public ResultDTO<ClazzVO> selectOneById(Long id) {
        ClazzVO vo = clazzMapper.selectOneById(id);
        if (vo == null) {
            return ResultDTO.buildFailure("目标对象不存在");
        }else {
            return ResultDTO.buildSuccess(vo);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<String> update(ClazzDTO dto) {
        Clazz entity = dto.toEntity();
        int count = clazzMapper.update(entity);
        if (count != 1) {
            return ResultDTO.buildFailure("更新失败");
        }else {
            return ResultDTO.buildSuccess("更新成功");
        }
    }

    @Override
    public ResultDTO<List<ClazzVO>> selectAll() {
        List<ClazzVO> clazzVOS = clazzMapper.listByPage(new ClazzDTO());
        return ResultDTO.buildSuccess(clazzVOS);
    }
}
