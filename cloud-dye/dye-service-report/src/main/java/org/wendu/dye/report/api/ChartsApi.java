package org.wendu.dye.report.api;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wendu.dye.common.Result;
import org.wendu.dye.report.model.*;
import org.wendu.dye.report.service.ChartsService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/charts")
public class ChartsApi {

    @Autowired
    private ChartsService chartsService;

    @GetMapping("/type")
    public Result<List<TypeReport>> reportByType(){
        List<TypeReport> list = chartsService.getReportByType();
        return Result.OK(list);
    }

    @GetMapping("/month-num")
    public Result<MonthNumReport> monthNumReport(){
        return Result.OK(chartsService.getMonthNumReport());
    }

    @GetMapping("/qualified-rate")
    public Result<Double> qualifiedRateReport(){
        return Result.OK(chartsService.getQualifiedRate());
    }

    @GetMapping("/level-num")
    public Result<List<ProductLevelNumReport>> productLevelNumReport(){
        return Result.OK(chartsService.getProductLevelNumList());
    }

    @GetMapping("/store-inout")
    public Result<StoreInOutReport> storeInOutReport(){
        return Result.OK(chartsService.getStoreInOutReport());
    }

    @GetMapping("/today")
    public Result<TodayReport> todayReport(){
        return Result.OK(chartsService.getTodayReport());
    }


}
