package org.wendu.dye.security.service;

import org.wendu.dye.common.page.Page;
import org.wendu.dye.common.page.PageParam;
import org.wendu.dye.model.Role;
import org.wendu.dye.security.dto.UserDto;

import java.util.List;

public interface UserService {
    Page getPage(UserDto dto);

    void execAdd(UserDto dto);

    void execEdit(UserDto dto);

    void execDel(String u_id);

    void execDel(String[] u_id);

    String execChangeStatus(String uId, String currentStatus);


    Page<Role> getUserRolePage(UserDto dto);



    void switchUserRole(String u_id, Integer ro_id, boolean has);
}
