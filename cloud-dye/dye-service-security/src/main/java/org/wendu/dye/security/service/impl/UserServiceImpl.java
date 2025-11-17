package org.wendu.dye.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wendu.dye.common.DataStatusEnum;
import org.wendu.dye.common.DyeConstants;
import org.wendu.dye.common.page.Page;
import org.wendu.dye.common.page.PageParam;
import org.wendu.dye.exception.BusinessException;
import org.wendu.dye.model.Role;
import org.wendu.dye.security.dao.UserDao;
import org.wendu.dye.security.dto.UserDto;
import org.wendu.dye.security.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Page getPage(UserDto dto) {
        return Page.getPage(dto,()->userDao.findList(dto));
    }

    @Override
    public void execAdd(UserDto dto) {
        boolean exists = userDao.existsTheOne(dto.getU_id());
        if(exists){
            throw new BusinessException("账号已存在！");
        }
        dto.setU_status(DataStatusEnum.UNDETERMINED.getCode());
        dto.setU_pwd(DyeConstants.USER_DEFAULT_PASSWORD);
        userDao.insertOne(dto);
    }

    @Override
    public void execEdit(UserDto dto) {
        boolean ok = userDao.existsValidStatus(dto.getU_id(),DataStatusEnum.UNDETERMINED.getCode());
        if(!ok){
            throw new BusinessException("账号不存在或数据不允许更新！");
        }
        userDao.updateOne(dto);
    }

    @Override
    public void execDel(String u_id) {
        //检测状态是否正确
        boolean ok = userDao.existsValidStatus(u_id,DataStatusEnum.UNDETERMINED.getCode());
        if(!ok){
            throw new BusinessException("账号不存在或数据不允许删除！");
        }
        userDao.delete(u_id);
    }

    @Override
    public void execDel(String[] u_ids) {
        for(String id : u_ids){
            //检测状态是否正确
            boolean ok = userDao.existsValidStatus(id,DataStatusEnum.UNDETERMINED.getCode());
            if(!ok){
                throw new BusinessException("有存在的账号或者有不允许删除的数据！");
            }
        }

        userDao.delete(u_ids);
    }

    @Override
    public String execChangeStatus(String uId, String currentStatus) {
        String targetStatus = null;
        String msg = null;
        if(DataStatusEnum.UNDETERMINED.getCode().equals(currentStatus)){
            targetStatus = DataStatusEnum.DETERMINED.getCode();
            msg = "用户信息确定成功！";
        }else if(DataStatusEnum.DETERMINED.getCode().equals(currentStatus)){
            targetStatus = DataStatusEnum.ACTIVED.getCode();
            msg = "用户信息启用成功！";
        }else if(DataStatusEnum.ACTIVED.getCode().equals(currentStatus)){
            targetStatus = DataStatusEnum.DISABLED.getCode();
            msg = "用户信息禁用成功！";
        }else if(DataStatusEnum.DISABLED.getCode().equals(currentStatus)){
            targetStatus = DataStatusEnum.ACTIVED.getCode();
            msg = "用户信息启用成功！";
        }
        if(targetStatus == null)throw new BusinessException("用户当前状态不正确！");
        int n = userDao.updateStatus(uId,currentStatus,targetStatus);
        if(n>0){
            return msg;
        }
        throw new BusinessException("更新用户状态不失败！");
    }

    @Override
    public Page<Role> getUserRolePage(UserDto dto) {
        return Page.getPage(dto,()->userDao.findUserRoleList(dto.getU_id(),DataStatusEnum.ACTIVED.getCode()));

    }

    @Override
    public void switchUserRole(String u_id, Integer ro_id, boolean has) {
        if(has){
            userDao.insertUserRoles(u_id, new Integer[]{ro_id});
        }else{
            userDao.deleteUserRole(u_id,ro_id);
        }
    }


}
