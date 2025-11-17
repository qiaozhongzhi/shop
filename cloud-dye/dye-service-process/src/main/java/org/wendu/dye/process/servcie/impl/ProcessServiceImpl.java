package org.wendu.dye.process.servcie.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wendu.dye.common.ProcessDefEnum;
import org.wendu.dye.common.ProductLevelEnum;
import org.wendu.dye.common.page.Page;
import org.wendu.dye.exception.BusinessException;
import org.wendu.dye.model.*;
import org.wendu.dye.process.dao.ProcessDao;
import org.wendu.dye.process.dto.*;
import org.wendu.dye.process.servcie.ProcessService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Service
@Transactional
public class ProcessServiceImpl implements ProcessService {


    @Autowired
    private ProcessDao processDao;

    private SimpleDateFormat groupIdFmt = new SimpleDateFormat("yyyyMMdd-HHmmss-SSS");
    private AtomicInteger no = new AtomicInteger(0);


    @Override
    public Page<DyePlan> getPlanPage(PlanQueryDto dto) {
        return Page.getPage(dto,()->processDao.findPlanList(dto));
    }

    @Override
    public Page<DyeGroup> getGroupPage(GroupQueryDto dto) {
        return Page.getPage(dto,()->processDao.findGroupList(dto));

    }

    @Override
    public void addProcessNode(ProcessNodeDto pnDto,int processDefCls){
        pnDto.setPn_id(UUID.randomUUID().toString().replace("-", ""));
        if(pnDto.getPn_curr()){
            if(processDefCls == 1)
                processDao.updateAllGroupProcessNodeCurr2False(pnDto.getGroup_id(),processDefCls);
            else if(processDefCls == 2)
                processDao.updateAllProductProcessNodeCurr2False(pnDto.getProduct_id(),processDefCls);
            else if(processDefCls == 3)
                processDao.updateAllStoreProcessNodeCurr2False(pnDto.getStore_id(),processDefCls);
        }
        ProcessNode pn = null;
        if(processDefCls == 1)
            pn = processDao.findProcessNodeByGroupIdAndPdId(pnDto);
        else if(processDefCls == 2)
            pn = processDao.findProcessNodeByProductIdAndPdId(pnDto);
        else if(processDefCls == 3)
            pn = processDao.findProcessNodeByStoreIdAndPdId(pnDto);

        if(pn == null){
            processDao.insertProcessNode(pnDto);
        }else{
            pnDto.setPn_id(pn.getPn_id());
            processDao.updateProcessNode(pnDto);
        }
    }

    @Override
    public void updateProcessNode(ProcessNodeDto pnDto, int processDefCls) {
        if(pnDto.getPn_curr()){
            if(pnDto.getPn_curr()){
                if(processDefCls == 1)
                    processDao.updateAllGroupProcessNodeCurr2False(pnDto.getGroup_id(),processDefCls);
                else if(processDefCls == 2)
                    processDao.updateAllProductProcessNodeCurr2False(pnDto.getProduct_id(),processDefCls);
                else if(processDefCls == 3)
                    processDao.updateAllStoreProcessNodeCurr2False(pnDto.getProduct_id(),processDefCls);
            }
        }
        processDao.updateProcessNode(pnDto);
    }

    @Override
    public void removeProcessNode(String pn_id){
        processDao.deleteProcessNodeById(pn_id);
    }



    @Override
    public void addGroup(GroupDto dto) {

        Date now = new Date();

        String group_id = groupIdFmt.format(now)+"-"+no.incrementAndGet();
        dto.setGroup_id(group_id);


        processDao.insertGroup(dto);

        ProcessNodeDto pnDto = new ProcessNodeDto();
        pnDto.setGroup_id(group_id);
        pnDto.setPn_date(now);
        pnDto.setPn_per(dto.getPer());
        pnDto.setPd_id(ProcessDefEnum.CLS_GROUP_DEF_ToGroup_1000.getCode());
        pnDto.setPn_curr(true);
        pnDto.setPn_status(true);

        this.addProcessNode(pnDto, ProcessDefEnum.CLS_GROUP.getCode());
    }

