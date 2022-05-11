package com.lengedyun.easypoi.controller;

import com.lengedyun.easypoi.aop.AutoLog;
import com.lengedyun.easypoi.bo.OrderlyExectionStatusBo;
import com.lengedyun.easypoi.enums.BusinessType;
import com.lengedyun.easypoi.enums.OperateType;
import com.lengedyun.easypoi.service.AopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title: AopController
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/5/6 14:39
 */
@Api(tags = "aop测试")
@RestController
@RequestMapping(value ="/aop")
public class AopController {

    @Autowired
    private AopService aopService;

    @ApiOperation("方法切面")
    @GetMapping("/methodAop")
    public String methodAopTest(OrderlyExectionStatusBo orderlyExectionStatusBo){
        String orderlyExectionStatusBo1 = aopService.getOrderlyExectionStatusBo(orderlyExectionStatusBo);
        return orderlyExectionStatusBo1;
    }
}
