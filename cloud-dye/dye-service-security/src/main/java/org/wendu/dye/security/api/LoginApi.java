package org.wendu.dye.security.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wendu.dye.common.CurrentUser;
import org.wendu.dye.common.Result;
import org.wendu.dye.common.TokenUtils;
import org.wendu.dye.dto.LoginDto;
import org.wendu.dye.security.service.LoginService;

@RestController
@RequestMapping("/login") //配置本控制器（API）所有映射路径的前缀
public class LoginApi {

    @Autowired
    private LoginService loginService;

    //这里以json请求体形式接收参数，并封装到LoginDto对象
    @PostMapping()
    public Result login(@RequestBody LoginDto loginDto){
        //若验证未通过，必然抛出异常，被统一的异常处理组件WdoaControllerAdvice处理
        CurrentUser currentUser = loginService.checkLogin(loginDto);

        //登录成功后，使用令牌工具类生成令牌（token）
        String token = TokenUtils.loginSign(currentUser,loginDto.getU_pwd());

        //向客户端发送token(将参数向上转型为Object类型的目的是调用OK(Object)方法)
        return Result.OK((Object)token);

    }

}
