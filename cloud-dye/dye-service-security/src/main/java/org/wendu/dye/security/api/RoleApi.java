package org.wendu.dye.security.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wendu.dye.common.Result;
import org.wendu.dye.common.page.Page;

import org.wendu.dye.security.dto.RoleDto;
import org.wendu.dye.security.dto.RoleDto;
import org.wendu.dye.security.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleApi {

    @Autowired
    private RoleService roleService;


    @GetMapping("")
    public Result roleList(RoleDto dto){
        Page page = roleService.getPage(dto);
        return Result.OK(page);
    }

    @PostMapping("")
    public Result roleDoAdd(@RequestBody RoleDto dto){
        roleService.execAdd(dto);
        return Result.OK();
    }

    @PutMapping("")
    public Result roleDoEdit(@RequestBody RoleDto dto){
        roleService.execEdit(dto);
        return Result.OK();
    }

    @DeleteMapping("/{ro_id}")
    public Result roleDoDel(@PathVariable String ro_id){
        roleService.execDel(ro_id);
        return Result.OK();
    }

    @DeleteMapping("")
    public Result roleDoDel(@RequestBody String[] ro_ids){
        roleService.execDel(ro_ids);
        return Result.OK();
    }

    @PutMapping("/{ro_id}/{currentStatus}")
    public Result roleDoChangeStatus(@PathVariable String ro_id,@PathVariable String currentStatus){
        String msg = roleService.execChangeStatus(ro_id,currentStatus);
        return Result.OK(msg);
    }
    
    
    //获得指定角色的权限列表
    @GetMapping("/module/{ro_id}")
    public Result getRoleModuleList(@PathVariable Integer ro_id){
        return Result.OK(roleService.getRoleModuleList(ro_id));
    }

    //确定变更角色的权限
    @PutMapping("/module/{roleId}")
    public Result confirmRoleModules(@PathVariable Integer roleId, @RequestBody Integer[] moduleIds){

        roleService.confirmRoleModules(roleId,moduleIds);
        return Result.OK();

    }
}
