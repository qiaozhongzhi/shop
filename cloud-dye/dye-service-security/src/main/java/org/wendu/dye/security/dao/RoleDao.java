package org.wendu.dye.security.dao;

import org.apache.ibatis.annotations.*;

import org.springframework.stereotype.Repository;
import org.wendu.dye.dto.RoleQueryDto;
import org.wendu.dye.model.Module;
import org.wendu.dye.model.Role;
import org.wendu.dye.security.dto.RoleDto;
import org.wendu.dye.security.dto.RoleDto;

import java.util.List;

@Mapper
@Repository
public interface RoleDao {


    List<Role> findList(RoleDto dto);

    //根据角色查询权限
    List<Module> findRoleModuleList(Integer ro_id);


    @Select("select count(ro_id) from t_role where ro_id = #{ro_id}")
    boolean existsTheOne(String ro_id);

    @Insert("insert into t_role(ro_id,ro_name,ro_status,ro_remark) values(#{ro_id},#{ro_name},#{ro_status},#{ro_remark})")
    void insertOne(RoleDto dto);

    @Update("update t_role set ro_name=#{ro_name} , ro_remark = #{ro_remark} where ro_id=#{ro_id}")
    void updateOne(RoleDto dto);

    //@Select("select count(1) from t_role ro_id = #{ro_id} and ro_status = #{code}")
    boolean existsValidStatus(@Param("ro_id") String ro_id,@Param("codes") String... codes);

    //@Delete("delete from t_role where ro_id = #{ro_id}")
    void delete(@Param("ro_ids") String... ro_ids);

    @Update("update t_role set ro_status = #{targetStatus} where ro_id = #{roId} and ro_status = #{currentStatus}")
    int updateStatus(@Param("roId") String roId, @Param("currentStatus") String currentStatus, @Param("targetStatus")String targetStatus);
    
    
    
    
    

    //删除指定角色的所有权限
    @Delete("delete from t_rm where ro_id = #{roleId}")
    void deleteRoleModules(Integer roleId);

    //插入若干权限数据
    void insertRoleModules(@Param("roleId") Integer roleId, @Param("moduleIds")Integer[] moduleIds);
}
