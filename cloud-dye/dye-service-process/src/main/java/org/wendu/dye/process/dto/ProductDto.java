package org.wendu.dye.process.dto;

public class ProductDto {

    private Long product_id;
    private String group_id;
    private String product_cus;
    private String product_std;
    private String product_color;
    private String product_level;
    private Double product_num;

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

    public Double getProduct_num() {
        return product_num;
    }

    public void setProduct_num(Double product_num) {
        this.product_num = product_num;
    }
}
