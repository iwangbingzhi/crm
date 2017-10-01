package com.crm.dao;

import com.crm.entity.Customer;

import java.util.List;

/**
 * Created by 王炳智 on 2017/9/29.
 */
public interface CustomerDao {
    void add(Customer customer);

    List<Customer> findAll();

    Customer findOne(int cid);

    void delete(Customer c);

    void update(Customer customer);

    void listpage(Integer currentPage);

    int findCount();

    List<Customer> findPage(int begin, int pageSize);

    List<Customer> findCondition(Customer customer);
}
