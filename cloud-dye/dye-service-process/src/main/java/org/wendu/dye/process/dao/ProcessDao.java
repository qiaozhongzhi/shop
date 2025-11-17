package org.wendu.dye.process.dao;

import org.apache.ibatis.annotations.*;
import org.wendu.dye.common.page.Page;
import org.wendu.dye.model.*;
import org.wendu.dye.process.dto.*;

import java.util.List;

@Mapper
public interface ProcessDao {

    public List<DyePlan> findPlanList(PlanQueryDto dto);

    List<DyeGroup> findGroupList( GroupQueryDto dto);

    @Insert("insert into t_group(group_id,plan_id,group_cus,group_std,group_color,group_num) select '${group_id}',plan_id,plan_cus,plan_std,plan_color, ${group_num} from bus_plan where plan_id = #{plan_id}")
    void insertGroup(GroupDto dto);



    @Update("update t_process_node set pn_curr = 0 where exists(select pd_id from t_process_def where pd_id = t_process_node.pd_id and group_id = #{group_id} and pd_cls = #{processDefCls}) ")
    void updateAllGroupProcessNodeCurr2False(@Param("group_id") String group_id, @Param("processDefCls") int processDefCls);

    @Update("update t_process_node set pn_curr = 0 where exists(select pd_id from t_process_def where pd_id = t_process_node.pd_id and product_id = #{product_id} and pd_cls = #{processDefCls}) ")
    void updateAllProductProcessNodeCurr2False(@Param("product_id") Long product_id, @Param("processDefCls") int processDefCls);

    @Update("update t_process_node set pn_curr = 0 where exists(select pd_id from t_process_def where pd_id = t_process_node.pd_id and store_id = #{store_id} and pd_cls = #{processDefCls}) ")
    void updateAllStoreProcessNodeCurr2False(@Param("store_id") Long store_id, @Param("processDefCls") int processDefCls);

    void insertProcessNode(ProcessNodeDto pnDto);

    void updateProcessNode(ProcessNodeDto pnDto);

    @Delete("delete from t_process_node where pn_id = #{pn_id}")
    void deleteProcessNodeById(String pn_id);

    @Select("select * from t_process_node where group_id = #{group_id} and pd_id = #{curr_pd_id} and pn_curr = 1 and pn_status = 1")
    ProcessNode findProcessNodeByGroupIdAndCurrentStatus(@Param("group_id") String group_id, @Param("curr_pd_id") int curr_pd_id);

    @Select("select * from t_process_node where group_id = #{group_id} and pd_id = #{pd_id}")
    ProcessNode findProcessNodeByGroupIdAndPdId(ProcessNodeDto pnDto);

    @Delete("delete from t_group where group_id = #{group_id}")
    void deleteGroupById(String group_id);

    @Select("select pn.* from t_process_node pn join t_process_def pd on pn.pd_id = pd.pd_id where pd.pd_cls = 1 and group_id = #{group_id} and pn_status = 1 and pn.pd_id > 1000 order by pn_date")
    List<ProcessNode> findGroupProcessNodeList(String group_id,Integer pd_cls);

    @Update("update t_group set ${num_field} = #{num} where group_id = #{group_id}")
    void updateNumOfGroup(@Param("group_id") String group_id, @Param("num_field") String num_field, @Param("num") Double num);

    //查询质检数据
    List<DyeGroup> findCheckGroupList(GroupQueryDto dto);

    @Insert("insert into bus_product(product_id,group_id,product_cus,product_std,product_color,product_level,product_num) values(#{product_id},#{group_id},#{product_cus},#{product_std},#{product_color},#{product_level},#{product_num})")
    void insertProduct(ProductDto productDto);

    @Update("update bus_product set product_num = #{product_num} where group_id = #{group_id} and product_level = #{product_level}")
    void updateNumOfProduct(ProductDto productDto);

    @Select("select * from bus_product where group_id = #{group_id}")
    List<Product> findGroupProductList(String group_id);

    //查询成品信息
    List<Product> findPkgProductList(ProductQueryDto dto);

    @Select("select product_id from bus_product where group_id = #{group_id}")
    List<Long> findProductIdsOfGroup(String group_id);

    List<Store> findStoreList(StoreQueryDto dto);

    @Insert("insert into bus_store(store_id,product_id,store_cus,store_std,store_color,store_num) select ${store_id},product_id,product_cus,product_std,product_color,${store_num} from bus_product where product_id = #{product_id}")
    void addStoreOfProduct(StoreDto storeDto);

    @Delete("delete from t_process_node where store_id = #{store_id}")
    void deleteProcessNodeByStoreId(Long store_id);

    @Delete("delete from bus_store where store_id = #{store_id}")
    void deleteStoreById(Long store_id);

    @Select("select (select ifnull(sum(store_num),0) from bus_store where product_id = #{product_id}) + #{num} - product_num  from bus_product where product_id = #{product_id} ")
    double findPkgLTProduct(@Param("product_id") Long product_id,@Param("num")Double num);

    @Select("select (select ifnull(sum(store_num),0) from bus_store s  where product_id = #{product_id} and exists (select * from t_process_node where store_id = s.store_id and pn_curr = 1 and pn_status = 1 and pd_id >= 3010 ) )  - product_num  from bus_product where product_id = #{product_id}")
    double findPkgEQProduct(Long product_id);

    @Select("select * from t_process_node where store_id = #{store_id} and pd_id = #{pd_id}")
    ProcessNode findProcessNodeByStoreIdAndPdId(ProcessNodeDto pnDto);

    @Select("select * from t_process_node where product_id = #{product_id} and pd_id = #{pd_id}")
    ProcessNode findProcessNodeByProductIdAndPdId(ProcessNodeDto pnDto);
}