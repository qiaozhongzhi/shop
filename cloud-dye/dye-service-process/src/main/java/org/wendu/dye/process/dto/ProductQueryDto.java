package org.wendu.dye.process.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.wendu.dye.common.page.PageParam;

import java.util.Date;

public class ProductQueryDto extends PageParam {

    private Integer pd_id;
    private String product_id;
    private Integer plan_type;
    private String product_cus;
    private String product_std;
    private String product_color;
    private String product_level;
    private Date date_start;
    private Date date_end;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
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
}
