package org.wendu.dye.process.dto;

import java.util.Date;

public class ProcessNodeDto {
    private String pn_id;
    private String group_id;
    private Long product_id;
    private Long store_id;
    private Integer pd_id;
    private Date pn_date;
    private String pn_per;
    private Boolean pn_curr;
    private Boolean pn_status;

    public String getPn_id() {
        return pn_id;
    }

    public void setPn_id(String pn_id) {
        this.pn_id = pn_id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getStore_id() {
        return store_id;
    }

    public void setStore_id(Long store_id) {
        this.store_id = store_id;
    }

    public Integer getPd_id() {
        return pd_id;
    }

    public void setPd_id(Integer pd_id) {
        this.pd_id = pd_id;
    }

    public Date getPn_date() {
        return pn_date;
    }

    public void setPn_date(Date pn_date) {
        this.pn_date = pn_date;
    }

    public String getPn_per() {
        return pn_per;
    }

    public void setPn_per(String pn_per) {
        this.pn_per = pn_per;
    }

    public Boolean getPn_curr() {
        return pn_curr;
    }

    public void setPn_curr(Boolean pn_curr) {
        this.pn_curr = pn_curr;
    }

    public Boolean getPn_status() {
        return pn_status;
    }

    public void setPn_status(Boolean pn_status) {
        this.pn_status = pn_status;
    }
}
