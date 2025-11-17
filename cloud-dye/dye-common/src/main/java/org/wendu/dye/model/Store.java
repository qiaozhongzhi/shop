package org.wendu.dye.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.wendu.dye.common.page.PageParam;

import java.util.Date;

public class Store{

    private Long store_id;
    private Long product_id;
    private String group_id;
    private Long plan_id;
    private Integer plan_type;
    private String store_cus;
    private String store_std;
    private String store_color;
    private String product_level;

    private String cus_name;
    private String std_name;
    private String color_name;

    private Double store_num;
    private Integer pd_id;
    private Date pn_date;
    private String pn_per;

    private boolean pkging;

    public Long getStore_id() {
        return store_id;
    }

    public void setStore_id(Long store_id) {
        this.store_id = store_id;
    }

    public Integer getPlan_type() {
        return plan_type;
    }

    public void setPlan_type(Integer plan_type) {
        this.plan_type = plan_type;
    }

    public String getStore_cus() {
        return store_cus;
    }

    public void setStore_cus(String store_cus) {
        this.store_cus = store_cus;
    }

    public String getStore_std() {
        return store_std;
    }

    public void setStore_std(String store_std) {
        this.store_std = store_std;
    }

    public String getStore_color() {
        return store_color;
    }

    public void setStore_color(String store_color) {
        this.store_color = store_color;
    }

    public String getProduct_level() {
        return product_level;
    }

    public void setProduct_level(String product_level) {
        this.product_level = product_level;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getPn_date() {
        return pn_date;
    }

    public void setPn_date(Date pn_date) {
        this.pn_date = pn_date;
    }

    public Double getStore_num() {
        return store_num;
    }

    public void setStore_num(Double store_num) {
        this.store_num = store_num;
    }

    public Integer getPd_id() {
        return pd_id;
    }

    public void setPd_id(Integer pd_id) {
        this.pd_id = pd_id;
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

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public boolean isPkging() {
        return pkging;
    }

    public void setPkging(boolean pkging) {
        this.pkging = pkging;
    }


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

    public String getPn_per() {
        return pn_per;
    }

    public void setPn_per(String pn_per) {
        this.pn_per = pn_per;
    }
}
