package com.roadjava.statistic.mapper;

import com.roadjava.statistic.bean.dto.ClazzDTO;
import com.roadjava.statistic.bean.dto.StudentDTO;
import com.roadjava.statistic.bean.entity.Clazz;
import com.roadjava.statistic.bean.entity.Student;
import com.roadjava.statistic.bean.vo.ClazzVO;
import com.roadjava.statistic.bean.vo.StudentVO;

import java.util.List;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
public interface StudentMapper {
    /**
     * 分页查询列表
     * @param dto
     * @return
     */
    List<StudentVO> listByPage(StudentDTO dto);

    /**
     * 插入一条记录
     */
    int insert(Student entity);

    /**
     * 按主键id删除一条记录
     */
    void deleteById(Long id);
    /**
     * 按主键id查询一条记录
     */
    StudentVO selectOneById(Long id);

    /**
     * 按主键更新
     */
    int update(Student entity);

    void deleteByClazzIds(List<Long> clazzIds);
}
