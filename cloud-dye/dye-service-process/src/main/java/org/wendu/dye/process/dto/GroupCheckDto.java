package org.wendu.dye.process.dto;

import java.util.Date;

public class GroupCheckDto {

    private String group_id;
    private Long plan_id;

    private String product_cus;
    private String product_std;
    private String product_color;

    private Double check_1;
    private Double check_2;
    private Double check_3;
    private Double check_4;



    private Double check_num;

    private Long productId;

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

    public Double getCheck_1() {
        return check_1;
    }

    public void setCheck_1(Double check_1) {
        this.check_1 = check_1;
    }

    public Double getCheck_2() {
        return check_2;
    }

    public void setCheck_2(Double check_2) {
        this.check_2 = check_2;
    }

    public Double getCheck_3() {
        return check_3;
    }

    public void setCheck_3(Double check_3) {
        this.check_3 = check_3;
    }

    public Double getCheck_4() {
        return check_4;
    }

    public void setCheck_4(Double check_4) {
        this.check_4 = check_4;
    }

    public Double getCheck_num() {
        return check_num;
    }

    public void setCheck_num(Double check_num) {
        this.check_num = check_num;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProduct_cus() {
        return product_cus;
    }

    public String getGroup_cus() {
        return product_cus;
    }

    public void setProduct_cus(String product_cus) {
        this.product_cus = product_cus;
    }

    public void setGroup_cus(String product_cus) {
        this.product_cus = product_cus;
    }

    public String getProduct_std() {
        return product_std;
    }

    public String getGroup_std() {
        return product_std;
    }

    public void setProduct_std(String product_std) {
        this.product_std = product_std;
    }

    public void setGroup_std(String product_std) {
        this.product_std = product_std;
    }

    public String getProduct_color() {
        return product_color;
    }

    public String getGourp_color() {
        return product_color;
    }

    public void setProduct_color(String product_color) {
        this.product_color = product_color;
    }

    public void setGroup_color(String product_color) {
        this.product_color = product_color;
    }

}
