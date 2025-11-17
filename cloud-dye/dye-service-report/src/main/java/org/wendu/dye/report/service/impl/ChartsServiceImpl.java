package org.wendu.dye.report.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wendu.dye.common.ProductLevelEnum;
import org.wendu.dye.report.dao.ChartsDao;
import org.wendu.dye.report.model.*;
import org.wendu.dye.report.service.ChartsService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class ChartsServiceImpl implements ChartsService {

    @Autowired
    private ChartsDao chartsDao;

    @Override
    public List<TypeReport> getReportByType() {
        return chartsDao.findReportByType();
    }

    @Override
    public MonthNumReport getMonthNumReport() {
        MonthNumReport report = new MonthNumReport();


        String maxMonth = chartsDao.findMaxPlanMonth();
        int intMaxMonth = Integer.valueOf(maxMonth.substring(5));
        List<Integer> months = new ArrayList<>();
        for(int i=1;i<=intMaxMonth;i++)months.add(i);


        report.setMonths(months);



        report.setPlanNums(chartsDao.findMonthPlanNumList(maxMonth,months));

        report.setRowclothNums(chartsDao.findMonthRowclothNumList(maxMonth,months));

        report.setProductNums(chartsDao.findMonthProductNumList(maxMonth,months));

        return report;
    }

    @Override
    public Double getQualifiedRate() {
        List<ProductLevelNumReport> reportList = chartsDao.findProductLevelNum();
        Double level_1_num = reportList.stream()
                .filter(report-> ProductLevelEnum.LEVEL_01.getCode().equals(report.getProduct_level()))
                .findFirst()
                .orElseGet(()->new ProductLevelNumReport("01",0.0))
                .getProduct_num();
        Double level_total =  0.0;
        for(ProductLevelNumReport report : reportList)level_total+=report.getProduct_num();
        if(level_total < 0.1)return 0.0;
        return level_1_num/level_total;
    }

    @Override
    public List<ProductLevelNumReport> getProductLevelNumList() {
        return  chartsDao.findProductLevelNum();
    }

    @Override
    public StoreInOutReport getStoreInOutReport() {
        StoreInOutReport report = new StoreInOutReport();

        Integer nowMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
        report.setNowMonth(nowMonth);

        List<Integer> months = new ArrayList<>();
        for(int i=1;i<=nowMonth;i++)months.add(i);

        report.setInNums(chartsDao.findStoreInNumList(months));
        report.setOutNums(chartsDao.findStoreOutNumList(months));

        return report;
    }

    @Override
    public TodayReport getTodayReport() {
        return chartsDao.findTodayReport();
    }
}
