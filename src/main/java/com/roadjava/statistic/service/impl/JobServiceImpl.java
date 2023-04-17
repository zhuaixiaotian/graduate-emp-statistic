package com.roadjava.statistic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roadjava.statistic.bean.dto.JobDTO;
import com.roadjava.statistic.bean.entity.Job;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.vo.JobVO;
import com.roadjava.statistic.mapper.JobMapper;
import com.roadjava.statistic.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 岗位业务类
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Service
@Slf4j
public class JobServiceImpl implements JobService {

    @Resource
    private JobMapper jobMapper;

    @Override
    public ResultDTO<List<JobVO>> loadTable(JobDTO dto) {
        PageHelper.startPage(dto.getPageNow(),dto.getPageSize());
        List<JobVO> list = jobMapper.listByPage(dto);
        PageInfo<JobVO> pageInfo = new PageInfo<>(list);
        return ResultDTO.buildSuccess(list,pageInfo.getTotal());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<String> add(JobDTO dto) {
        Job entity = dto.toEntity();
        int count = jobMapper.insert(entity);
        if (count != 1) {
            return ResultDTO.buildFailure("添加失败");
        }else {
            return ResultDTO.buildSuccess("添加成功");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<String> deleteById(Long id) {
        jobMapper.deleteById(id);
        return ResultDTO.buildSuccess("删除成功");
    }

    @Override
    public ResultDTO<JobVO> selectOneById(Long id) {
        JobVO vo = jobMapper.selectOneById(id);
        if (vo == null) {
            return ResultDTO.buildFailure("目标对象不存在");
        }else {
            return ResultDTO.buildSuccess(vo);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<String> update(JobDTO dto) {
        Job entity = dto.toEntity();
        int count = jobMapper.update(entity);
        if (count != 1) {
            return ResultDTO.buildFailure("更新失败");
        }else {
            return ResultDTO.buildSuccess("更新成功");
        }
    }

    @Override
    public ResultDTO<List<JobVO>> selectByCompanyId(Long companyId) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setCompanyId(companyId);
        List<JobVO> vos = jobMapper.listByPage(jobDTO);
        return ResultDTO.buildSuccess(vos);
    }
}
