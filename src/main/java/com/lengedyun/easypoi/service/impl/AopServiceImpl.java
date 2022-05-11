package com.lengedyun.easypoi.service.impl;

import com.lengedyun.easypoi.aop.AutoLog;
import com.lengedyun.easypoi.bo.OrderlyExectionStatusBo;
import com.lengedyun.easypoi.enums.BusinessType;
import com.lengedyun.easypoi.enums.OperateType;
import com.lengedyun.easypoi.service.AopService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: AopServiceImpl
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/5/6 14:55
 */
@Service
public class AopServiceImpl implements AopService {

    @Override
    @AutoLog(value = "methodAop",businessType = BusinessType.BUSINESS_TYPE_2,operateType = OperateType.OPERATE_TYPE_DELETE)
    public String getOrderlyExectionStatusBo(OrderlyExectionStatusBo orderlyExectionStatusBo) {
        System.out.println(orderlyExectionStatusBo.toString());
        return orderlyExectionStatusBo.toString();
    }
}
