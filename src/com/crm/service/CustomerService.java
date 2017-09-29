package com.crm.service;

import com.crm.dao.CustomerDao;
import com.crm.entity.Customer;
import org.springframework.transaction.annotation.Transactional;

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
}
