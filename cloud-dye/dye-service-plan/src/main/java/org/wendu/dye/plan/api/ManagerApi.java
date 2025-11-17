package org.wendu.dye.plan.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wendu.dye.common.CommonUtils;
import org.wendu.dye.common.DyeConstants;
import org.wendu.dye.common.Result;
import org.wendu.dye.common.page.Page;
import org.wendu.dye.model.DyePlan;
import org.wendu.dye.plan.dto.PlanDto;
import org.wendu.dye.plan.dto.PlanQueryDto;
import org.wendu.dye.plan.service.ManagerService;
import org.wendu.dye.serviceapi.BaseApi;

@Slf4j
@RestController
@RequestMapping("/manager")
public class ManagerApi {

    @Autowired
    private BaseApi baseApi;

    @Autowired
    private ManagerService managerService;

    @GetMapping("/year-month-list")
    public Result getYearMonthList(){
        return Result.OK(CommonUtils.getYearMonthList());
    }

    @GetMapping("/info")
    public Result getInfos(){
        return baseApi.infos();
    }

    @GetMapping("/xh")
    public Result getXh(PlanQueryDto dto){
        Integer xh = managerService.getXh(dto);
        return Result.OK(xh);
    }

    @GetMapping("")
    public Result planList(PlanQueryDto dto){
        Page<DyePlan> page = managerService.getPage(dto);
        return Result.OK(page);
    }

    @PostMapping("")
    public Result planDoAdd(@RequestBody PlanDto dto){
        managerService.saveNewPlan(dto);
        return Result.OK();
    }

    @PutMapping("")
    public Result planDoUpd(@RequestBody PlanDto dto){
        managerService.updatePlan(dto);
        return Result.OK();
    }

    @DeleteMapping("/{id}")
    public Result planDoDel(@PathVariable String id){
        managerService.execDel(id);
        return Result.OK();
    }

    @DeleteMapping("")
    public Result planDoDel(@RequestBody String[] ids){
        managerService.execDel(ids);
        return Result.OK();
    }

    @PutMapping("/confirm/{id}")
    public Result planDoConfirm(@PathVariable Long id,@RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        managerService.execConfirm(id,token);
        return Result.OK();
    }


}
