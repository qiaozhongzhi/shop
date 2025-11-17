package org.wendu.dye.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DyeGroup {

    private String group_id;
    private Long plan_id;
    private String group_cus;
    private String group_std;
    private String group_color;
    private Double group_num;
    private Double pretreat_num;
    private Double dye_num;
    private Double print_num;
    private Double arrange_num;
    private Double check_num;//质检量

    private String std_name;
    private String color_name;
    private String cus_name;

    private Integer plan_type;

    private String pn_id;
    private Integer pd_id;
    private Date pn_date;
    private String pn_per;

    /* 质检数据 */
    private Double check_1;//一等品量
    private Double check_2;//二等品量
    private Double check_3;//三等品量
    private Double check_4;//等外等品量


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

    public Double getPretreat_num() {
        return pretreat_num;
    }

    public void setPretreat_num(Double pretreat_num) {
        this.pretreat_num = pretreat_num;
    }

    public Double getDye_num() {
        return dye_num;
    }

    public void setDye_num(Double dye_num) {
        this.dye_num = dye_num;
    }

    public Double getPrint_num() {
        return print_num;
    }

    public void setPrint_num(Double print_num) {
        this.print_num = print_num;
    }

    public Double getArrange_num() {
        return arrange_num;
    }

    public void setArrange_num(Double arrange_num) {
        this.arrange_num = arrange_num;
    }

    public Double getCheck_num() {
        return check_num;
    }

    public void setCheck_num(Double check_num) {
        this.check_num = check_num;
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

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public Integer getPlan_type() {
        return plan_type;
    }

    public void setPlan_type(Integer plan_type) {
        this.plan_type = plan_type;
    }


    public String getPn_id() {
        return pn_id;
    }

    public void setPn_id(String pn_id) {
        this.pn_id = pn_id;
    }

    public Integer getPd_id() {
        return pd_id;
    }

    public void setPd_id(Integer pd_id) {
        this.pd_id = pd_id;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
}
