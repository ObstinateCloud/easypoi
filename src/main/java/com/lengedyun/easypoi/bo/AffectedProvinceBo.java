package com.lengedyun.easypoi.bo;

import lombok.Data;

/**
 * 省最大有序用电负荷及受影响户数
 * @author zxx
 */
@Data
public class AffectedProvinceBo {

    private String company;

    private String orderlyPowerLoad;

    private double affectedHousehold;
}
