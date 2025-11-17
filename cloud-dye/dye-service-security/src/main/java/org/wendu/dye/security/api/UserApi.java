package org.wendu.dye.security.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wendu.dye.common.Result;
import org.wendu.dye.common.page.Page;
import org.wendu.dye.security.dto.UserDto;
import org.wendu.dye.security.service.UserService;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserApi {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public Result userList(UserDto dto){
        Page page = userService.getPage(dto);
        return Result.OK(page);
    }
    @PostMapping("")
    public Result userDoAdd(@RequestBody UserDto dto){
        userService.execAdd(dto);
        return Result.OK();
    }

    @PutMapping("")
    public Result userDoEdit(@RequestBody UserDto dto){
        userService.execEdit(dto);
        return Result.OK();
    }

    @DeleteMapping("/{u_id}")
    public Result userDoDel(@PathVariable String u_id){
        userService.execDel(u_id);
        return Result.OK();
    }

    @DeleteMapping("")
    public Result userDoDel(@RequestBody String[] u_ids){
        userService.execDel(u_ids);
        return Result.OK();
    }

    @PutMapping("/{u_id}/{currentStatus}")
    public Result userDoChangeStatus(@PathVariable String u_id,@PathVariable String currentStatus){
        String msg = userService.execChangeStatus(u_id,currentStatus);
        return Result.OK(msg);
    }

    //获得指定用户的角色列表
    @GetMapping("/role")
    public Result getUserRoleList(UserDto dto){
        return Result.OK(userService.getUserRolePage(dto));
    }

    //确定变更用户的角色
    @PutMapping("/role/{u_id}/{ro_id}/{has}")
    public Result switchUserRole(@PathVariable String u_id,@PathVariable Integer ro_id,@PathVariable boolean has ){

        userService.switchUserRole(u_id,ro_id,has);
        return Result.OK();

    }
}
