package org.wendu.dye.dto;

import org.wendu.dye.common.page.PageParam;

public class LeaveQueryDto extends PageParam {


    private String e_id;

    private Integer l_status;

    public Integer getL_status() {
        return l_status;
    }

    public void setL_status(Integer l_status) {
        this.l_status = l_status;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }
}
