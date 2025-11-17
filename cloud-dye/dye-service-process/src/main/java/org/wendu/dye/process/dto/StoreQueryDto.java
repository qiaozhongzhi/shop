package org.wendu.dye.process.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.wendu.dye.common.page.PageParam;

import java.util.Date;

public class StoreQueryDto extends PageParam {

    private Integer pd_id;
    private String store_id;
    private String plan_id;
    private String group_id;
    private String product_id;
    private Integer plan_type;
    private String store_cus;
    private String store_std;
    private String store_color;
    private String product_level;
    private Date date_start;
    private Date date_end;
    private String per;
    private Double store_num_start;
    private Double store_num_end;

    private String previousPdIds;

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public Integer getPd_id() {
        return pd_id;
    }

    public void setPd_id(Integer pd_id) {
        this.pd_id = pd_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public String getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(String plan_id) {
        this.plan_id = plan_id;
    }

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

    public Double getStore_num_start() {
        return store_num_start;
    }

    public void setStore_num_start(Double store_num_start) {
        this.store_num_start = store_num_start;
    }

    public Double getStore_num_end() {
        return store_num_end;
    }

    public void setStore_num_end(Double store_num_end) {
        this.store_num_end = store_num_end;
    }

    public String getPreviousPdIds() {
        return previousPdIds;
    }

    public void setPreviousPdIds(String previousPdIds) {
        this.previousPdIds = previousPdIds;
    }

    public String[] getPrePdIds(){
        if(previousPdIds!=null){
            return previousPdIds.split(",");
        }
        return null;
    }
}
