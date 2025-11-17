package org.wendu.dye.report.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.wendu.dye.report.model.ProductLevelNumReport;
import org.wendu.dye.report.model.TodayReport;
import org.wendu.dye.report.model.TypeReport;

import java.util.List;

@Mapper
public interface ChartsDao {
    List<TypeReport> findReportByType();

    @Select( "select case when max_month > now_month then max_month else now_month end from (select ifnull(max(plan_month),date_format(now(), '%Y-01')) max_month , date_format(now(), '%Y-%m') now_month from bus_plan where plan_status = 1 and plan_month like concat(date_format(now(), '%Y'), '%')) t limit 1" )
    String findMaxPlanMonth();

    List<Double> findMonthPlanNumList(@Param("maxMonth") String maxMonth,@Param("months") List<Integer> months);

    List<Double> findMonthRowclothNumList(@Param("maxMonth") String maxMonth,@Param("months") List<Integer> months);

    List<Double> findMonthProductNumList(@Param("maxMonth") String maxMonth,@Param("months") List<Integer> months);


    List<ProductLevelNumReport> findProductLevelNum();

    List<Double> findStoreInNumList(@Param("months") List<Integer> months);
    List<Double> findStoreOutNumList(@Param("months") List<Integer> months);

    TodayReport findTodayReport();


}
