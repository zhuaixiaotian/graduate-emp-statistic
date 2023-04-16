package com.roadjava.statistic.handler;

import com.roadjava.statistic.bean.dto.StudentDTO;
import com.roadjava.statistic.bean.dto.StudentJobDTO;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.res.TableResult;
import com.roadjava.statistic.bean.vo.StudentVO;
import com.roadjava.statistic.service.StudentJobService;
import com.roadjava.statistic.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 学生控制器
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Controller
@RequestMapping("/studentJob")
@Slf4j
public class StudentJobHandler {
    @Resource
    private StudentJobService studentJobService;

    @PostMapping("/add") @ResponseBody
    public ResultDTO<String> add(StudentJobDTO dto){
        return studentJobService.add(dto);
    }
    /**
     * 根据id删除
     */
    @PostMapping("/deleteById") @ResponseBody
    public ResultDTO<String> deleteById(@RequestParam("idToDelete") Long id){
        if (id == null) {
            return ResultDTO.buildFailure("id必传");
        }
        return studentJobService.deleteById(id);
    }
}
