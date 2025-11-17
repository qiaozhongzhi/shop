package org.wendu.dye.process.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.wendu.dye.common.page.PageParam;

import java.util.Arrays;
import java.util.Date;

public class GroupQueryDto extends PageParam {

    private String group_id;
    private String plan_id;
    private Integer plan_type;
    private String group_cus;
    private String group_std;
    private String group_color;

    private Double group_num_start;
    private Double group_num_end;



    private Date date_start;
    private Date date_end;
    private String per;

    private Integer pd_id;

    private String pd_ids;//按多个状态查询


    private String previousPdIds;

    private Integer[] acceptedProdTypes = {1,2,3,4};//可接受产品类型

    private boolean arrange = false;

    private boolean print = false;

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(String plan_id) {
        this.plan_id = plan_id;
    }

    public Integer getPlan_type() {
        return plan_type;
    }

    public void setPlan_type(Integer plan_type) {
        this.plan_type = plan_type;
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

    public Double getGroup_num_start() {
        return group_num_start;
    }

    public void setGroup_num_start(Double group_num_start) {
        this.group_num_start = group_num_start;
    }

    public Double getGroup_num_end() {
        return group_num_end;
    }

    public void setGroup_num_end(Double group_num_end) {
        this.group_num_end = group_num_end;
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

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

    public Integer getPd_id() {
        return pd_id;
    }

    public void setPd_id(Integer pd_id) {
        this.pd_id = pd_id;
    }

    public String getPd_ids() {
        return pd_ids;
    }

    public Integer[] getPd_idArr(){
        if(!StringUtils.hasText(pd_ids))return null;
        String[] arr = pd_ids.split(",");
        Integer[] iarr = new Integer[arr.length];
        for (int i=0;i<arr.length;i++){
            try {
                iarr[i]=Integer.valueOf(arr[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return iarr;
    }

    public void setPd_ids(String pd_ids) {
        this.pd_ids = pd_ids;
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

    public void setAcceptedProdTypes(Integer[] acceptedProdTypes) {
        this.acceptedProdTypes = acceptedProdTypes;
    }

    public Integer[] getAcceptedProdTypes() {
        return acceptedProdTypes;
    }

    public boolean isArrange() {
        return arrange;
    }

    public void setArrange(boolean arrange) {
        this.arrange = arrange;
    }

    public boolean isPrint() {
        return print;
    }

    public void setPrint(boolean print) {
        this.print = print;
    }
}
