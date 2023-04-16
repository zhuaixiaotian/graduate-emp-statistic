package com.roadjava.statistic.handler;

import com.roadjava.statistic.bean.dto.MajorDTO;
import com.roadjava.statistic.bean.entity.Major;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.res.TableResult;
import com.roadjava.statistic.bean.vo.MajorVO;
import com.roadjava.statistic.service.MajorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 专业控制器
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Controller
@RequestMapping("/major")
@Slf4j
public class MajorHandler {
    @Resource
    private MajorService majorService;

    @PostMapping("/add") @ResponseBody
    public ResultDTO<String> add(MajorDTO dto){
        return majorService.add(dto);
    }
    /**
     * 根据id删除
     */
    @PostMapping("/deleteById") @ResponseBody
    public ResultDTO<String> deleteById(@RequestParam("idToDelete") Long id){
        if (id == null) {
            return ResultDTO.buildFailure("id必传");
        }
        return majorService.deleteById(id);
    }

    /**
     * 跳转到编辑页面
     */
    @GetMapping("/toEdit")
    public String deleteById(@RequestParam("selectedId") Long selectedId, HttpServletRequest request){
        request.setAttribute("selectedId",selectedId);
        return "school/major/edit";
    }

    /**
     * 根据主键查询用于回显
     */
    @PostMapping("/selectOneById") @ResponseBody
    public ResultDTO<MajorVO> selectOneById(@RequestParam("id") Long id) {
        return majorService.selectOneById(id);
    }

    /**
     * 根据主键更新
     */
    @PostMapping("/update") @ResponseBody
    public ResultDTO<String> update(MajorDTO dto) {
        return majorService.update(dto);
    }

    /**
     * 加载表格
     */
    @PostMapping("/loadTable") @ResponseBody
    public ResultDTO<TableResult<MajorVO>> loadTable(MajorDTO dto){
        TableResult<MajorVO> tableResult=new TableResult<>();
        ResultDTO<List<MajorVO>> result = majorService.loadTable(dto);
        tableResult.setTotalCount(result.getTotal());
        tableResult.setRows(result.getData());
        return ResultDTO.buildSuccess(tableResult);
    }
    /**
     * 加载所有
     */
    @PostMapping("/selectAll") @ResponseBody
    public ResultDTO<List<MajorVO>> selectAll(){
        return majorService.selectAll();
    }
}
