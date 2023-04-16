package com.roadjava.statistic.handler;

import com.roadjava.statistic.bean.dto.JobDTO;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.res.TableResult;
import com.roadjava.statistic.bean.vo.JobVO;
import com.roadjava.statistic.service.ClazzService;
import com.roadjava.statistic.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 岗位控制器
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Controller
@RequestMapping("/job")
@Slf4j
public class JobHandler {
    @Resource
    private JobService jobService;

    @PostMapping("/add") @ResponseBody
    public ResultDTO<String> add(JobDTO dto){
        return jobService.add(dto);
    }
    /**
     * 根据id删除
     */
    @PostMapping("/deleteById") @ResponseBody
    public ResultDTO<String> deleteById(@RequestParam("idToDelete") Long id){
        if (id == null) {
            return ResultDTO.buildFailure("id必传");
        }
        return jobService.deleteById(id);
    }

    /**
     * 跳转到编辑页面
     */
    @GetMapping("/toEdit")
    public String deleteById(@RequestParam("selectedId") Long selectedId, HttpServletRequest request){
        request.setAttribute("selectedId",selectedId);
        return "enterprise/job/edit";
    }

    /**
     * 根据主键查询用于回显
     */
    @PostMapping("/selectOneById") @ResponseBody
    public ResultDTO<JobVO> selectOneById(@RequestParam("id") Long id) {
        return jobService.selectOneById(id);
    }

    /**
     * 根据主键更新
     */
    @PostMapping("/update") @ResponseBody
    public ResultDTO<String> update(JobDTO dto) {
        return jobService.update(dto);
    }

    /**
     * 加载表格
     */
    @PostMapping("/loadTable") @ResponseBody
    public ResultDTO<TableResult<JobVO>> loadTable(JobDTO dto){
        TableResult<JobVO> tableResult=new TableResult<>();
        ResultDTO<List<JobVO>> result = jobService.loadTable(dto);
        tableResult.setTotalCount(result.getTotal());
        tableResult.setRows(result.getData());
        return ResultDTO.buildSuccess(tableResult);
    }
    /**
     * 加载某个公司的所有岗位
     */
    @PostMapping("/selectByCompanyId") @ResponseBody
    public ResultDTO<List<JobVO>> selectByCompanyId(@RequestParam("companyId") Long companyId){
        return jobService.selectByCompanyId(companyId);
    }
}
