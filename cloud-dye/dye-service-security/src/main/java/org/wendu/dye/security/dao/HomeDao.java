package org.wendu.dye.security.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.wendu.dye.model.Module;

import java.util.List;
@Mapper
@Repository
public interface HomeDao {

    //获取菜单
    public List<Module> findFunList(@Param("u_id") String u_id, @Param("dataStatus") String dataStatus);

    //获取移动端菜单
    List<Module> findFunListM(@Param("u_id") String userId, @Param("dataStatus") String code);
}
