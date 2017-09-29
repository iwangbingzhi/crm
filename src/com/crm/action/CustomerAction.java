package com.crm.action;

import com.crm.entity.Customer;
import com.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by 王炳智 on 2017/9/29.
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    private CustomerService customerService;

    //通过模型驱动获得数据
    private Customer customer = new Customer();
    @Override
    public Customer getModel() {
        return customer;
    }

    //到添加客户的页面
    public String toAddPage(){
        return "toAddPage";
    }

    //添加方法
    public String add(){
        customerService.add(customer);
        return "add";
    }

    //客户列表方法
    public String list(){
        return "list";
    }
}
