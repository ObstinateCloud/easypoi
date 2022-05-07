package com.lengedyun.easypoi.enums;

/**
 * @title: OperateType
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/5/6 9:08
 */
public enum OperateType {
    OPERATE_TYPE_ADD("新增"),
    OPERATE_TYPE_UPDATE("修改"),
    OPERATE_TYPE_DELETE("删除");

    private final String operateType;

    OperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getOperateType() {
        return operateType;
    }
}
