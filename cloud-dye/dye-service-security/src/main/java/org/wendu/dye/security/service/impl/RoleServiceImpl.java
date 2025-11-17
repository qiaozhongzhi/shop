package org.wendu.dye.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wendu.dye.common.DataStatusEnum;
import org.wendu.dye.common.DyeConstants;
import org.wendu.dye.common.page.Page;
import org.wendu.dye.dto.MenuDto;
import org.wendu.dye.dto.RoleQueryDto;
import org.wendu.dye.exception.BusinessException;
import org.wendu.dye.security.dao.RoleDao;
import org.wendu.dye.security.dto.RoleDto;
import org.wendu.dye.security.dto.RoleDto;
import org.wendu.dye.security.service.RoleService;
import org.wendu.dye.model.Module;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public Page getPage(RoleDto dto) {
        return Page.getPage(dto,()->roleDao.findList(dto));
    }




    @Override
    public void execAdd(RoleDto dto) {
        boolean exists = roleDao.existsTheOne(dto.getRo_id());
        if(exists){
            throw new BusinessException("编号已存在！");
        }
        dto.setRo_status(DataStatusEnum.UNDETERMINED.getCode());

        roleDao.insertOne(dto);
    }

    @Override
    public void execEdit(RoleDto dto) {
        boolean ok = roleDao.existsValidStatus(dto.getRo_id(),DataStatusEnum.UNDETERMINED.getCode());
        if(!ok){
            throw new BusinessException("编号不存在或数据不允许更新！");
        }
        roleDao.updateOne(dto);
    }

    @Override
    public void execDel(String ro_id) {
        //检测状态是否正确
        boolean ok = roleDao.existsValidStatus(ro_id,DataStatusEnum.UNDETERMINED.getCode());
        if(!ok){
            throw new BusinessException("编号不存在或数据不允许删除！");
        }
        roleDao.delete(ro_id);
    }

    @Override
    public void execDel(String[] ro_ids) {
        for(String id : ro_ids){
            //检测状态是否正确
            boolean ok = roleDao.existsValidStatus(id,DataStatusEnum.UNDETERMINED.getCode());
            if(!ok){
                throw new BusinessException("有存在的编号或者有不允许删除的数据！");
            }
        }

        roleDao.delete(ro_ids);
    }

    @Override
    public String execChangeStatus(String roId, String currentStatus) {
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
        int n = roleDao.updateStatus(roId,currentStatus,targetStatus);
        if(n>0){
            return msg;
        }
        throw new BusinessException("更新用户状态不失败！");
    }
    
    
    
    
    
    
    
    
    

    @Override
    public List<MenuDto> getRoleModuleList(Integer ro_id) {
        List<Module> moduleList = roleDao.findRoleModuleList(ro_id);
        List<MenuDto> mainList = new ArrayList<>();//主菜单的集合
        MenuDto currentMain = null;//当前主菜单

        for(Module fun : moduleList){
            if(currentMain == null || !currentMain.getMenuId().equals(fun.getP_id())){
                //当前主菜单不存在或者当前主菜单的编号与fun对象中的主菜单编号不一致，则生成新的主菜单，并给当前主菜单赋值
                currentMain = new MenuDto();
                currentMain.setMenuId(fun.getP_id());//设置主菜单编号
                currentMain.setMenuName(fun.getP_name());//设置主菜单名称
                currentMain.setSubMenuList(new ArrayList<MenuDto>());//设置子菜单集合

                mainList.add(currentMain);//将主菜单放入主菜单集合中
            }

            MenuDto sub = new MenuDto();
            sub.setMenuId(fun.getM_id());//设置子菜单编号
            sub.setMenuName(fun.getM_name());//设置子菜单名称
            sub.setMenuUrl(fun.getM_pc_url());//设置子菜单对应的访问地址
            sub.setHas(fun.isHas());

            currentMain.getSubMenuList().add(sub);//将子菜单放入主菜单集合中
        }

        return mainList;
    }

    @Override
    public void confirmRoleModules(Integer roleId, Integer[] funIds) {
        //1. 先删除指定角色的所有权限
        roleDao.deleteRoleModules(roleId);

        //2. 将提交的权限新增一遍
        if(funIds == null || funIds.length == 0)return;
        roleDao.insertRoleModules(roleId,funIds);
    }
}
