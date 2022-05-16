package com.lengedyun.easypoi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title: RedisController
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/5/12 14:59
 */
@Api(tags = "redis 测试")
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation(value = "putValue 测试")
    @GetMapping("putValue")
    private void putValue(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    @ApiOperation(value = "getValue 测试")
    @GetMapping("getValue")
    private String putValue(String key){
        Object o = redisTemplate.opsForValue().get(key);
        return o.toString();
    }
}
