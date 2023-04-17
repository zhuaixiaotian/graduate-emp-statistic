package com.roadjava.statistic.controller;

import com.roadjava.statistic.bean.dto.StudentDTO;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.res.TableResult;
import com.roadjava.statistic.bean.vo.StudentVO;
import com.roadjava.statistic.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 学生控制器
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Controller
@RequestMapping("/student")
@Slf4j
public class StudentController {
    @Resource
    private StudentService studentService;

    @PostMapping("/add") @ResponseBody
    public ResultDTO<String> add(StudentDTO dto){
        return studentService.add(dto);
    }
    /**
     * 根据id删除
     */
    @PostMapping("/deleteById") @ResponseBody
    public ResultDTO<String> deleteById(@RequestParam("idToDelete") Long id){
        if (id == null) {
            return ResultDTO.buildFailure("id必传");
        }
        return studentService.deleteById(id);
    }

    /**
     * 跳转到编辑页面
     */
    @GetMapping("/toEdit")
    public String deleteById(@RequestParam("selectedId") Long selectedId, HttpServletRequest request){
        request.setAttribute("selectedId",selectedId);

        return "school/student/edit";
    }

    /**
     * 根据主键查询用于回显
     */
    @PostMapping("/selectOneById") @ResponseBody
    public ResultDTO<StudentVO> selectOneById(@RequestParam("id") Long id) {
        return studentService.selectOneById(id);
    }

    /**
     * 根据主键更新
     */
    @PostMapping("/update") @ResponseBody
    public ResultDTO<String> update(StudentDTO dto) {
        return studentService.update(dto);
    }
    /**
     * 加载求职表格
     */
    @PostMapping("/loadTable") @ResponseBody
    public ResultDTO<TableResult<StudentVO>> loadTable(StudentDTO dto){
        TableResult<StudentVO> tableResult=new TableResult<>();
        ResultDTO<List<StudentVO>> result = studentService.loadTable(dto);
        tableResult.setTotalCount(result.getTotal());
        tableResult.setRows(result.getData());
        return ResultDTO.buildSuccess(tableResult);
    }
}
