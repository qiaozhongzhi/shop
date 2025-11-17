package org.wendu.dye.process.servcie;

import org.wendu.dye.common.page.Page;
import org.wendu.dye.model.*;
import org.wendu.dye.process.dto.*;

import java.util.List;

public interface ProcessService {

    public Page<DyePlan> getPlanPage(PlanQueryDto dto);

    Page<DyeGroup> getGroupPage(GroupQueryDto dto);


    public void addProcessNode(ProcessNodeDto pnDto, int processDefCls);

    public void updateProcessNode(ProcessNodeDto pnDto, int code);


    void addGroup(GroupDto dto);

    void removeGroup(String group_id);

    public void removeProcessNode(String pn_id);

    void doGroup(String group_id,String per);

    List<ProcessNode> getGroupProcessNodeList(String group_id,Integer pd_cls);

    void doPretreat(String group_id,String per);

    void savePretreat(String group_id, Double retreat_num, String per);


    void saveDye(String group_id, Double dye_num, String per);
    public void doDye(String group_id, String per);

    void savePrint(String group_id, Double print_num, String per);
    void doPrint(String group_id, String per);

    void saveArrange(String group_id, Double arrange_num, String per);
    void doArrange(String group_id, String per);

    /**
     * 为生产分组新增四条产品数据
     * @param dto
     */
    public void addGroupProducts(GroupCheckDto dto);

    /**
     * 为生产分组对应的四条产品数据新增一个状态
     * @param group_id
     * @param per
     * @param pd_id
     */
    void addProductProcessNodesOfGroup(String group_id,String per, int pd_id);

    /**
     * 为生产分组修改四条产品数据的数量
     * @param dto
     */
    void updateNumOfGroupProducts(GroupCheckDto dto);
    /**
     * 获取质检模块清单
     * @param dto
     * @return
     */
    Page<DyeGroup> getCheckGroupPage(GroupQueryDto dto);

    void saveCheck(GroupCheckDto dto);


    void doCheck(String group_id, String per);

    List<Product> getGroupProductList(String group_id);

    Page<List<Product>> getPkgProductPage(ProductQueryDto dto);


    Page<List<Store>> getStorePage(StoreQueryDto dto);

    void addPkg(Long product_id, Double num,String per);

    void deletePkg(Long store_id);

    void completeProductPkg(Long product_id,String per);

    void completePkg(Long store_id, String per);

    void completeStore(Long store_id, String per);

    void completeOut(Long store_id, String per);
}
