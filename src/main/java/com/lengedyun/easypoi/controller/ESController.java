package com.lengedyun.easypoi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lengedyun.easypoi.bo.SysUser;
import com.lengedyun.easypoi.bo.SysUserSearcher;
import com.lengedyun.easypoi.dao.SysUserDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
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
@Api(tags = "es 测试接口")
public class ESController {

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysUserSearcher sysUserSearcher;

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @ApiOperation("继承ElasticsearchRepository 父类默认新增方法")
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
    @ApiOperation("继承ElasticsearchRepository 父类默认查询全部")
    @GetMapping("findAll")
    public void testFindAll() {
        Iterable<SysUser> all = sysUserDao.findAll();
        all.forEach((sysUser) -> {
            System.out.println(sysUser.getId());
        });
    }

    @ApiOperation("继承ElasticsearchRepository 父类默认删除")
    @GetMapping("testDel")
    public void testDel(String id) {
        sysUserDao.deleteById(id);
        System.out.println(sysUserDao.existsById(id));
    }
    @ApiOperation("继承ElasticsearchRepository 父类默认分页查询")
    @GetMapping("pageList")
    public void pageList() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<SysUser> all = sysUserDao.findAll(pageable);
        all.getContent().forEach(p -> {
            System.out.println(p.getId());
        });
    }

    @ApiOperation("继承ElasticsearchRepository 父类默认方法")
    @GetMapping("findById")
    public JSONObject findById(String id) {
        JSONObject jsonObject = new JSONObject();
        Optional<SysUser> sysUser = sysUserDao.findById(id);
        jsonObject = JSONObject.parseObject(JSON.toJSONString(sysUser));

        return jsonObject;
    }

    @ApiOperation("继承ElasticsearchRepository 自定义jpa字段查询")
    @GetMapping("findByUsername")
    public JSONArray findByUsername(@ApiParam(value = "用户名", required =true)String userName) {
        List<SysUser> sysUsers = sysUserDao.findSysUsersByUsername(userName);//精确匹配
//        List<SysUser> sysUsers = sysUserDao.findByUsername(userName);//精确匹配
        JSONArray objects = JSON.parseArray(JSON.toJSONString(sysUsers));
        return objects;
    }

    @ApiOperation("继承ElasticsearchRepository 自定义jpa范围查询")
    @GetMapping("findByLevel")
    public JSONArray findByLevel(@ApiParam(value = "层级", required =true)int level) {
        List<SysUser> sysUsers = sysUserDao.findSysUsersByLevelGreaterThanEqual(level);
//        List<SysUser> sysUsers = sysUserDao.findByLevelGreaterThanEqual(level);
        JSONArray objects = JSON.parseArray(JSON.toJSONString(sysUsers));
        return objects;
    }

    @ApiOperation("Criteria 方式查询")
    @GetMapping(value = "findByPass")
    public JSONArray findByPass(@ApiParam(value = "密码", required =true)String password) {
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
    @ApiOperation("RestHighLevelClient 创建索引")
    @GetMapping(value = "createMapping")
    public CreateIndexResponse createMapping(@ApiParam(value = "索引", required =true)String index) {
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

    @ApiOperation("RestHighLevelClient 判断索引是否存在")
    @GetMapping(value = "indexExists")
    public boolean indexExists(@ApiParam(value = "索引", required =true)String index) {
        //查询索引请求
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
    @ApiOperation("RestHighLevelClient 删除索引")
    @GetMapping(value = "delIndex")
    public AcknowledgedResponse delIndex(@ApiParam(value = "索引", required =true)String index) {
        //删除索引请求
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

    @GetMapping(value = "createDoc")
    @ApiOperation("RestHighLevelClient 创建文档")
    public IndexResponse createDoc(String index) {
        List<String> list = new ArrayList<>();
        list.add("teacher");
        list.add("student");
        list.add("admin");
        list.add("leader");
        //1.准备对象
        SysUser build = SysUser.builder()
                .password("zjynb")
                .username("lengedyun")
                .level(5)
                .roles(list)
                .build();
        //2 创建索引
        IndexRequest indexRequest = new IndexRequest(index);
        indexRequest.id("1");
        indexRequest.timeout(TimeValue.timeValueSeconds(5));
        indexRequest.source(JSON.toJSONString(build),XContentType.JSON);
        //执行请求
        IndexResponse indexResponse = null;
        try {
            indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return indexResponse;
    }

    @GetMapping(value = "updateDocFull")
    @ApiOperation("RestHighLevelClient 更新文档-全局更新")
    public IndexResponse updateDocFull(String index) {
        //1.准备对象
        SysUser build = SysUser.builder()
                .username("lengedyun——update")
                .level(8)
                .build();
        //2 创建索引
        IndexRequest indexRequest = new IndexRequest(index);
        indexRequest.id("2");
        indexRequest.source(JSON.toJSONString(build),XContentType.JSON);
        //执行请求
        IndexResponse indexResponse = null;
        try {
            indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return indexResponse;
    }

    @GetMapping(value = "updateDocPart")
    @ApiOperation("RestHighLevelClient 更新文档-局部更新")
    public UpdateResponse updateDocPart(String index) {
        //1.准备对象
        SysUser build = SysUser.builder()
                .username("lengedyun——update")
                .level(8)
                .build();
        //2 创建索引
        UpdateRequest updateRequest = new UpdateRequest(index,"1");
        updateRequest.doc(JSON.toJSONString(build),XContentType.JSON);
        //执行请求
        UpdateResponse updateResponse = null;
        try {
            updateResponse = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return updateResponse;
    }




}
