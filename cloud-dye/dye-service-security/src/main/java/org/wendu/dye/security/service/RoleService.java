package org.wendu.dye.security.service;

import org.wendu.dye.common.page.Page;
import org.wendu.dye.dto.MenuDto;
import org.wendu.dye.dto.RoleQueryDto;
import org.wendu.dye.model.Module;
import org.wendu.dye.security.dto.RoleDto;

import java.util.List;

public interface RoleService {
    Page getPage(RoleDto dto);

    void execAdd(RoleDto dto);

    void execEdit(RoleDto dto);

    void execDel(String u_id);

    void execDel(String[] u_id);

    String execChangeStatus(String uId, String currentStatus);

    List<MenuDto> getRoleModuleList(Integer ro_id);

    void confirmRoleModules(Integer roleId, Integer[] funIds);
}