    @Override
    public void removeGroup(String group_id) {
        ProcessNode pn = processDao.findProcessNodeByGroupIdAndCurrentStatus(group_id,ProcessDefEnum.CLS_GROUP_DEF_ToGroup_1000.getCode());
        if(pn==null){
            throw new BusinessException("分组数据非待投坯状态，不允许删除！");
        }
        this.removeProcessNode(pn.getPn_id());
        processDao.deleteGroupById(group_id);
    }

    /**
     * 确认投坯
     * @param group_id
     * @param per
     */
    @Override
    public void doGroup(String group_id,String per) {
        ProcessNodeDto pnDto = new ProcessNodeDto();
        pnDto.setGroup_id(group_id);
        pnDto.setPn_date(new Date());
        pnDto.setPn_per(per);
        pnDto.setPd_id(ProcessDefEnum.CLS_GROUP_DEF_DoneGroup_1010.getCode());
        pnDto.setPn_curr(true);
        pnDto.setPn_status(true);
        this.addProcessNode(pnDto,ProcessDefEnum.CLS_GROUP.getCode());
    }

    @Override
    public List<ProcessNode>  getGroupProcessNodeList(String group_id,Integer pd_cls) {
        List<ProcessNode> list = processDao.findGroupProcessNodeList(group_id,pd_cls);
        boolean has = list.stream().anyMatch(item -> item.getPd_id() == 1070);
        if(has){
            ProcessNode pn = list.stream().filter(item->item.getPd_id() == 1060).findFirst().orElse(null);
            if(pn!=null)list.remove(pn);
        }
        return list;
    }

    @Override
    public void savePretreat(String group_id, Double retreat_num, String per) {

        if(retreat_num == null || retreat_num<1){
            throw new BusinessException("请录入正确产量！");
        }

        ProcessNodeDto pnDto = new ProcessNodeDto();
        pnDto.setGroup_id(group_id);
        pnDto.setPn_date(new Date());
        pnDto.setPn_per(per);
        pnDto.setPd_id(ProcessDefEnum.CLS_GROUP_DEF_DonePretreatment_1020.getCode());
        pnDto.setPn_curr(false);
        pnDto.setPn_status(false);

        ProcessNode pn = processDao.findProcessNodeByGroupIdAndPdId(pnDto);
        if(pn == null){//不存在存在流程节点
            this.addProcessNode(pnDto,ProcessDefEnum.CLS_GROUP.getCode());
        }
        processDao.updateNumOfGroup(group_id,"pretreat_num",retreat_num);
    }

    @Override
    public void doPretreat(String group_id, String per) {
        ProcessNodeDto pnDto = new ProcessNodeDto();

        pnDto.setGroup_id(group_id);
        pnDto.setPd_id(ProcessDefEnum.CLS_GROUP_DEF_DonePretreatment_1020.getCode());

        pnDto.setPn_date(new Date());
        pnDto.setPn_per(per);
        pnDto.setPn_curr(true);
        pnDto.setPn_status(true);

        ProcessNode pn = processDao.findProcessNodeByGroupIdAndPdId(pnDto);
        if(pn == null){//不存在存在流程节点
            throw new BusinessException("请先录入产量！");
        }

        this.updateProcessNode(pnDto,ProcessDefEnum.CLS_GROUP.getCode());

    }

    /* 染色 */
    @Override
    public void saveDye(String group_id, Double dye_num, String per) {
        if(dye_num == null || dye_num<1){
            throw new BusinessException("请录入正确产量！");
        }

        ProcessNodeDto pnDto = new ProcessNodeDto();
        pnDto.setGroup_id(group_id);
        pnDto.setPn_date(new Date());
        pnDto.setPn_per(per);
        pnDto.setPd_id(ProcessDefEnum.CLS_GROUP_DEF_DoneDye_1030.getCode());
        pnDto.setPn_curr(false);
        pnDto.setPn_status(false);

        ProcessNode pn = processDao.findProcessNodeByGroupIdAndPdId(pnDto);
        if(pn == null){//不存在流程节点
            this.addProcessNode(pnDto,ProcessDefEnum.CLS_GROUP.getCode());
        }
        processDao.updateNumOfGroup(group_id,"dye_num",dye_num);
    }

