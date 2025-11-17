package org.wendu.dye.exception;

public class SysExceptioin extends  RuntimeException{

    public SysExceptioin() {
    }

    public SysExceptioin(String message) {
        super(message);
    }

    public SysExceptioin(String message, Throwable cause) {
        super(message, cause);
    }

    public SysExceptioin(Throwable cause) {
        super(cause);
    }

    public SysExceptioin(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
