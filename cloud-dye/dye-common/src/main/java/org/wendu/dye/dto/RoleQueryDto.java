package org.wendu.dye.dto;

import org.wendu.dye.common.page.PageParam;

public class RoleQueryDto extends PageParam {

    private String ro_id;
    private String ro_name;

    public String getRo_id() {
        return ro_id;
    }

    public void setRo_id(String ro_id) {
        this.ro_id = ro_id;
    }

    public String getRo_name() {
        return ro_name;
    }

    public void setRo_name(String ro_name) {
        this.ro_name = ro_name;
    }
}
