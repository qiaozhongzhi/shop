package org.wendu.dye.report.model;

import lombok.Data;

import java.util.List;

@Data
public class MonthNumReport {
    private List<Integer> months;
    private List<Double> planNums;
    private List<Double> rowclothNums;
    private List<Double> productNums;

}
