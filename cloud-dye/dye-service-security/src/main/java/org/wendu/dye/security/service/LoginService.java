package org.wendu.dye.security.service;

import org.wendu.dye.common.CurrentUser;
import org.wendu.dye.dto.LoginDto;

public interface LoginService {

    /**
     * 验证账号和密码是否正确的业务方法的返回类型一般是表示当前用户的一个对象
     * 验证通过返回当前用户对象，否则抛出异常
     */
    public CurrentUser checkLogin(LoginDto loginDto);
}
