package org.wendu.dye.security.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.wendu.dye.dto.LoginDto;
import org.wendu.dye.model.User;

@Mapper  //本对象是放入spring容器中的，是受spring管理的MyBatis映射器对象
@Repository
public interface LoginDao {

    @Select("select u_id,u_name from t_user where u_id = #{u_id} and u_pwd = #{u_pwd} and u_status = #{u_status}")
    public User findUserByIdAndPwd(LoginDto loginDto);

}
