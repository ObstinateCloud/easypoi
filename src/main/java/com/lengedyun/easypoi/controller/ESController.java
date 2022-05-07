package com.lengedyun.easypoi.controller;

import com.lengedyun.easypoi.SysUser;
import com.lengedyun.easypoi.dao.SysUserDao;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @title: ESController
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/5/7 11:49
 */

@RestController
@RequestMapping("es")
public class ESController {

    @Autowired
    private SysUserDao sysUserDao;

    @GetMapping("put")
    public String esPut(){
        List<String> list = new ArrayList<>();
        list.add("teacher");
        list.add("student");
        list.add("admin");
        list.add("leader");
        for (int i = 0; i < 1000; i++) {
            int toIndex = new Random(1).nextInt(4);
            SysUser build = SysUser.builder()
                    .password("123456")
                    .username("AI码师")
                    .level(i)
                    .roles(list.subList(0, toIndex))
                    .build();
            sysUserDao.save(build);
        }
        System.out.printf("结束");
        return "success";
    }

    @GetMapping("findAll")
    public void testFindAll(){
        Iterable<SysUser> all = sysUserDao.findAll();
        all.forEach((sysUser)->{
            System.out.println(sysUser.getId());
        });
    }

    @GetMapping("testDel")
    public void testDel(String id){
        sysUserDao.deleteById(id);
        System.out.println(sysUserDao.existsById(id));
    }

    @GetMapping("pageList")
    public void pageList(){
        Pageable pageable = PageRequest.of(0,10);
        Page<SysUser> all = sysUserDao.findAll(pageable);
        all.getContent().forEach(p->{
            System.out.println(p.getId());
        });
    }
}
