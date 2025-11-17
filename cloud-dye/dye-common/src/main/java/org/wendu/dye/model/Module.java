package org.wendu.dye.model;

public class Module {

    private Integer p_id; //父菜单编号
    private String p_name;//父菜单名称

    private Integer m_id;//子菜单编号
    private String m_name;//子菜单名称
    private String m_pc_url;//子菜单地址
    private String m_h5_url;//子菜单地址
    private String m_api;//子菜单地址

    private boolean has;

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_pc_url() {
        return m_pc_url;
    }

    public void setM_pc_url(String m_pc_url) {
        this.m_pc_url = m_pc_url;
    }

    public String getM_h5_url() {
        return m_h5_url;
    }

    public void setM_h5_url(String m_h5_url) {
        this.m_h5_url = m_h5_url;
    }

    public String getM_api() {
        return m_api;
    }

    public void setM_api(String m_api) {
        this.m_api = m_api;
    }

    public boolean isHas() {
        return has;
    }

    public void setHas(boolean has) {
        this.has = has;
    }
}
