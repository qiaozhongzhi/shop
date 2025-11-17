package org.wendu.dye.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wendu.dye.common.Result;
import org.wendu.dye.common.TokenUtils;
import org.wendu.dye.common.DyeConstants;
import org.wendu.dye.exception.BusinessException;
import org.wendu.dye.exception.NotAuthenticatedException;
import org.wendu.dye.model.Info;
import org.wendu.dye.model.ProcessDef;

import java.util.List;

@RestController
@RequestMapping("/base")
public class BaseApi {

    @Autowired
    private BaseService baseService;

    //按信息类型获取基础信息
    @GetMapping("/info/{info_type}")
    public Result customers(@PathVariable Integer info_type){
        List<Info> list = baseService.getInfoList(info_type);
        return Result.OK(list);
    }

    //获取基础信息
    @GetMapping("/info")
    public Result<List<Info>> customers(){
        List<Info> list = baseService.getInfoList();
        return Result.OK(list);
    }


    //校验令牌
    @GetMapping("/token/verify")
    public Result verifyToken(@RequestHeader(value = DyeConstants.HEADER_NAME_TOKEN,required = false) String clientToken){
        try {
            TokenUtils.verify(clientToken);
            return Result.OK();//NotAuthenticatedException
        } catch (BusinessException e) {
            return Result.error(Result.CODE_ERR_UNLOGINED, e.getMessage());
        }catch (NotAuthenticatedException e) {
            return Result.error(Result.CODE_ERR_UNLOGINED, e.getMessage());
        } catch (Exception e){
            return Result.error(Result.CODE_ERR_SYS, "系统错误");
        }
    }

    //获取流程定义数据
    @GetMapping("/process-def")
    public Result<List<ProcessDef>> processDefs(){
        List<ProcessDef> list = baseService.getProdessDefList();
        return Result.OK(list);
    }
}
