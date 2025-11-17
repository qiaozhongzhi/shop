package org.wendu.dye.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Product {

    private Long product_id;
    private String group_id;
    private String product_level;
    private Double product_num;

    private Double store_num;

    private Integer plan_type;
    private String product_cus;
    private String product_std;
    private String product_color;

    private String cus_name;
    private String std_name;
    private String color_name;

    private Date pn_date;
    private Integer pd_id;
    private String pn_per;

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getProduct_level() {
        return product_level;
    }

    public void setProduct_level(String product_level) {
        this.product_level = product_level;
    }

    public Double getProduct_num() {
        return product_num;
    }

    public void setProduct_num(Double product_num) {
        this.product_num = product_num;
    }

    public Integer getPlan_type() {
        return plan_type;
    }

    public void setPlan_type(Integer plan_type) {
        this.plan_type = plan_type;
    }

    public String getProduct_cus() {
        return product_cus;
    }

    public void setProduct_cus(String product_cus) {
        this.product_cus = product_cus;
    }

    public String getProduct_std() {
        return product_std;
    }

    public void setProduct_std(String product_std) {
        this.product_std = product_std;
    }

    public String getProduct_color() {
        return product_color;
    }

    public void setProduct_color(String product_color) {
        this.product_color = product_color;
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

    public Double getRest_num(){
        if(product_num == null || store_num == null ){
            return 0.0;
        }
        return product_num - store_num;
    }

    public Integer getPd_id() {
        return pd_id;
    }

    public void setPd_id(Integer pd_id) {
        this.pd_id = pd_id;
    }

    public String getPn_per() {
        return pn_per;
    }

    public void setPn_per(String pn_per) {
        this.pn_per = pn_per;
    }
}
