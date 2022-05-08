package com.lengedyun.easypoi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lengedyun.easypoi.bo.SysUser;
import com.lengedyun.easypoi.bo.SysUserSearcher;
import com.lengedyun.easypoi.dao.SysUserDao;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Autowired
    private SysUserSearcher sysUserSearcher;

    @Autowired
    RestHighLevelClient restHighLevelClient;


    @GetMapping("put")
    public String esPut() {
        List<String> list = new ArrayList<>();
        list.add("teacher");
        list.add("student");
        list.add("admin");
        list.add("leader");
        for (int i = 0; i < 10; i++) {
            int toIndex = new Random(1).nextInt(4);
            SysUser build = SysUser.builder()
                    .password("123456" + i)
                    .username("AI码师" + i)
                    .level(i)
                    .roles(list.subList(0, toIndex))
                    .build();
            sysUserDao.save(build);
        }
        System.out.printf("结束");
        return "success";
    }

    @GetMapping("findAll")
    public void testFindAll() {
        Iterable<SysUser> all = sysUserDao.findAll();
        all.forEach((sysUser) -> {
            System.out.println(sysUser.getId());
        });
    }

    @GetMapping("testDel")
    public void testDel(String id) {
        sysUserDao.deleteById(id);
        System.out.println(sysUserDao.existsById(id));
    }

    @GetMapping("pageList")
    public void pageList() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<SysUser> all = sysUserDao.findAll(pageable);
        all.getContent().forEach(p -> {
            System.out.println(p.getId());
        });
    }

    @GetMapping("findById")
    public JSONObject findById(String id) {
        JSONObject jsonObject = new JSONObject();
        Optional<SysUser> sysUser = sysUserDao.findById(id);
        jsonObject = JSONObject.parseObject(JSON.toJSONString(sysUser));

        return jsonObject;
    }

    @GetMapping("findByUsername")
    public JSONArray findByUsername(String userName) {
        List<SysUser> sysUsers = sysUserDao.findSysUsersByUsername(userName);//精确匹配
//        List<SysUser> sysUsers = sysUserDao.findByUsername(userName);//精确匹配
        JSONArray objects = JSON.parseArray(JSON.toJSONString(sysUsers));
        return objects;
    }

    @GetMapping("findByLevel")
    public JSONArray findByLevel(int level) {
        List<SysUser> sysUsers = sysUserDao.findSysUsersByLevelGreaterThanEqual(level);
//        List<SysUser> sysUsers = sysUserDao.findByLevelGreaterThanEqual(level);
        JSONArray objects = JSON.parseArray(JSON.toJSONString(sysUsers));
        return objects;
    }

    @GetMapping(value = "findByPass")
    public JSONArray findByPass(String password) {
        List<SysUser> sysUsers = sysUserSearcher.findByPassword(password);
        JSONArray objects = JSON.parseArray(JSON.toJSONString(sysUsers));
        return objects;
    }

    @GetMapping(value = "createIndex")
    public CreateIndexResponse createIndex(String index) {
        //创建索引请求
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(index);
        //client 执行请求
        CreateIndexResponse createIndexResponse = null;
        try {
            createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return createIndexResponse;
    }

    @GetMapping(value = "createMapping")
    public CreateIndexResponse createMapping(String index) {
        //创建索引请求
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(index);
        //client 执行请求
        CreateIndexResponse createIndexResponse = null;
        try {
            String mapping = "{\n" +
                    "  \"properties\":{\n" +
                    "    \"name\":{\n" +
                    "      \"type\":\"keyword\"\n" +
                    "    },\n" +
                    "    \"age\":{\n" +
                    "      \"type\":\"integer\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
            createIndexRequest.mapping(mapping, XContentType.JSON);
            createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return createIndexResponse;
    }

    @GetMapping(value = "indexExists")
    public boolean indexExists(String index) {
        //创建索引请求
        GetIndexRequest getIndexRequest = new GetIndexRequest(index);
        //client 执行请求
        boolean exists = false;
        try {
            exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return exists;
    }

    @GetMapping(value = "delIndex")
    public AcknowledgedResponse delIndex(String index) {
        //创建索引请求
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(index);
        //client 执行请求
        AcknowledgedResponse delete = null;
        try {
            delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return delete;
    }
}
