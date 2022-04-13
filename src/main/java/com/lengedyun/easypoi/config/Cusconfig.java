package com.lengedyun.easypoi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @title: Cusconfig
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/4/13 9:53
 */
@Component
//@Configuration
@ConfigurationProperties(prefix = "cususer")
public class Cusconfig {

    @Value("cusValue")
    private String cusValue;

    //简单数据类型
    private String name;
    private Integer age;
    private String addr;

    //简单list set
    private List<String> cuslist;
    //简单数组
    private String[] cusArray;

    //简单map json配置格式
    private Map<String,Object> cusmap;

    //简单map key-value 格式
    private Map<String,Object> cusmap2;

    //list map嵌套
    private List<Map<String,Object>> cuslist2;

    //对象类型 **不能使用内部类对象
    private Son son;

    @PostConstruct
    private void test(){
        System.out.println("name="+name);
        System.out.println("age="+age);
        System.out.println("addr="+addr);
        System.out.println("cuslist="+Arrays.toString(cuslist.toArray()));
        System.out.println("cusArray="+Arrays.toString(cusArray));
        System.out.println("cusmap="+cusmap);
        System.out.println("son.age="+son.getAge());
        System.out.println("son.name="+son.getName());
        System.out.println("cuslist2="+Arrays.toString(cuslist2.toArray()));
        System.out.println("cusmap2="+cusmap2);
        System.out.println("cusValue="+cusValue);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public List<String> getCuslist() {
        return cuslist;
    }

    public void setCuslist(List<String> cuslist) {
        this.cuslist = cuslist;
    }

    public Map<String, Object> getCusmap() {
        return cusmap;
    }

    public void setCusmap(Map<String, Object> cusmap) {
        this.cusmap = cusmap;
    }

    public Son getSon() {
        return son;
    }

    public void setSon(Son son) {
        this.son = son;
    }

    public Map<String, Object> getCusmap2() {
        return cusmap2;
    }

    public void setCusmap2(Map<String, Object> cusmap2) {
        this.cusmap2 = cusmap2;
    }

    public List<Map<String, Object>> getCuslist2() {
        return cuslist2;
    }

    public void setCuslist2(List<Map<String, Object>> cuslist2) {
        this.cuslist2 = cuslist2;
    }

    public String[] getCusArray() {
        return cusArray;
    }

    public void setCusArray(String[] cusArray) {
        this.cusArray = cusArray;
    }

    public String getCusValue() {
        return cusValue;
    }

    public void setCusValue(String cusValue) {
        this.cusValue = cusValue;
    }
}
