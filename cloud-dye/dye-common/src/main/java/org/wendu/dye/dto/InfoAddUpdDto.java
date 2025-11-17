package org.wendu.dye.dto;

/**
 * 负责封装前端传来的新增或修改数据
 */
public class InfoAddUpdDto {

    private String info_id;
    private int info_type;
    private String info_name;
    private String info_remark;
    private String info_status;

    public String getInfo_id() {
        return info_id;
    }

    public void setInfo_id(String info_id) {
        this.info_id = info_id;
    }

    public void setInfo_type(int info_type) {
        this.info_type = info_type;
    }

    public int getInfo_type() {
        return info_type;
    }

    public String getInfo_name() {
        return info_name;
    }

    public void setInfo_name(String info_name) {
        this.info_name = info_name;
    }

    public String getInfo_remark() {
        return info_remark;
    }

    public void setInfo_remark(String info_remark) {
        this.info_remark = info_remark;
    }

    public String getInfo_status() {
        return info_status;
    }

    public void setInfo_status(String info_status) {
        this.info_status = info_status;
    }
}
