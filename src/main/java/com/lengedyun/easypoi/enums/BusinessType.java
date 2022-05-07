package com.lengedyun.easypoi.enums;

/**
 * @title: BusinessType
 * @description: 业务类型
 * @auther: zhangjianyun
 * @date: 2022/5/6 9:05
 */
public enum BusinessType {

    BUSINESS_TYPE_1("台区管理"),
    BUSINESS_TYPE_2("运营事件"),
    BUSINESS_TYPE_3("原材料管理"),
    BUSINESS_TYPE_4("组装监测");


    private final String businessType;

    BusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessType() {
        return businessType;
    }
}
