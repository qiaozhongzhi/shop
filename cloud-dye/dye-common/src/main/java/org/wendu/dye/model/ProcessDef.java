package org.wendu.dye.model;

public class ProcessDef {

    private int pd_id;
    private int pd_pid;
    private String pd_name;
    private int pd_cls;

    public int getPd_id() {
        return pd_id;
    }

    public void setPd_id(int pd_id) {
        this.pd_id = pd_id;
    }

    public int getPd_pid() {
        return pd_pid;
    }

    public void setPd_pid(int pd_pid) {
        this.pd_pid = pd_pid;
    }

    public String getPd_name() {
        return pd_name;
    }

    public void setPd_name(String pd_name) {
        this.pd_name = pd_name;
    }

    public int getPd_cls() {
        return pd_cls;
    }

    public void setPd_cls(int pd_cls) {
        this.pd_cls = pd_cls;
    }
}
