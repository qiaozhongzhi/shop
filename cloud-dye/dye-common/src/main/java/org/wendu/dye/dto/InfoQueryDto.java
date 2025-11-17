package org.wendu.dye.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.wendu.dye.common.page.PageParam;

import java.util.Date;

public class InfoQueryDto extends PageParam {

    private String info_id;
    private Integer info_type;
    private String info_name;
    private String info_remark;
    private String info_status;

    public String getInfo_id() {
        return info_id;
    }

    public void setInfo_id(String info_id) {
        this.info_id = info_id;
    }

    public Integer getInfo_type() {
        return info_type;
    }

    public void setInfo_type(Integer info_type) {
        this.info_type = info_type;
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
