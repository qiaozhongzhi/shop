package org.wendu.dye.dto;

/**
 * 这是一个Dto对象（负责封装页面传来的对象），是一个JavaBean，具体这里封装登录数据
 */
public class LoginDto {

    private String u_id;//账号
    private String u_pwd;//密码
    private String u_status;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public String getU_status() {
        return u_status;
    }

    public void setU_status(String u_status) {
        this.u_status = u_status;
    }


}
