package com.crm.action;

import com.crm.entity.Customer;
import com.crm.entity.LinkMan;
import com.crm.service.CustomerService;
import com.crm.service.LinkManService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
    private LinkManService linkManService;
    public void setLinkManService(LinkManService linkManService) {
        this.linkManService = linkManService;
    }

    //注入客户Service对象
    private CustomerService customerService;
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public String toAddPage(){
        //1.1 查询所有客户，把所有客户List集合传到页面中（域对象）
            //调用customerservice中的方法得到客户
        List<Customer> listcustomer = customerService.findAll();
        ServletActionContext.getRequest().setAttribute("listCustomer",listcustomer);
        return "toAddPage";
    }
    //添加数据到数据库
    public String addLinkMan(){
        /*可以封装联系人信息
        但是cid是客户的Id不能够直接封装
        把cid封装到实体类的customer里
        */
        //原始方式实现
      /*  String scid = ServletActionContext.getRequest().getParameter("cid");
        int cid = Integer.parseInt(scid);

        //创建customer对象
        Customer c = new Customer();
        c.setCid(cid);
        linkMan.setCustomer(c);*/

        linkManService.addLinkMan(linkMan);
        return "addLinkMan";
    }

    private LinkMan linkMan = new LinkMan();
    @Override
    public LinkMan getModel() {
        return linkMan;
    }
}

