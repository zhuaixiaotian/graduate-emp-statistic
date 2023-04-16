package com.roadjava.statistic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roadjava.statistic.bean.dto.MajorDTO;
import com.roadjava.statistic.bean.entity.Major;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.vo.MajorVO;
import com.roadjava.statistic.mapper.ClazzMapper;
import com.roadjava.statistic.mapper.MajorMapper;
import com.roadjava.statistic.mapper.StudentMapper;
import com.roadjava.statistic.service.MajorService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系别业务类
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Service
@Slf4j
public class MajorServiceImpl implements MajorService {
    @Resource
    private MajorMapper majorMapper;
    @Resource
    private ClazzMapper clazzMapper;
    @Resource
    private StudentMapper studentMapper;

    @Override
    public ResultDTO<List<MajorVO>> loadTable(MajorDTO dto) {
        PageHelper.startPage(dto.getPageNow(),dto.getPageSize());
        List<MajorVO> list = majorMapper.listByPage(dto);
        PageInfo<MajorVO> pageInfo = new PageInfo<>(list);
        return ResultDTO.buildSuccess(list,pageInfo.getTotal());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<String> add(MajorDTO dto) {
        Major entity = dto.toEntity();
        int count = majorMapper.insert(entity);
        if (count != 1) {
            return ResultDTO.buildFailure("添加失败");
        }else {
            return ResultDTO.buildSuccess("添加成功");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<String> deleteById(Long id) {
        // 查询出班级id列表
        List<Long> clazzIds = clazzMapper.selectClazzIdsByMajorId(id);
        // 删除这些班级里的学生
        if (CollectionUtils.isNotEmpty(clazzIds)) {
            studentMapper.deleteByClazzIds(clazzIds);
            // 删除班级
            clazzMapper.deleteByIds(clazzIds);
        }
        majorMapper.deleteById(id);
        return ResultDTO.buildSuccess("删除成功");
    }

    @Override
    public ResultDTO<MajorVO> selectOneById(Long id) {
        MajorVO vo = majorMapper.selectOneById(id);
        if (vo == null) {
            return ResultDTO.buildFailure("目标对象不存在");
        }else {
            return ResultDTO.buildSuccess(vo);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<String> update(MajorDTO dto) {
        Major entity = dto.toEntity();
        int count = majorMapper.update(entity);
        if (count != 1) {
            return ResultDTO.buildFailure("更新失败");
        }else {
            return ResultDTO.buildSuccess("更新成功");
        }
    }

    @Override
    public ResultDTO<List<MajorVO>> selectAll() {
        List<MajorVO> majorVOS = majorMapper.listByPage(new MajorDTO());
        return ResultDTO.buildSuccess(majorVOS);
    }
}
