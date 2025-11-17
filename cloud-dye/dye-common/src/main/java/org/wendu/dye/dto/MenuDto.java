package org.wendu.dye.dto;

import java.util.List;
//菜单结构的封装队喜爱那个
public class MenuDto {

    private Integer menuId;//菜单编号
    private String menuName;//菜单名称
    private String menuUrl;//菜单对应访问地址
    private boolean has;//是否拥有该权限

    private List<MenuDto> subMenuList;//子菜单的集合

    public Integer getMenuId() {
        return menuId;
    }
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
    public String getMenuName() {
        return menuName;
    }
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public String getMenuUrl() {
        return menuUrl;
    }
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
    public List<MenuDto> getSubMenuList() {
        return subMenuList;
    }
    public void setSubMenuList(List<MenuDto> subMenuList) {
        this.subMenuList = subMenuList;
    }

    public boolean isHas() {
        return has;
    }

    public void setHas(boolean has) {
        this.has = has;
    }
}
