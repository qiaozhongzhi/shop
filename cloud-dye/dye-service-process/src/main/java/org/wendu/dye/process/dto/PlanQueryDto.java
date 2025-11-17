package org.wendu.dye.process.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.wendu.dye.common.page.PageParam;

import java.util.Date;

public class PlanQueryDto extends PageParam{

    private String plan_id;
    private Integer plan_xh_start;
    private Integer plan_xh_end;
    private String plan_month;//计划月份
    private String plan_cus;
    private String plan_std;
    private String plan_color;
    private Double plan_num_start;//计划查询范围起始数量值
    private Double plan_num_end;//计划查询范围结束数量值
    private Integer plan_type;// 产品类型
    private Date plan_date_start;//计划查询范围起始下达时间
    private Date plan_date_end;//计划查询范围结束下达时间
    private String plan_person;//计划下达人
    private Boolean plan_status;//计划是否下达

    public String getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(String plan_id) {
        this.plan_id = plan_id;
    }

    public Integer getPlan_xh_start() {
        return plan_xh_start;
    }

    public void setPlan_xh_start(Integer plan_xh_start) {
        this.plan_xh_start = plan_xh_start;
    }

    public Integer getPlan_xh_end() {
        return plan_xh_end;
    }

    public void setPlan_xh_end(Integer plan_xh_end) {
        this.plan_xh_end = plan_xh_end;
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

    public Double getPlan_num_start() {
        return plan_num_start;
    }

    public void setPlan_num_start(Double plan_num_start) {
        this.plan_num_start = plan_num_start;
    }

    public Double getPlan_num_end() {
        return plan_num_end;
    }

    public void setPlan_num_end(Double plan_num_end) {
        this.plan_num_end = plan_num_end;
    }

    public Integer getPlan_type() {
        return plan_type;
    }

    public void setPlan_type(Integer plan_type) {
        this.plan_type = plan_type;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getPlan_date_start() {
        return plan_date_start;
    }

    public void setPlan_date_start(Date plan_date_start) {
        this.plan_date_start = plan_date_start;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getPlan_date_end() {
        return plan_date_end;
    }

    public void setPlan_date_end(Date plan_date_end) {
        this.plan_date_end = plan_date_end;
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
}
