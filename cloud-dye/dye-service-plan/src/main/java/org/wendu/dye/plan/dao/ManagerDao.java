package org.wendu.dye.plan.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.wendu.dye.model.DyePlan;
import org.wendu.dye.plan.dto.PlanDto;
import org.wendu.dye.plan.dto.PlanQueryDto;

import java.util.List;

@Mapper
public interface ManagerDao {

    public List<DyePlan> findList(PlanQueryDto dto);

    @Select("select ifnull(max(plan_xh),0)+1 from bus_plan where plan_month= #{plan_month} ")
    Integer findNewXh(PlanQueryDto dto);

    @Insert("insert into bus_plan(plan_id,plan_month,plan_type,plan_cus,plan_std,plan_color,plan_num,plan_xh,plan_status) values(#{plan_id},#{plan_month},#{plan_type},#{plan_cus},#{plan_std},#{plan_color},#{plan_num},#{plan_xh},#{plan_status})")
    void insertOne(PlanDto dto);

    void updateOne(PlanDto dto);

    void deleteByIds(@Param("ids") String... ids);
}
