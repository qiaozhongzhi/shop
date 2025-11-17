package org.wendu.dye.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LeaveAddUpdDto {

    private Long l_id;
    private String e_id;
    private Date l_date;//请假申请时间
    private Date l_start;//假期开始时间
    private Date l_end;//假期的结束时间
    private String l_cause;//请假事由
    private String  l_spr;//审批人
    private Date l_sp_date;//审批时间
    private String l_sp_advice;//审批意见
    private Date l_back;//销假时间

    private Integer l_status;//状态

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getL_start() {
        return l_start;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getL_end() {
        return l_end;
    }

    public Long getL_id() {
        return l_id;
    }

    public void setL_id(Long l_id) {
        this.l_id = l_id;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public Date getL_date() {
        return l_date;
    }

    public void setL_date(Date l_date) {
        this.l_date = l_date;
    }



    public void setL_start(Date l_start) {
        this.l_start = l_start;
    }



    public void setL_end(Date l_end) {
        this.l_end = l_end;
    }

    public String getL_cause() {
        return l_cause;
    }

    public void setL_cause(String l_cause) {
        this.l_cause = l_cause;
    }

    public String getL_spr() {
        return l_spr;
    }

    public void setL_spr(String l_spr) {
        this.l_spr = l_spr;
    }

    public Date getL_sp_date() {
        return l_sp_date;
    }

    public void setL_sp_date(Date l_sp_date) {
        this.l_sp_date = l_sp_date;
    }

    public String getL_sp_advice() {
        return l_sp_advice;
    }

    public void setL_sp_advice(String l_sp_advice) {
        this.l_sp_advice = l_sp_advice;
    }

    public Date getL_back() {
        return l_back;
    }

    public void setL_back(Date l_back) {
        this.l_back = l_back;
    }

    public Integer getL_status() {
        return l_status;
    }

    public void setL_status(Integer l_status) {
        this.l_status = l_status;
    }
}
