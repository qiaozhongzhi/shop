package org.wendu.dye.base;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.wendu.dye.model.Info;
import org.wendu.dye.model.ProcessDef;


import java.util.List;

@Mapper
public interface BaseDao {

    @Select("select info_id,info_name,info_type from t_info where info_status = #{info_status} and info_type = #{info_type}")
    List<Info> findInfoList(Integer info_type, String info_status);

    @Select("select info_id,info_name,info_type from t_info where info_status = #{info_status}")
    List<Info> findAllTypeInfoList(String code);

    @Select("select pd_id,pd_pid,pd_name,pd_cls from t_process_def")
    List<ProcessDef> findAllProcessDefList();
}
