package org.wendu.dye.process.dto;

import org.wendu.dye.common.page.PageParam;

import java.util.Date;

public class GroupDto{

    private String group_id;
    private Long plan_id;
    private String group_cus;
    private String group_std;
    private String group_color;

    private Double group_num;

    private Date date;
    private String per;

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public Long getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Long plan_id) {
        this.plan_id = plan_id;
    }

    public String getGroup_cus() {
        return group_cus;
    }

    public void setGroup_cus(String group_cus) {
        this.group_cus = group_cus;
    }

    public String getGroup_std() {
        return group_std;
    }

    public void setGroup_std(String group_std) {
        this.group_std = group_std;
    }

    public String getGroup_color() {
        return group_color;
    }

    public void setGroup_color(String group_color) {
        this.group_color = group_color;
    }

    public Double getGroup_num() {
        return group_num;
    }

    public void setGroup_num(Double group_num) {
        this.group_num = group_num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }
}
