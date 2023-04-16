package com.roadjava.statistic.bean.dto;

import com.roadjava.statistic.bean.entity.Student;
import com.roadjava.statistic.bean.entity.StudentJob;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * 学生就业信息实体类
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Data
public class StudentJobDTO extends BaseDTO{
    /**
     * 主键
     */
    private Long id;
    /**
     * 学生id
     */
    private Long studentId;
    /**
     * 岗位id
     */
    private Long jobId;

    public StudentJob toEntity() {
        StudentJob entity = new StudentJob();
        BeanUtils.copyProperties(this,entity);
        return entity;
    }
}
