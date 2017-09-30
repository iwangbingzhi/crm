package com.crm.dao;

import com.crm.entity.Customer;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by 王炳智 on 2017/9/29.
 */
public class CustomerDaoImpl  extends HibernateDaoSupport implements CustomerDao {

    //添加客户功能
    public void add(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }

    //客户列表功能
    public List<Customer> findAll() {
        return (List<Customer>) this.getHibernateTemplate().find("from Customer ");

    }
}
