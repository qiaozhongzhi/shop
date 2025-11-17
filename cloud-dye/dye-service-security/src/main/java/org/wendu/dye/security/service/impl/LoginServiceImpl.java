package org.wendu.dye.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wendu.dye.common.CurrentUser;
import org.wendu.dye.common.DataStatusEnum;
import org.wendu.dye.dto.LoginDto;
import org.wendu.dye.exception.BusinessException;
import org.wendu.dye.security.dao.LoginDao;
import org.wendu.dye.security.service.LoginService;
import org.wendu.dye.model.User;

@Service//表示该对象是放入Spring上下文容器中，受spring管理的业务对象
@Transactional(rollbackFor = Exception.class) //事务注解，说明本类所有的方法都是事务性的，并且遇到异常一律回滚
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public CurrentUser checkLogin(LoginDto loginDto) {
        loginDto.setU_status(DataStatusEnum.ACTIVED.getCode());
        User user = loginDao.findUserByIdAndPwd(loginDto);
        if(user == null){
            //没有查到符合账号密码的用户信息，说明账号或密码错误，属于用户操作失误
            throw new BusinessException("账号或密码错误！");
        }
        return new CurrentUser(user.getU_id(), user.getU_name());
    }
}
