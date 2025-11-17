package org.wendu.dye.security.dao;

import org.apache.ibatis.annotations.*;
import org.wendu.dye.model.Role;
import org.wendu.dye.model.User;
import org.wendu.dye.security.dto.UserDto;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> findList(UserDto dto);

    @Select("select count(u_id) from t_user where u_id = #{u_id}")
    boolean existsTheOne(String u_id);

    @Insert("insert into t_user(u_id,u_name,u_status,u_pwd) values(#{u_id},#{u_name},#{u_status},#{u_pwd})")
    void insertOne(UserDto dto);

    @Update("update t_user set u_name=#{u_name} where u_id=#{u_id}")
    void updateOne(UserDto dto);

    //@Select("select count(1) from t_user u_id = #{u_id} and u_status = #{code}")
    boolean existsValidStatus(@Param("u_id") String u_id,@Param("codes") String... codes);

    //@Delete("delete from t_user where u_id = #{u_id}")
    void delete(@Param("u_ids") String... u_ids);

    @Update("update t_user set u_status = #{targetStatus} where u_id = #{uId} and u_status = #{currentStatus}")
    int updateStatus(@Param("uId") String uId, @Param("currentStatus") String currentStatus, @Param("targetStatus")String targetStatus);


    List<Role> findUserRoleList(@Param("u_id") String u_id,@Param("dataStatus")String dataStatus);

    @Delete("delete from t_ur where u_id = #{u_id}")
    void deleteUserRoles(String u_id);

    void insertUserRoles(@Param("u_id") String u_id, @Param("roleIds")Integer[] roleIds);

    @Delete("delete from t_ur where u_id = #{u_id} and ro_id = #{ro_id}")
    void deleteUserRole(@Param("u_id") String u_id, @Param("ro_id")Integer ro_id);
}
