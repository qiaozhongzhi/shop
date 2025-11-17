package org.wendu.dye.common;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.wendu.dye.exception.BusinessException;
import org.wendu.dye.exception.NotAuthenticatedException;
import org.wendu.dye.exception.SysExceptioin;

/**
 * 加了@RestControllerAdvice注解的类，
 * SpringMVC(SpringBoot)会自动识别，并强其中定义异常处理方法应用于所用的控制器
 * 内部底层使用的是AOP技术
 *
 */
@Slf4j //引入该注解可以方便日志输出（会自动定义一个日志输出对象log）
@RestControllerAdvice
public class DyeControllerAdvice {

    //@ExceptionHandler注解表示这是一个处理错误的方法
    @ExceptionHandler(BusinessException.class)//专门处理业务错误
    public Result handleBusinessException(BusinessException e){
        return Result.error(Result.CODE_ERR_BUSINESS, e.getMessage());
    }

    @ExceptionHandler(NotAuthenticatedException.class)//专门处理业务错误
    public Result handleNotAuthenticatedException(NotAuthenticatedException e){
        return Result.error(Result.CODE_ERR_UNLOGINED, e.getMessage());
    }

    //@ExceptionHandler注解表示这是一个处理错误的方法
    @ExceptionHandler(SysExceptioin.class)//专门系统业务错误
    public Result handleSysException(SysExceptioin e){
        //对于系统错误，一定要进行日志输出，方便技术人员在生产环境（在用户处完成部署，正常运行的环境）中查看日志排错
        log.error("系统错误！", e);
        return Result.error(Result.CODE_ERR_SYS, "系统升级中......");
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Throwable t){
        //对于系统错误，一定要进行日志输出，方便技术人员在生产环境（在用户处完成部署，正常运行的环境）中查看日志排错
        log.error("系统错误！", t);
        return Result.error(Result.CODE_ERR_SYS, "系统错误，请与管理员联系。");
    }
}
