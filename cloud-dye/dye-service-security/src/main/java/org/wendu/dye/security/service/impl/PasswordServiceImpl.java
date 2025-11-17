package org.wendu.dye.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.wendu.dye.exception.BusinessException;
import org.wendu.dye.security.dao.PasswordDao;
import org.wendu.dye.security.dto.PasswordDto;
import org.wendu.dye.security.service.PasswordService;


@Service
@Transactional
public class PasswordServiceImpl implements PasswordService {

    @Autowired
    private PasswordDao passwordDao;
    @Override
    public void updatePassword(PasswordDto dto) {
        String factOldPassword = passwordDao.findPasswordByUserId(dto.getCurrentUserId());
        if(!factOldPassword.equals(dto.getOld_pwd())){
            throw new BusinessException("原密码不正确！");
        }
        passwordDao.updatePassword(dto);
    }


}
