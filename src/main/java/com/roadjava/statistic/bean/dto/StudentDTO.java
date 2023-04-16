package com.roadjava.statistic.bean.dto;

import com.roadjava.statistic.bean.entity.Clazz;
import com.roadjava.statistic.bean.entity.Student;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * 学生信息
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Data
public class StudentDTO extends BaseDTO{
    /**
     * 主键
     */
    private Long id;
    /**
     * 学生名称
     */
    private String studentName;
    /**
     * 性别: M:男 F:女
     */
    private String sex;
    /**
     * 班级id
     */
    private Long clazzId;
    /**
     * 毕业年份,第几届,格式:yyyy
     */
    private Integer graduateYear;
    /**
     * 专业id
     */
    private Long majorId;
    /**
     * "":全部  Y:查已就业的 N:尚未就业的学生
     */
    private String hasJob;

    public Student toEntity() {
        Student entity = new Student();
        BeanUtils.copyProperties(this,entity);
        return entity;
    }
}
