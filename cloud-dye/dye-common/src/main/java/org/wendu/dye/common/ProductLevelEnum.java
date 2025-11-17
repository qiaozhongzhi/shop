package org.wendu.dye.common;

/**
 * 产品等级枚举
 */
public enum ProductLevelEnum {

    LEVEL_01("01","一等品"),
    LEVEL_02("02","二等品"),
    LEVEL_03("03","三等品"),
    LEVEL_04("04","等外品");



    private String code;
    private String name;

    private ProductLevelEnum(String code, String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getStatusName(String code){
        ProductLevelEnum[] arr = ProductLevelEnum.values();
        for(ProductLevelEnum statuEnum : arr){
            if(statuEnum.code.equals(code)){
                return statuEnum.name;
            }
        }
        return null;
    }
}
