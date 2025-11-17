package org.wendu.dye.common;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TokenDao {
    /**
     * 根据用户账号查询密码
     * @param userId
     * @return
     */
    @Select("select u_pwd from t_user where u_id = #{userId}")
    public String findPasswordByUserId(String userId);

}
