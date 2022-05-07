package com.lengedyun.easypoi.dao;

/**
 * @title: SysUserDao
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/5/7 11:07
 */

import com.lengedyun.easypoi.SysUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * 第一种方式，类似于JPA，编写一个ElasticsearchRepository
 *  第一个泛型为Bean的类型
 *  第二个泛型为Bean的主键类型
 */

@Repository
public interface SysUserDao extends ElasticsearchRepository<SysUser,String> {


}
