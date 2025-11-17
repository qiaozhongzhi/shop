package org.wendu.dye.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wendu.dye.common.Result;
import org.wendu.dye.common.page.Page;
import org.wendu.dye.dto.InfoAddUpdDto;
import org.wendu.dye.dto.InfoQueryDto;
import org.wendu.dye.serviceapi.BaseApi;

@RestController
@RequestMapping("/")
public class InfoApi {

    @Autowired
    private InfoService infoService;

    //获取员工列表数据
    @GetMapping("")//get请求发送参数不是json形式的请求体，而是普通的查询字符串（普通形式的参数），不用加@RequestBody注解
    public Result infoList(InfoQueryDto infoQueryDto){
        Page page = infoService.getPage(infoQueryDto);
        return Result.OK(page);
    }

    //新增员工信息，这里使用post请求，传递json形式的请求体，需要在参数上加注解@RequestBody
    @PostMapping("")
    public Result infoDoAdd(@RequestBody InfoAddUpdDto infoAddUpdDto){
        infoService.addOne(infoAddUpdDto);
        return Result.OK();
    }
    //按工号删除一个员工，这里参数是路径的一部分，方法的参数需要加@PathVariable注解
    @DeleteMapping("/{info_type}/{eid}")
    public Result infoDoDel(@PathVariable int info_type , @PathVariable  String eid){
        infoService.removeByIds(info_type,eid);
        return Result.OK();
    }

    //批量删除
    @DeleteMapping("/{info_type}")
    public Result infoDoDel(@PathVariable int info_type,@RequestBody String... eids){
        infoService.removeByIds(info_type,eids);
        return Result.OK();
    }

    //修改员工信息
    @PutMapping("")
    public Result infoDoUpd(@RequestBody InfoAddUpdDto infoAddUpdDto){
        infoService.updateInfo(infoAddUpdDto);
        return Result.OK();
    }

    @PutMapping("/{info_type}/{info_id}/{currentStatus}")
    public Result infoDoChangeStatus(@PathVariable int info_type,@PathVariable String info_id,@PathVariable String currentStatus){
        String msg = infoService.execChangeStatus(info_type,info_id,currentStatus);
        return Result.OK(msg);
    }




}
