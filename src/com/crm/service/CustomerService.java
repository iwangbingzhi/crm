package com.crm.service;

import com.crm.dao.CustomerDao;
import com.crm.entity.Customer;
import com.crm.entity.PageBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 王炳智 on 2017/9/29.
 */
@Transactional
public class CustomerService {
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    private CustomerDao customerDao;


    public void add(Customer customer) {
        customerDao.add(customer);
    }

    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    public Customer findOne(int cid) {
        return customerDao.findOne(cid);
    }

    public void delete(Customer c) {
        customerDao.delete(c);
    }

    public void update(Customer customer) {
        customerDao.update(customer);
    }


    //封装分页数据到pageBean中
    public PageBean listpage(Integer currentPage) {
        PageBean pageBean = new PageBean();
        //当前页
        pageBean.setCurrentPage(currentPage);
        //总记录数
        int totalCount = customerDao.findCount();
        pageBean.setTotalCount(totalCount);

        //每页显示记录数
        int pageSize = 3;

        //总页数 总的记录数除以每页显示记录数
        int totalPage = 0;
        if(totalCount%pageSize==0){//能够整除
            totalPage = totalCount/pageSize;
        }else {
            totalPage = totalCount/pageSize+1;
        }
        pageBean.setTotalPage(totalPage);

        //开始位置
        int begin = (currentPage-1)*pageSize;

        //每页记录list集合
        List<Customer> list = customerDao.findPage(begin,pageSize);
        pageBean.setList(list);
        return pageBean;
    }
}
