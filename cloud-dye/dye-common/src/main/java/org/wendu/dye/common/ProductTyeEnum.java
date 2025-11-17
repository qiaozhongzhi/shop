package org.wendu.dye.common;

/**
 * 产品分类枚举
 */
public enum ProductTyeEnum {

    WHITE(1,"白布"),
    DYE(2,"色布"),
    PRINT(3,"无底花布"),
    DYE_PRINT(4,"有底花布");



    private int code;
    private String name;

    private ProductTyeEnum(int code, String name){
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getStatusName(int code){
        ProductTyeEnum[] arr = ProductTyeEnum.values();
        for(ProductTyeEnum statuEnum : arr){
            if(statuEnum.code == code){
                return statuEnum.name;
            }
        }
        return null;
    }
}
