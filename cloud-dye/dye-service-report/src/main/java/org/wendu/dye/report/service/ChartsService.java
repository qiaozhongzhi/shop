package org.wendu.dye.report.service;

import org.wendu.dye.report.model.*;

import java.util.List;

public interface ChartsService {

    List<TypeReport> getReportByType();


    MonthNumReport getMonthNumReport();


    Double getQualifiedRate();
    List<ProductLevelNumReport> getProductLevelNumList();

    StoreInOutReport getStoreInOutReport();



    TodayReport getTodayReport();
}