    @Override
    public void doDye(String group_id, String per) {
        ProcessNodeDto pnDto = new ProcessNodeDto();

        pnDto.setGroup_id(group_id);
        pnDto.setPd_id(ProcessDefEnum.CLS_GROUP_DEF_DoneDye_1030.getCode());

        pnDto.setPn_date(new Date());
        pnDto.setPn_per(per);
        pnDto.setPn_curr(true);
        pnDto.setPn_status(true);

        ProcessNode pn = processDao.findProcessNodeByGroupIdAndPdId(pnDto);
        if(pn == null){//不存在存在流程节点
            throw new BusinessException("请先录入产量！");
        }

        this.updateProcessNode(pnDto,ProcessDefEnum.CLS_GROUP.getCode());

    }

    /* 印花 */
    @Override
    public void savePrint(String group_id, Double print_num, String per) {
        if(print_num == null || print_num<1){
            throw new BusinessException("请录入正确产量！");
        }

        ProcessNodeDto pnDto = new ProcessNodeDto();
        pnDto.setGroup_id(group_id);
        pnDto.setPn_date(new Date());
        pnDto.setPn_per(per);
        pnDto.setPd_id(ProcessDefEnum.CLS_GROUP_DEF_DonePrint_1040.getCode());
        pnDto.setPn_curr(false);
        pnDto.setPn_status(false);

        ProcessNode pn = processDao.findProcessNodeByGroupIdAndPdId(pnDto);
        if(pn == null){//不存在流程节点
            this.addProcessNode(pnDto,ProcessDefEnum.CLS_GROUP.getCode());
        }
        processDao.updateNumOfGroup(group_id,"print_num",print_num);
    }

    @Override
    public void doPrint(String group_id, String per) {
        ProcessNodeDto pnDto = new ProcessNodeDto();

        pnDto.setGroup_id(group_id);
        pnDto.setPd_id(ProcessDefEnum.CLS_GROUP_DEF_DonePrint_1040.getCode());

        pnDto.setPn_date(new Date());
        pnDto.setPn_per(per);
        pnDto.setPn_curr(true);
        pnDto.setPn_status(true);

        ProcessNode pn = processDao.findProcessNodeByGroupIdAndPdId(pnDto);
        if(pn == null){//不存在存在流程节点
            throw new BusinessException("请先录入产量！");
        }

        this.updateProcessNode(pnDto,ProcessDefEnum.CLS_GROUP.getCode());

    }

    /* 整理 */
    @Override
    public void saveArrange(String group_id, Double arrange_num, String per) {
        if(arrange_num == null || arrange_num<1){
            throw new BusinessException("请录入正确产量！");
        }

        ProcessNodeDto pnDto = new ProcessNodeDto();
        pnDto.setGroup_id(group_id);
        pnDto.setPn_date(new Date());
        pnDto.setPn_per(per);
        pnDto.setPd_id(ProcessDefEnum.CLS_GROUP_DEF_DoneArrange_1050.getCode());
        pnDto.setPn_curr(false);
        pnDto.setPn_status(false);

        ProcessNode pn = processDao.findProcessNodeByGroupIdAndPdId(pnDto);
        if(pn == null){//不存在流程节点
            this.addProcessNode(pnDto,ProcessDefEnum.CLS_GROUP.getCode());
        }
        processDao.updateNumOfGroup(group_id,"arrange_num",arrange_num);
    }

    @Override
    public void doArrange(String group_id, String per) {
        ProcessNodeDto pnDto = new ProcessNodeDto();

        pnDto.setGroup_id(group_id);
        pnDto.setPd_id(ProcessDefEnum.CLS_GROUP_DEF_DoneArrange_1050.getCode());

        pnDto.setPn_date(new Date());
        pnDto.setPn_per(per);
        pnDto.setPn_curr(true);
        pnDto.setPn_status(true);

        ProcessNode pn = processDao.findProcessNodeByGroupIdAndPdId(pnDto);
        if(pn == null){//不存在存在流程节点
            throw new BusinessException("请先录入产量！");
        }

        this.updateProcessNode(pnDto,ProcessDefEnum.CLS_GROUP.getCode());
    }

