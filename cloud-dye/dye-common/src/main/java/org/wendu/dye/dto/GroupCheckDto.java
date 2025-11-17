package org.wendu.dye.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GroupCheckDto {

    private String group_id;
    private Long plan_id;

    private String product_cus;
    private String product_std;
    private String product_color;

    private Double check_1;
    private Double check_2;
    private Double check_3;
    private Double check_4;


    private Double check_num;

    private Long productId;

    private Date date;
    private String per;
}