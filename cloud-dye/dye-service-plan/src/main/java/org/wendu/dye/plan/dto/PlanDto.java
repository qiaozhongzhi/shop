package org.wendu.dye.plan.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.wendu.dye.common.page.PageParam;

import java.util.Date;

public class PlanDto{

    private Long plan_id;
    private Integer plan_xh;
    private String plan_month;//计划月份
    private String plan_cus;
    private String plan_std;
    private String plan_color;
    private Double plan_num;//计划查询范围结束数量值
    private Integer plan_type;// 产品类型
    private Date plan_date;//计划查询范围结束下达时间
    private String plan_person;//计划下达人
    private Boolean plan_status;//计划是否下达

    public Long getPlan_id() {
        return plan_id;
    }

    public PlanDto setPlan_id(Long plan_id) {
        this.plan_id = plan_id;
        return this;
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

    public Integer getPlan_type() {
        return plan_type;
    }

    public void setPlan_type(Integer plan_type) {
        this.plan_type = plan_type;
    }

    public Date getPlan_date() {
        return plan_date;
    }

    public PlanDto setPlan_date(Date plan_date) {
        this.plan_date = plan_date;
        return this;
    }

    public String getPlan_person() {
        return plan_person;
    }

    public PlanDto setPlan_person(String plan_person) {
        this.plan_person = plan_person;
        return this;
    }

    public Boolean getPlan_status() {
        return plan_status;
    }

    public PlanDto setPlan_status(Boolean plan_status) {
        this.plan_status = plan_status;
        return this;
    }
}