    private AtomicLong prodId = new AtomicLong(System.currentTimeMillis());//产品编号

    @Override
    public void addGroupProducts(GroupCheckDto dto) {

        ProductDto productDto = new ProductDto();
        productDto.setGroup_id(dto.getGroup_id());
        productDto.setProduct_cus(dto.getProduct_cus());
        productDto.setProduct_std(dto.getProduct_std());
        productDto.setProduct_color(dto.getGourp_color());

        Date now = new Date();
        ProcessNodeDto pnDto = new ProcessNodeDto();
        pnDto.setPn_date(now);
        pnDto.setPn_per(dto.getPer());
        pnDto.setPd_id(ProcessDefEnum.CLS_PRODUCT_DEF_DoingCheck_2010.getCode());//质检中
        pnDto.setPn_curr(true);
        pnDto.setPn_status(true);

        //新增一等品
        productDto.setProduct_id(prodId.incrementAndGet());
        productDto.setProduct_level(ProductLevelEnum.LEVEL_01.getCode());
        productDto.setProduct_num(dto.getCheck_1());
        processDao.insertProduct(productDto);

        pnDto.setProduct_id(productDto.getProduct_id());
        this.addProcessNode(pnDto, ProcessDefEnum.CLS_PRODUCT.getCode());


        //新增二等品
        productDto.setProduct_id(prodId.incrementAndGet());
        productDto.setProduct_level(ProductLevelEnum.LEVEL_02.getCode());
        productDto.setProduct_num(dto.getCheck_2());
        processDao.insertProduct(productDto);

        pnDto.setProduct_id(productDto.getProduct_id());
        this.addProcessNode(pnDto, ProcessDefEnum.CLS_PRODUCT.getCode());

        //新增三等品
        productDto.setProduct_id(prodId.incrementAndGet());
        productDto.setProduct_level(ProductLevelEnum.LEVEL_03.getCode());
        productDto.setProduct_num(dto.getCheck_3());
        processDao.insertProduct(productDto);

        pnDto.setProduct_id(productDto.getProduct_id());
        this.addProcessNode(pnDto, ProcessDefEnum.CLS_PRODUCT.getCode());


        //新增等外品
        productDto.setProduct_id(prodId.incrementAndGet());
        productDto.setProduct_level(ProductLevelEnum.LEVEL_04.getCode());
        productDto.setProduct_num(dto.getCheck_4());
        processDao.insertProduct(productDto);

        pnDto.setProduct_id(productDto.getProduct_id());
        this.addProcessNode(pnDto, ProcessDefEnum.CLS_PRODUCT.getCode());

    }

    @Override
    public void addProductProcessNodesOfGroup(String group_id,String per, int pd_id) {
        Date now = new Date();
        ProcessNodeDto pnDto = new ProcessNodeDto();
        pnDto.setPn_date(now);
        pnDto.setPn_per(per);
        pnDto.setPd_id(ProcessDefEnum.CLS_PRODUCT_DEF_DoneCheck_2020.getCode());//质检中
        pnDto.setPn_curr(true);
        pnDto.setPn_status(true);


        List<Long> productIds = processDao.findProductIdsOfGroup(group_id);
        productIds.forEach(id->{
            pnDto.setProduct_id(id);
            this.addProcessNode(pnDto, ProcessDefEnum.CLS_PRODUCT.getCode());
        });

    }

    @Override
    public void updateNumOfGroupProducts(GroupCheckDto dto) {
        ProductDto productDto = new ProductDto();
        productDto.setGroup_id(dto.getGroup_id());

        productDto.setProduct_level(ProductLevelEnum.LEVEL_01.getCode());
        productDto.setProduct_num(dto.getCheck_1());
        processDao.updateNumOfProduct(productDto);

        productDto.setProduct_level(ProductLevelEnum.LEVEL_02.getCode());
        productDto.setProduct_num(dto.getCheck_2());
        processDao.updateNumOfProduct(productDto);

        productDto.setProduct_level(ProductLevelEnum.LEVEL_03.getCode());
        productDto.setProduct_num(dto.getCheck_3());
        processDao.updateNumOfProduct(productDto);

        productDto.setProduct_level(ProductLevelEnum.LEVEL_04.getCode());
        productDto.setProduct_num(dto.getCheck_4());
        processDao.updateNumOfProduct(productDto);


    }

