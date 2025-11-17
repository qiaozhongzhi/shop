package org.wendu.dye.common;

/**
 * 标准响应结果的封装类
 */
public class Result<T> {

    public static final int CODE_OK = 200;//表示成功
    public static final int CODE_ERR_BUSINESS = 500;//表示业务错误（用户操作失误导致的错误）
    public static final int CODE_ERR_UNLOGINED = 520;;//表示未登录
    public static final int CODE_ERR_SYS = 530;//系统错误


    /**
     * 无信息无数据的成功响应结果
     * @return
     */
    public static Result<?> OK(){
        return new Result<>(true, CODE_OK, null, null);
    }

    /**
     * 有信息无数据的成功响应结果
     * @return
     */
    public static Result<?> OK(String message){
        return new Result<>(true, CODE_OK, message, null);
    }

    /**
     * 无信息有数据的成功响应结果
     * @return
     */
    public static <T>  Result<T> OK(T data){
        return new Result<>(true, CODE_OK, null, data);
    }

    /**
     * 有信息有数据的成功响应结果
     * @return
     */
    public static <T> Result<T> OK(String message,T data){
        return new Result<>(true, CODE_OK, message, data);
    }

    /**
     * 有信息无数据的错误响应结果
     * @return
     */
    public static Result<?> error(int errCode,String message){
        return new Result<>(false, errCode, message, null);
    }

    /**
     * 有信息无数据的错误响应结果
     * @return
     */
    public static <T> Result<T> error(int errCode,String message,T data){
        return new Result<>(false, errCode, message, data);
    }



    private boolean success;//是否操作成功
    private int code;//业务代码 200 表示成功 ，500 表示业务错误（用户操作失误导致的错误），520 表示未登录，530 系统错误
    private String message;//对操作结果的简要说明
    private T data;//向前端回送的数据


    //构造方法私有：使用者无法直接通过构造方法创建对象
    private Result(boolean success, int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
    public T getData() {
        return data;
    }
}
