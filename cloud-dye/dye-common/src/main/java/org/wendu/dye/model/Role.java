package org.wendu.dye.model;

public class Role {

    private Integer ro_id;
    private String ro_name;
    private String ro_remark;
    private String ro_status;

    private boolean has;

    public Integer getRo_id() {
        return ro_id;
    }

    public void setRo_id(Integer ro_id) {
        this.ro_id = ro_id;
    }

    public String getRo_name() {
        return ro_name;
    }

    public void setRo_name(String ro_name) {
        this.ro_name = ro_name;
    }

    public String getRo_remark() {
        return ro_remark;
    }

    public void setRo_remark(String ro_remark) {
        this.ro_remark = ro_remark;
    }

    public String getRo_status() {
        return ro_status;
    }

    public void setRo_status(String ro_status) {
        this.ro_status = ro_status;
    }

    public boolean isHas() {
        return has;
    }

    public void setHas(boolean has) {
        this.has = has;
    }
}
