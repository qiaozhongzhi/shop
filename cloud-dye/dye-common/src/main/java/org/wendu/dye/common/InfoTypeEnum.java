package org.wendu.dye.common;

public enum InfoTypeEnum {

    CUSTOMER(1,"客户信息"),
    STANDARD(2,"规格信息"),
    COLOR(3,"花色号信息");


    private int code;
    private String name;

    private InfoTypeEnum(int code,String name){
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }


    public String getName() {
        return name;
    }

    public static String getTypeName(int code){
        InfoTypeEnum[] arr = InfoTypeEnum.values();
        for(InfoTypeEnum typeEnum : arr){
            if(typeEnum.code == code){
                return typeEnum.name;
            }
        }
        return null;
    }
}
