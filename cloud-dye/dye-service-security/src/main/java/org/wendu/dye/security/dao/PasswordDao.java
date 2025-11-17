package org.wendu.dye.security.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.wendu.dye.security.dto.PasswordDto;

@Mapper
@Repository
public interface PasswordDao {

    @Select("select u_pwd from t_user where u_id = #{currentUserId}")
    String findPasswordByUserId(String currentUserId);

    @Update("update t_user set u_pwd = #{new_pwd} where u_id = #{currentUserId}")
    void updatePassword(PasswordDto dto);
}