    /**
     * 获取质检模块清单实现
     * @param dto
     * @return
     */
    @Override
    public Page<DyeGroup> getCheckGroupPage(GroupQueryDto dto) {
        return Page.getPage(dto,()->processDao.findCheckGroupList(dto));
    }

    @Override
    public void saveCheck(GroupCheckDto dto) {
        if(dto.getCheck_1() == null || dto.getCheck_1()<1){
            throw new BusinessException("请录入正确一等品数量！");
        }
//        if(dto.getCheck_2() == null || dto.getCheck_2()<1){
//            throw new BusinessException("请录入正确二等品数量！");
//        }
//        if(dto.getCheck_3() == null || dto.getCheck_3()<1){
//            throw new BusinessException("请录入正确三等品数量！");
//        }
//        if(dto.getCheck_4() == null || dto.getCheck_4()<1){
//            throw new BusinessException("请录入正确等外品数量！");
//        }
//        if(dto.getCheck_num() == null || dto.getCheck_num()<1){
//            throw new BusinessException("请录入正确质检数量！");
//        }

        ProcessNodeDto pnDto = new ProcessNodeDto();
        pnDto.setGroup_id(dto.getGroup_id());
        pnDto.setPn_date(new Date());
        pnDto.setPn_per(dto.getPer());
        pnDto.setPd_id(ProcessDefEnum.CLS_GROUP_DEF_DoingCheck_1060.getCode());
        pnDto.setPn_curr(true);
        pnDto.setPn_status(true);

        ProcessNode groupPn = processDao.findProcessNodeByGroupIdAndPdId(pnDto);
        if(groupPn == null){//不存在流程节点
            this.addProcessNode(pnDto,ProcessDefEnum.CLS_GROUP.getCode());
            this.addGroupProducts(dto);
            processDao.updateNumOfGroup(dto.getGroup_id(),"check_num",dto.getCheck_num());
        }else{
            processDao.updateNumOfGroup(dto.getGroup_id(),"check_num",dto.getCheck_num());
            this.updateNumOfGroupProducts(dto);
        }


    }

    @Override
    public void doCheck(String group_id, String per) {
        ProcessNodeDto pnDto = new ProcessNodeDto();


        pnDto.setPd_id(ProcessDefEnum.CLS_GROUP_DEF_DoingCheck_1060.getCode());

        pnDto.setPn_date(new Date());
        pnDto.setPn_per(per);
        pnDto.setPn_curr(true);
        pnDto.setPn_status(true);

        pnDto.setGroup_id(group_id);
        ProcessNode pn = processDao.findProcessNodeByGroupIdAndPdId(pnDto);
        if(pn == null){//不存在存在流程节点
            throw new BusinessException("请先录入产量！");
        }

        pnDto.setPd_id(ProcessDefEnum.CLS_GROUP_DEF_DoneCheck_1070.getCode());
        this.addProcessNode(pnDto,ProcessDefEnum.CLS_GROUP.getCode());


        //pnDto.setPd_id(ProcessDefEnum.CLS_PRODUCT_DEF_DoneCheck_2020.getCode());
        //this.addProcessNode(pnDto,ProcessDefEnum.CLS_PRODUCT.getCode());

        this.addProductProcessNodesOfGroup(group_id,per,ProcessDefEnum.CLS_PRODUCT_DEF_DoneCheck_2020.getCode());


    }

    @Override
    public List<Product> getGroupProductList(String group_id) {
        return processDao.findGroupProductList(group_id);
    }


    //成品包装
    @Override
    public Page<List<Product>> getPkgProductPage(ProductQueryDto dto) {
        return Page.getPage(dto,()->processDao.findPkgProductList(dto));
    }

    @Override
    public Page<List<Store>> getStorePage(StoreQueryDto dto) {
        return Page.getPage(dto,()->processDao.findStoreList(dto));
    }


    private AtomicLong storeId = new AtomicLong(System.currentTimeMillis());//包编号

