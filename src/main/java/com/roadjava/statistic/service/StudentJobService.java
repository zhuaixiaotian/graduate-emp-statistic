package com.roadjava.statistic.service;

import com.roadjava.statistic.bean.dto.StudentDTO;
import com.roadjava.statistic.bean.dto.StudentJobDTO;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.vo.StudentVO;

import java.util.List;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
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
