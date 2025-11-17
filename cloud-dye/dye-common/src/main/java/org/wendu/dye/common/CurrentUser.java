package org.wendu.dye.common;

/**
 * 表示当前在线用户
 */
public class CurrentUser {

    private String userId;
    private String userName;
    public CurrentUser() {}

    public CurrentUser(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
