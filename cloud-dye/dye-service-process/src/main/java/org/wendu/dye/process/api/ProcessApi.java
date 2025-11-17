package org.wendu.dye.process.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wendu.dye.common.CurrentUser;
import org.wendu.dye.common.DyeConstants;
import org.wendu.dye.common.Result;
import org.wendu.dye.common.TokenUtils;
import org.wendu.dye.common.page.Page;
import org.wendu.dye.model.*;
import org.wendu.dye.process.dto.*;
import org.wendu.dye.process.servcie.ProcessService;
import org.wendu.dye.serviceapi.BaseApi;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProcessApi {

    @Autowired
    private BaseApi baseApi;

    @Autowired
    private ProcessService processService;

    @GetMapping("/process-def")
    public Result<List<ProcessDef>> processDefList(){
        return baseApi.processDefs();
    }

    @GetMapping("/plan")
    public Result PlanList(PlanQueryDto dto){
        Page<DyePlan> page = processService.getPlanPage(dto);
        return Result.OK(page);
    }

    @GetMapping("/group")
    public Result groupList(GroupQueryDto dto){
        Page<DyeGroup> page = processService.getGroupPage(dto);
        return Result.OK(page);
    }

    @PostMapping("/group")
    public Result groupDoAdd(@RequestBody GroupDto dto, @RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        CurrentUser currentUser = TokenUtils.getCurrentUser(token);
        dto.setPer(currentUser.getUserId()+"|"+currentUser.getUserName());
        processService.addGroup(dto);
        return Result.OK();
    }

    @DeleteMapping("/group/{group_id}")
    public Result groupDoDel(@PathVariable String group_id){
        processService.removeGroup(group_id);
        return Result.OK();
    }

    @PutMapping("/group/done/{group_id}")
    public Result groupDoGroup(@PathVariable String group_id, @RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        CurrentUser currentUser = TokenUtils.getCurrentUser(token);
        String per = currentUser.getUserId()+"|"+currentUser.getUserName();
        processService.doGroup(group_id,per);
        return Result.OK();
    }

    @GetMapping("/nodes/{group_id}/{pd_cls}")
    public Result groupProcessNodeList(@PathVariable String group_id,@PathVariable Integer pd_cls){

        return Result.OK(processService.getGroupProcessNodeList(group_id,pd_cls));
    }

    /* 前处理 */
    @GetMapping("/pretreat")
    public Result groupPretreatList(GroupQueryDto dto) {
        Page<DyeGroup> page = processService.getGroupPage(dto);
        return Result.OK(page);
    }

    @PutMapping("/pretreat/save/{group_id}/{retreat_num}")
    public Result groupSavePretreat(@PathVariable String group_id,@PathVariable Double retreat_num, @RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        CurrentUser currentUser = TokenUtils.getCurrentUser(token);
        String per = currentUser.getUserId()+"|"+currentUser.getUserName();
        processService.savePretreat(group_id,retreat_num,per);
        return Result.OK();
    }

    @PutMapping("/pretreat/done/{group_id}")
    public Result groupDoPretreat(@PathVariable String group_id, @RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        CurrentUser currentUser = TokenUtils.getCurrentUser(token);
        String per = currentUser.getUserId()+"|"+currentUser.getUserName();
        processService.doPretreat(group_id,per);
        return Result.OK();
    }

    /* 染色 */
    @GetMapping("/dye")
    public Result groupDyeList(GroupQueryDto dto) {
        dto.setAcceptedProdTypes(new Integer[]{2,4});
        Page<DyeGroup> page = processService.getGroupPage(dto);
        return Result.OK(page);
    }

    @PutMapping("/dye/save/{group_id}/{dye_num}")
    public Result groupSaveDye(@PathVariable String group_id,@PathVariable Double dye_num, @RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        CurrentUser currentUser = TokenUtils.getCurrentUser(token);
        String per = currentUser.getUserId()+"|"+currentUser.getUserName();
        processService.saveDye(group_id,dye_num,per);
        return Result.OK();
    }

    @PutMapping("/dye/done/{group_id}")
    public Result groupDoDye(@PathVariable String group_id, @RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        CurrentUser currentUser = TokenUtils.getCurrentUser(token);
        String per = currentUser.getUserId()+"|"+currentUser.getUserName();
        processService.doDye(group_id,per);
        return Result.OK();
    }

    /* 印花 */
    @GetMapping("/print")
    public Result groupPrintList(GroupQueryDto dto) {
        dto.setAcceptedProdTypes(new Integer[]{3,4});
        dto.setPrint(true);//请求数据为印花模块
        Page<DyeGroup> page = processService.getGroupPage(dto);
        return Result.OK(page);
    }

    @PutMapping("/print/save/{group_id}/{print_num}")
    public Result groupSaveprint(@PathVariable String group_id,@PathVariable Double print_num, @RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        CurrentUser currentUser = TokenUtils.getCurrentUser(token);
        String per = currentUser.getUserId()+"|"+currentUser.getUserName();
        processService.savePrint(group_id,print_num,per);
        return Result.OK();
    }

    @PutMapping("/print/done/{group_id}")
    public Result groupDoprint(@PathVariable String group_id, @RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        CurrentUser currentUser = TokenUtils.getCurrentUser(token);
        String per = currentUser.getUserId()+"|"+currentUser.getUserName();
        processService.doPrint(group_id,per);
        return Result.OK();
    }

    /* 整理 */
    @GetMapping("/arrange")
    public Result groupArrangeList(GroupQueryDto dto) {
        dto.setArrange(true);//请求数据为整理模块
        Page<DyeGroup> page = processService.getGroupPage(dto);
        return Result.OK(page);
    }

    @PutMapping("/arrange/save/{group_id}/{arrange_num}")
    public Result groupSaveArrange(@PathVariable String group_id,@PathVariable Double arrange_num, @RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        CurrentUser currentUser = TokenUtils.getCurrentUser(token);
        String per = currentUser.getUserId()+"|"+currentUser.getUserName();
        processService.saveArrange(group_id,arrange_num,per);
        return Result.OK();
    }

    @PutMapping("/arrange/done/{group_id}")
    public Result groupDoArrange(@PathVariable String group_id, @RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        CurrentUser currentUser = TokenUtils.getCurrentUser(token);
        String per = currentUser.getUserId()+"|"+currentUser.getUserName();
        processService.doArrange(group_id,per);
        return Result.OK();
    }

    /*质检*/
    @GetMapping("/check")
    public Result groupCheckList(GroupQueryDto dto){
        Page<DyeGroup> page = processService.getCheckGroupPage(dto);
        return Result.OK(page);
    }
    @PutMapping("/check/save")
    public Result groupSaveCheck(@RequestBody GroupCheckDto dto, @RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        CurrentUser currentUser = TokenUtils.getCurrentUser(token);
        String per = currentUser.getUserId()+"|"+currentUser.getUserName();
        dto.setPer(per);
        processService.saveCheck(dto);
        return Result.OK();
    }

    @PutMapping("/check/done/{group_id}")
    public Result groupDoCheck(@PathVariable String group_id, @RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        CurrentUser currentUser = TokenUtils.getCurrentUser(token);
        String per = currentUser.getUserId()+"|"+currentUser.getUserName();
        processService.doCheck(group_id,per);
        return Result.OK();
    }

    @GetMapping("/product-list/{group_id}")
    public Result groupProductList(@PathVariable String group_id){
       List<Product> list = processService.getGroupProductList(group_id);
       return Result.OK(list);
    }

    /*包装*/
    @GetMapping("/pkg/product-list")
    public Result pkgProductList(ProductQueryDto dto){
        Page<List<Product>> page = processService.getPkgProductPage(dto);
        return Result.OK(page);
    }

    @GetMapping("/pkg/pkg-list")
    public Result pkgList(StoreQueryDto dto){
        Page<List<Store>> page = processService.getStorePage(dto);
        return Result.OK(page);
    }

    @PostMapping("/pkg/pkg-add/{product_id}/{num}")
    public Result pkgDoAdd(@PathVariable Long product_id,@PathVariable Double num,@RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        CurrentUser currentUser = TokenUtils.getCurrentUser(token);
        String per = currentUser.getUserId()+"|"+currentUser.getUserName();
        processService.addPkg(product_id,num,per);
        return Result.OK();
    }

    @DeleteMapping("/pkg/{store_id}")
    public Result pkgDoDel(@PathVariable Long store_id){
        processService.deletePkg(store_id);
        return Result.OK();
    }

    @PutMapping("/pkg/all-done/{product_id}")
    public Result pkgDoProductComplete(@PathVariable Long product_id,@RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        CurrentUser currentUser = TokenUtils.getCurrentUser(token);
        String per = currentUser.getUserId()+"|"+currentUser.getUserName();
        processService.completeProductPkg(product_id,per);
        return Result.OK();
    }

    @PutMapping("/pkg/done/{store_id}")
    public Result pkgDoComplete(@PathVariable Long store_id,@RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        CurrentUser currentUser = TokenUtils.getCurrentUser(token);
        String per = currentUser.getUserId()+"|"+currentUser.getUserName();
        processService.completePkg(store_id,per);
        return Result.OK();
    }


    //入库
    @GetMapping("/store")
    public Result storeList(StoreQueryDto dto){
        Page<List<Store>> page = processService.getStorePage(dto);
        return Result.OK(page);
    }

    @PutMapping("/store/done/{store_id}")
    public Result storesDoComplete(@PathVariable Long store_id,@RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        CurrentUser currentUser = TokenUtils.getCurrentUser(token);
        String per = currentUser.getUserId()+"|"+currentUser.getUserName();
        processService.completeStore(store_id,per);
        return Result.OK();
    }

    //出库
    @GetMapping("/out")
    public Result outList(StoreQueryDto dto){
        Page<List<Store>> page = processService.getStorePage(dto);
        return Result.OK(page);
    }

    @PutMapping("/out/done/{store_id}")
    public Result outDoComplete(@PathVariable Long store_id,@RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String token){
        CurrentUser currentUser = TokenUtils.getCurrentUser(token);
        String per = currentUser.getUserId()+"|"+currentUser.getUserName();
        processService.completeOut(store_id,per);
        return Result.OK();
    }



}
