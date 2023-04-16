package com.roadjava.statistic.service;

import com.roadjava.statistic.bean.dto.ClazzDTO;
import com.roadjava.statistic.bean.dto.MajorDTO;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.vo.ClazzVO;
import com.roadjava.statistic.bean.vo.MajorVO;

import java.util.List;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
public interface ClazzService {
    /**
     * 加载表格
     * @param dto
     * @return
     */
    ResultDTO<List<ClazzVO>> loadTable(ClazzDTO dto);

    /**
     * 新增
     * @param dto
     * @return
     */
    ResultDTO<String> add(ClazzDTO dto);

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
    ResultDTO<ClazzVO> selectOneById(Long id);

    ResultDTO<String> update(ClazzDTO dto);

    ResultDTO<List<ClazzVO>> selectAll();
}
