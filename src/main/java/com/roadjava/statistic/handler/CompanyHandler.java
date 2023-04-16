package com.roadjava.statistic.handler;

import com.roadjava.statistic.bean.dto.CompanyDTO;
import com.roadjava.statistic.bean.dto.MajorDTO;
import com.roadjava.statistic.bean.res.ResultDTO;
import com.roadjava.statistic.bean.res.TableResult;
import com.roadjava.statistic.bean.vo.CompanyVO;
import com.roadjava.statistic.bean.vo.MajorVO;
import com.roadjava.statistic.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Controller
@RequestMapping("/company")
@Slf4j
public class CompanyHandler {
    @Resource
    private CompanyService companyService;
    
    @PostMapping("/add") @ResponseBody
    public ResultDTO<String> add(CompanyDTO dto){
        return companyService.add(dto);
    }
    /**
     * 根据id删除
     */
    @PostMapping("/deleteById") @ResponseBody
    public ResultDTO<String> deleteById(@RequestParam("idToDelete") Long id){
        if (id == null) {
            return ResultDTO.buildFailure("id必传");
        }
        return companyService.deleteById(id);
    }

    /**
     * 跳转到编辑页面
     */
    @GetMapping("/toEdit")
    public String deleteById(@RequestParam("selectedId") Long selectedId, HttpServletRequest request){
        request.setAttribute("selectedId",selectedId);
        return "enterprise/company/edit";
    }

    /**
     * 根据主键查询用于回显
     */
    @PostMapping("/selectOneById") @ResponseBody
    public ResultDTO<CompanyVO> selectOneById(@RequestParam("id") Long id) {
        return companyService.selectOneById(id);
    }

    /**
     * 根据主键更新
     */
    @PostMapping("/update") @ResponseBody
    public ResultDTO<String> update(CompanyDTO dto) {
        return companyService.update(dto);
    }

    /**
     * 加载表格
     */
    @PostMapping("/loadTable") @ResponseBody
    public ResultDTO<TableResult<CompanyVO>> loadTable(CompanyDTO dto){
        TableResult<CompanyVO> tableResult=new TableResult<>();
        ResultDTO<List<CompanyVO>> result = companyService.loadTable(dto);
        tableResult.setTotalCount(result.getTotal());
        tableResult.setRows(result.getData());
        return ResultDTO.buildSuccess(tableResult);
    }
    /**
     * 加载所有
     */
    @PostMapping("/selectAll") @ResponseBody
    public ResultDTO<List<CompanyVO>> selectAll(){
        return companyService.selectAll();
    }
}
