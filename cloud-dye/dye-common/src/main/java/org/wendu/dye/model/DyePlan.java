package org.wendu.dye.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DyePlan {

    private Long plan_id;
    private Integer plan_xh;
    private String plan_month;
    private String plan_cus;
    private String plan_std;
    private String plan_color;
    private Double plan_num;
    private int plan_type;// 产品类型
    private Date plan_date;//计划下达时间
    private String plan_person;//计划下达人
    private Boolean plan_status;//计划是否下达

    private String cus_name;
    private String std_name;
    private String color_name;

    private Double group_total;

    public Long getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Long plan_id) {
        this.plan_id = plan_id;
    }

    public Integer getPlan_xh() {
        return plan_xh;
    }

    public void setPlan_xh(Integer plan_xh) {
        this.plan_xh = plan_xh;
    }

    public String getPlan_month() {
        return plan_month;
    }

    public void setPlan_month(String plan_month) {
        this.plan_month = plan_month;
    }

    public String getPlan_cus() {
        return plan_cus;
    }

    public void setPlan_cus(String plan_cus) {
        this.plan_cus = plan_cus;
    }

    public String getPlan_std() {
        return plan_std;
    }

    public void setPlan_std(String plan_std) {
        this.plan_std = plan_std;
    }

    public String getPlan_color() {
        return plan_color;
    }

    public void setPlan_color(String plan_color) {
        this.plan_color = plan_color;
    }

    public Double getPlan_num() {
        return plan_num;
    }

    public void setPlan_num(Double plan_num) {
        this.plan_num = plan_num;
    }

    public int getPlan_type() {
        return plan_type;
    }

    public void setPlan_type(int plan_type) {
        this.plan_type = plan_type;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getPlan_date() {
        return plan_date;
    }

    public void setPlan_date(Date plan_date) {
        this.plan_date = plan_date;
    }

    public String getPlan_person() {
        return plan_person;
    }

    public void setPlan_person(String plan_person) {
        this.plan_person = plan_person;
    }

    public Boolean getPlan_status() {
        return plan_status;
    }

    public void setPlan_status(Boolean plan_status) {
        this.plan_status = plan_status;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    public void setGroup_total(Double group_total) {
        this.group_total = group_total;
    }

    public Double getGroup_total() {
        return group_total;
    }

    /**
     * 计划余额
     * @return
     */
    public Double getPlan_remainder(){
        if(plan_num == null || this.group_total == null) return null;
        return plan_num - group_total;
    }
}
