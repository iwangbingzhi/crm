package com.crm.action;

import com.crm.entity.Customer;
import com.crm.entity.PageBean;
import com.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.util.List;

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

    //显示出客户列表方法

    //放数据进入值栈
    //定义list变量
    private List<Customer>list;
    //生成变量的get方法
    public List<Customer> getList() {
        return list;
    }
    public String list(){
        /*放数据有2种方式*/
        //第一种.返回的list放到域对象
        //List<Customer> list = customerService.findAll();
        //ServletActionContext.getRequest().setAttribute("list",list);

        //第二种.返回的list放在值栈中
        list = customerService.findAll();
        return "list";
    }
    //删除客户方法
    public String delete(){
        //使用模型驱动获取表单提交的cid的值
        int cid = customer.getCid();
        Customer c = customerService.findOne(cid);
        //删除规范写法 首先查询id,在调用方法删除

        //判断id查询对象是否是空  应该在此处有一个判断的语句 否则火狐浏览器会两次提交删除 报500错误
        if(c!=null) {
            customerService.delete(c);
        }
        return "delete";
    }

    //修改 根据Id查询
    public String showCustomer(){
        /*使用模型驱动得到cid的值*/
        int cid = customer.getCid();
        Customer c = customerService.findOne(cid);
        //放进域对象中
        ServletActionContext.getRequest().setAttribute("customer",c);
        return "showCustomer";
    }
    public String update(){
        customerService.update(customer);
        return "update";
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    //分页方法
    //属性封装获取当前页
    private Integer currentPage = 1;
    public String listpage(){
        //调用service方法封装
        PageBean pageBean = customerService.listpage(currentPage);
        //数据放到域对象中
        ServletActionContext.getRequest().setAttribute("pageBean",pageBean);
        return "listpage";
    }
}
