package com.roadjava.statistic.controller;

import com.roadjava.statistic.bean.dto.ClazzDTO;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.res.TableResult;
import com.roadjava.statistic.bean.vo.ClazzVO;
import com.roadjava.statistic.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 班级控制器
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Controller
@RequestMapping("/clazz")
@Slf4j
public class ClazzController {
    @Resource
    private ClazzService clazzService;

    @PostMapping("/add") @ResponseBody
    public ResultDTO<String> add(ClazzDTO dto){
        return clazzService.add(dto);
    }
    /**
     * 根据id删除
     */
    @PostMapping("/deleteById") @ResponseBody
    public ResultDTO<String> deleteById(@RequestParam("idToDelete") Long id){
        if (id == null) {
            return ResultDTO.buildFailure("id必传");
        }
        return clazzService.deleteById(id);
    }

    /**
     * 跳转到编辑页面
     */
    @GetMapping("/toEdit")
    public String deleteById(@RequestParam("selectedId") Long selectedId, HttpServletRequest request){
        request.setAttribute("selectedId",selectedId);
        return "school/clazz/edit";
    }

    /**
     * 根据主键查询用于回显
     */
    @PostMapping("/selectOneById") @ResponseBody
    public ResultDTO<ClazzVO> selectOneById(@RequestParam("id") Long id) {
        return clazzService.selectOneById(id);
    }

    /**
     * 根据主键更新
     */
    @PostMapping("/update") @ResponseBody
    public ResultDTO<String> update(ClazzDTO dto) {
        return clazzService.update(dto);
    }

    /**
     * 加载表格
     */
    @PostMapping("/loadTable") @ResponseBody
    public ResultDTO<TableResult<ClazzVO>> loadTable(ClazzDTO dto){
        TableResult<ClazzVO> tableResult=new TableResult<>();
        ResultDTO<List<ClazzVO>> result = clazzService.loadTable(dto);
        tableResult.setTotalCount(result.getTotal());
        tableResult.setRows(result.getData());
        return ResultDTO.buildSuccess(tableResult);
    }
    /**
     * 加载所有
     */
    @PostMapping("/selectAll") @ResponseBody
    public ResultDTO<List<ClazzVO>> selectAll(){
        return clazzService.selectAll();
    }
}
