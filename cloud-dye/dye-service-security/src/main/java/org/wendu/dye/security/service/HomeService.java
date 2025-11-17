package org.wendu.dye.security.service;

import org.wendu.dye.dto.MenuDto;

import java.util.List;

public interface HomeService {

    //获取与界面菜单结构相同的菜单数据
    public List<MenuDto> getMenuList(String u_id);

    List<MenuDto> getMenuListM(String userId);
}
