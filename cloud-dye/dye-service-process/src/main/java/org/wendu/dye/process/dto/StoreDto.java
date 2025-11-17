package org.wendu.dye.process.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.wendu.dye.common.page.PageParam;

import java.util.Date;

public class StoreDto{

    private Long store_id;
    private Long product_id;
    private String store_cus;
    private String store_std;
    private String store_color;
    private Double store_num;

    public Long getStore_id() {
        return store_id;
    }

    public void setStore_id(Long store_id) {
        this.store_id = store_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
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

    public Double getStore_num() {
        return store_num;
    }

    public void setStore_num(Double store_num) {
        this.store_num = store_num;
    }
}
