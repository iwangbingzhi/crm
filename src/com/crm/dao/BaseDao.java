package com.crm.dao;

/*
* 定义类型是T，代表任意类型
*1.任意类型使用大写字母表示，但是不一定是T
*
* */

import java.util.List;

public interface BaseDao<T> {

    //添加
    void add(T t);

    //修改
    void update(T t);

    //删除
    void delete(T t);

    //根据id查询
    T findOne(int id);  //根据id查询返回的是对象 所以加个T在前方

    //查询所有
    List<T> findAll();
}
