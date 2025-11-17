package org.wendu.dye.report.model;

import lombok.Data;

import java.util.List;
@Data
public class StoreInOutReport {

    private Integer nowMonth;
    private List<Double> inNums;
    private List<Double> outNums;
}
