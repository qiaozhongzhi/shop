package org.wendu.dye.serviceapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.wendu.dye.common.Result;
import org.wendu.dye.common.DyeConstants;

@FeignClient("service-base")
public interface BaseApi {

    //访问基础服务的/base/info/{info_type}，获取所基础信息数据
    @GetMapping("/base/info/{info_type}")
    public Result infos(@PathVariable Integer info_type);

    //访问基础服务的/base/info，获取基础信息数据
    @GetMapping("/base/info")
    public Result infos();

    //访问基础服务中令牌校验功能
    @GetMapping("/base/token/verify")
    public Result verifyToken(@RequestHeader(value = DyeConstants.HEADER_NAME_TOKEN,required = false) String clientToken);


    //访问基础服务的/base/process-def,获取流程定义数据
    @GetMapping("/base/process-def")
    public Result processDefs();

}
