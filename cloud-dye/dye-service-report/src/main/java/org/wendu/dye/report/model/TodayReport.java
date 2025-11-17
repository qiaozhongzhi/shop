package org.wendu.dye.report.model;

import lombok.Data;

import java.text.DecimalFormat;

@Data
public class TodayReport {

    private static final DecimalFormat quealifiedRateFormat = new DecimalFormat("0.00%");

    private double rowclothNum;
    private double level_1_num;
    private double level_2_num;
    private double level_3_num;
    private double level_4_num;
    private double inNum;
    private double outNum;

    public String getQualifiedRate(){
        if(getProductNum()<0.1) return null;
        return quealifiedRateFormat.format(level_1_num/(level_1_num+level_2_num+level_3_num+level_4_num));
    }

    public double getProductNum(){
        return level_1_num+level_2_num+level_3_num+level_4_num;
    }


}
