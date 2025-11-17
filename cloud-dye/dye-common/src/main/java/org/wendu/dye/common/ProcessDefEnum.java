package org.wendu.dye.common;

public enum ProcessDefEnum {

    CLS_GROUP(1,"生产流程"),
    CLS_PRODUCT(2,"成品流程"),
    CLS_STORE(3,"包装流程"),

    CLS_GROUP_DEF_ToGroup_1000(1000,"待投坯"),
    CLS_GROUP_DEF_DoneGroup_1010(1010,"已投坯"),
    CLS_GROUP_DEF_DonePretreatment_1020(1020,"已前处理"),
    CLS_GROUP_DEF_DoneDye_1030(1030,"已染色"),
    CLS_GROUP_DEF_DonePrint_1040(1040,"已印花"),
    CLS_GROUP_DEF_DoneArrange_1050(1050,"已整理"),
    CLS_GROUP_DEF_DoingCheck_1060(1060,"质检中"),
    CLS_GROUP_DEF_DoneCheck_1070(1070,"已质检"),


    CLS_PRODUCT_DEF_DoingCheck_2010(2010,"质检中"),
    CLS_PRODUCT_DEF_DoneCheck_2020(2020,"已质检"),
    CLS_PRODUCT_DEF_DoingPackage_2030(2030,"打包中"),
    CLS_PRODUCT_DEF_DonePackage_2040(2040,"已打包"),

    CLS_STORE_DEF_DonePackage_3010(3010,"已打包"),
    CLS_STORE_DEF_DoneInStore_3020(3020,"已入库"),
    CLS_STORE_DEF_DoneOutStore_3030(3030,"已出库");


    private int code;
    private String name;

    private ProcessDefEnum(int code, String name){
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
        ProcessDefEnum[] arr = ProcessDefEnum.values();
        for(ProcessDefEnum clsEnum : arr){
            if(clsEnum.code == code){
                return clsEnum.name;
            }
        }
        return null;
    }
}
