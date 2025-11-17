package org.wendu.dye.security.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wendu.dye.common.CurrentUser;
import org.wendu.dye.common.Result;
import org.wendu.dye.common.TokenUtils;
import org.wendu.dye.common.DyeConstants;
import org.wendu.dye.security.service.HomeService;

@RestController
@RequestMapping("/home")
public class HomeApi {

    @Autowired
    private HomeService homeService;


    @GetMapping("/curr-user")
    public Result currentUser(@RequestHeader(DyeConstants.HEADER_NAME_TOKEN) String clientToken){

        //测试令牌的校验
        //TokenUtils.verify(clientToken);

        /**
         * @RequestHeader("Token") String clientToken 的含义如下：
         * 声明参数clientToken是从请求头中获取的，而且来源于名称为Token的请求头
         */

        //通过令牌工具类的工具方法从客户端传来的token中获取当前用户信息
        CurrentUser currentUser = TokenUtils.getCurrentUser(clientToken);
        return Result.OK(currentUser);

    }


    //退出api
    @DeleteMapping("/logout")
    public Result logout(@RequestHeader(DyeConstants.HEADER_NAME_TOKEN)  String clentToken){
        TokenUtils.removeToken(clentToken);//从redis清除令牌
        return Result.OK();
    }

    //获取菜单
    @GetMapping("/menu-list")
    public Result menuList(@RequestHeader(DyeConstants.HEADER_NAME_TOKEN)  String clentToken){
        CurrentUser currentUser = TokenUtils.getCurrentUser(clentToken);
        return Result.OK(homeService.getMenuList(currentUser.getUserId()));
    }

    //获取菜单-移动端
    @GetMapping("/menu-list-m")
    public Result menuList_m(@RequestHeader(DyeConstants.HEADER_NAME_TOKEN)  String clentToken){
        CurrentUser currentUser = TokenUtils.getCurrentUser(clentToken);
        return Result.OK(homeService.getMenuListM(currentUser.getUserId()));
    }

}
