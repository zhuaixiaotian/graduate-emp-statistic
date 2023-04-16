package com.roadjava.statistic.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roadjava.statistic.bean.dto.CompanyDTO;
import com.roadjava.statistic.bean.dto.MajorDTO;
import com.roadjava.statistic.bean.entity.Company;
import com.roadjava.statistic.bean.entity.Major;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.vo.CompanyVO;
import com.roadjava.statistic.bean.vo.MajorVO;
import com.roadjava.statistic.mapper.CompanyMapper;
import com.roadjava.statistic.mapper.JobMapper;
import com.roadjava.statistic.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    @Resource
    private CompanyMapper companyMapper;
    @Resource
    private JobMapper jobMapper;

    @Override
    public ResultDTO<List<CompanyVO>> loadTable(CompanyDTO dto) {
        PageHelper.startPage(dto.getPageNow(),dto.getPageSize());
        List<CompanyVO> list = companyMapper.listByPage(dto);
        PageInfo<CompanyVO> pageInfo = new PageInfo<>(list);
        return ResultDTO.buildSuccess(list,pageInfo.getTotal());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<String> add(CompanyDTO dto) {
        Company entity = dto.toEntity();
        int count = companyMapper.insert(entity);
        if (count != 1) {
            return ResultDTO.buildFailure("添加失败");
        }else {
            return ResultDTO.buildSuccess("添加成功");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<String> deleteById(Long id) {
        // 删除该公司下所有的岗位
        jobMapper.deleteByCompanyId(id);
        // 删除公司本身
        companyMapper.deleteById(id);
        return ResultDTO.buildSuccess("删除成功");
    }

    @Override
    public ResultDTO<CompanyVO> selectOneById(Long id) {
        CompanyVO vo = companyMapper.selectOneById(id);
        if (vo == null) {
            return ResultDTO.buildFailure("目标对象不存在");
        }else {
            return ResultDTO.buildSuccess(vo);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultDTO<String> update(CompanyDTO dto) {
        Company entity = dto.toEntity();
        int count = companyMapper.update(entity);
        if (count != 1) {
            return ResultDTO.buildFailure("更新失败");
        }else {
            return ResultDTO.buildSuccess("更新成功");
        }
    }

    @Override
    public ResultDTO<List<CompanyVO>> selectAll() {
        List<CompanyVO> vos = companyMapper.listByPage(new CompanyDTO());
        return ResultDTO.buildSuccess(vos);
    }
}
