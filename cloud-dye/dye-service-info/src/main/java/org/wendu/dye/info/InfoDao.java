package org.wendu.dye.info;

import org.apache.ibatis.annotations.*;
import org.wendu.dye.dto.InfoAddUpdDto;
import org.wendu.dye.dto.InfoQueryDto;
import org.wendu.dye.model.Info;

import java.util.List;

@Mapper
public interface InfoDao {

    //需要按查询条件书写动态sql，比较长，不适合以注解方式写，因此sql在xml文件中写
    List<Info> findList(InfoQueryDto infoQueryDto);


    @Insert("insert into t_info(info_id,info_name,info_type,info_remark,info_status) values(#{info_id},#{info_name},#{info_type},#{info_remark},#{info_status})")
    void insertInfo(InfoAddUpdDto infoAddUpdDto);

    //@Param("ids") 说明映射的sql中使用ids为名称代表传入的参数eid
    void deleteInfo(@Param("info_type") int info_type,@Param("ids") String... ids);

    @Update("update t_info set info_name = #{info_name} , info_remark= #{info_remark}  where info_type = #{info_type} and info_id = #{info_id} and info_status = #{info_status}")
    void updateInfo(InfoAddUpdDto infoAddUpdDto);

    @Update("update t_info set info_status = #{targetStatus} where info_id = #{info_id} and info_status = #{currentStatus}")
    int updateStatus(@Param("info_id") String info_id, @Param("currentStatus") String currentStatus, @Param("targetStatus")String targetStatus);
}
