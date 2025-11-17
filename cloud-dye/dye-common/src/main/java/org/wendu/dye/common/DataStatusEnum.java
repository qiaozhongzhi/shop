package org.wendu.dye.common;

/**
 * 请假状态枚举
 */
public enum DataStatusEnum {

    UNDETERMINED("00","未确定"),
    DETERMINED("22",""),
    ACTIVED("55","启用"),
    DISABLED("77","禁用"),
    LOGICALLY_DELETED("99","逻辑删除");



    private String code;
    private String name;

    private DataStatusEnum(String code, String name){
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
        DataStatusEnum[] arr = DataStatusEnum.values();
        for(DataStatusEnum statuEnum : arr){
            if(statuEnum.code.equals(code)){
                return statuEnum.name;
            }
        }
        return null;
    }
}
