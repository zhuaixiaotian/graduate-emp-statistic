package com.roadjava.statistic.mapper;

import com.roadjava.statistic.bean.dto.MajorDTO;
import com.roadjava.statistic.bean.entity.Major;
import com.roadjava.statistic.bean.vo.MajorVO;

import java.util.List;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
public interface MajorMapper {
    /**
     * 分页查询列表
     * @param dto
     * @return
     */
    List<MajorVO> listByPage(MajorDTO dto);
    /**
     * 插入一条记录
     */
    int insert(Major entity);
    /**
     * 按主键id删除一条记录
     */
    void deleteById(Long id);

    /**
     * 按主键id查询一条记录
     */
    MajorVO selectOneById(Long id);

    /**
     * 按主键更新
     */
    int update(Major entity);
}
