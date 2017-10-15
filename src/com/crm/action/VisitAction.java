package com.crm.action;

import com.crm.entity.Customer;
import com.crm.entity.User;
import com.crm.entity.Visit;
import com.crm.service.CustomerService;
import com.crm.service.UserService;
import com.crm.service.VisitService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;


import java.util.List;

public class VisitAction extends ActionSupport implements ModelDriven<Visit>{
    private Visit visit = new Visit();

    public Visit getModel() {
        return visit;   //分别放cid uid进客户和用户
    }

    private VisitService visitService;
    public void setVisitService(VisitService visitService) {
        this.visitService = visitService;
    }
    private CustomerService customerService;
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //到新增页面
    public String toAddPage(){
        //1查询所有客户
        List<Customer> listCustomer = customerService.findAll();
        ServletActionContext.getRequest().setAttribute("listcustomer",listCustomer);

        //2查询所有用户
        List<User> listUser = userService.findAll();
        ServletActionContext.getRequest().setAttribute("listuser",listUser);
        return "toAddPage";
    }

    //新增拜访方法
    public String addVisit(){
        visitService.addVisit(visit);
        return "addVisit";
    }
}