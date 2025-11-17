package org.wendu.dye.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wendu.dye.common.DataStatusEnum;
import org.wendu.dye.dto.MenuDto;
import org.wendu.dye.security.dao.HomeDao;
import org.wendu.dye.security.service.HomeService;
import org.wendu.dye.model.Module;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeDao homeDao;

    @Override
    public List<MenuDto> getMenuList(String u_id) {

        List<Module> funList = homeDao.findFunList(u_id, DataStatusEnum.ACTIVED.getCode());

        List<MenuDto> mainList = new ArrayList<>();//主菜单的集合
        MenuDto currentMain = null;//当前主菜单

        for(Module fun : funList){
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

            currentMain.getSubMenuList().add(sub);//将子菜单放入主菜单集合中
        }

        return mainList;
    }

    @Override
    public List<MenuDto> getMenuListM(String userId) {
        List<Module> funList = homeDao.findFunListM(userId, DataStatusEnum.ACTIVED.getCode());

        List<MenuDto> mainList = new ArrayList<>();//菜单的集合


        for(Module fun : funList){

            MenuDto menu = new MenuDto();
            menu.setMenuId(fun.getM_id());//设置子菜单编号
            menu.setMenuName(fun.getM_name());//设置子菜单名称
            menu.setMenuUrl(fun.getM_h5_url());//设置子菜单对应的访问地址

            mainList.add(menu);
        }

        return mainList;
    }
}