    @Override
    public void addPkg(Long product_id, Double num,String per) {


        double lt = processDao.findPkgLTProduct(product_id,num);
        if(lt > 0){
            throw new BusinessException("包装量不允许大于成品量！");
        }

        StoreDto storeDto = new StoreDto();
        storeDto.setStore_id(storeId.incrementAndGet());
        storeDto.setProduct_id(product_id);
        storeDto.setStore_num(num);
        processDao.addStoreOfProduct(storeDto);



        ProcessNodeDto pnDto = new ProcessNodeDto();

        pnDto.setPn_date(new Date());
        pnDto.setPn_per(per);
        pnDto.setPn_curr(true);
        pnDto.setPn_status(true);

        pnDto.setProduct_id(product_id);
        pnDto.setPd_id(ProcessDefEnum.CLS_PRODUCT_DEF_DoingPackage_2030.getCode());

        ProcessNode pn = processDao.findProcessNodeByProductIdAndPdId(pnDto);
        if(pn == null){
            this.addProcessNode(pnDto,ProcessDefEnum.CLS_PRODUCT.getCode());
        }




        pnDto.setProduct_id(null);
        pnDto.setStore_id(storeDto.getStore_id());
        pnDto.setPd_id(ProcessDefEnum.CLS_STORE_DEF_DonePackage_3010.getCode());
        pnDto.setPn_curr(false);
        pnDto.setPn_status(false);
        this.addProcessNode(pnDto,ProcessDefEnum.CLS_STORE.getCode());

    }

    @Override
    public void deletePkg(Long store_id) {
        processDao.deleteProcessNodeByStoreId(store_id);
        processDao.deleteStoreById(store_id);

    }

    @Override
    public void completeProductPkg(Long product_id,String per) {
        double eq = processDao.findPkgEQProduct(product_id);

        if(Math.abs(eq)>0.01){
            throw new BusinessException("已确认包装量与成品量不符！");
        }

        ProcessNodeDto pnDto = new ProcessNodeDto();

        pnDto.setProduct_id(product_id);
        pnDto.setPd_id(ProcessDefEnum.CLS_PRODUCT_DEF_DonePackage_2040.getCode());
        pnDto.setPn_date(new Date());
        pnDto.setPn_per(per);
        pnDto.setPn_curr(true);
        pnDto.setPn_status(true);

        this.addProcessNode(pnDto, ProcessDefEnum.CLS_PRODUCT.getCode());
    }

    @Override
    public void completePkg(Long store_id, String per) {



        ProcessNodeDto pnDto = new ProcessNodeDto();


        pnDto.setStore_id(store_id);
        pnDto.setPd_id(ProcessDefEnum.CLS_STORE_DEF_DonePackage_3010.getCode());
        pnDto.setPn_date(new Date());
        pnDto.setPn_per(per);
        pnDto.setPn_curr(true);
        pnDto.setPn_status(true);

        ProcessNode pn = processDao.findProcessNodeByStoreIdAndPdId(pnDto);
        pnDto.setPn_id(pn.getPn_id());

        this.updateProcessNode(pnDto, ProcessDefEnum.CLS_STORE.getCode());
    }

    @Override
    public void completeStore(Long store_id, String per) {
        ProcessNodeDto pnDto = new ProcessNodeDto();


        pnDto.setStore_id(store_id);
        pnDto.setPd_id(ProcessDefEnum.CLS_STORE_DEF_DoneInStore_3020.getCode());
        pnDto.setPn_date(new Date());
        pnDto.setPn_per(per);
        pnDto.setPn_curr(true);
        pnDto.setPn_status(true);

        this.addProcessNode(pnDto,ProcessDefEnum.CLS_STORE.getCode());
    }

    @Override
    public void completeOut(Long store_id, String per) {
        ProcessNodeDto pnDto = new ProcessNodeDto();

        pnDto.setStore_id(store_id);
        pnDto.setPd_id(ProcessDefEnum.CLS_STORE_DEF_DoneOutStore_3030.getCode());
        pnDto.setPn_date(new Date());
        pnDto.setPn_per(per);
        pnDto.setPn_curr(true);
        pnDto.setPn_status(true);

        this.addProcessNode(pnDto,ProcessDefEnum.CLS_STORE.getCode());
    }


}
