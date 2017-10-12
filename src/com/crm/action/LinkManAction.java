package com.crm.action;

import com.crm.entity.Customer;
import com.crm.entity.LinkMan;
import com.crm.service.CustomerService;
import com.crm.service.LinkManService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
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
    public String addLinkMan() throws IOException {
        //判断是否需要上传文件
        if(upload != null) {
            //在服务器文件夹里面创建文件
            File fileservice = new File("g:\\sshimage" + "/" + uploadFileName);
            //把上传文件复制到服务器文件中
            FileUtils.copyFile(upload, fileservice);
        }


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

    /*上传文件
    * 需要上传文件流
    * 需要上传文件名称
    *1.在action成员变量位置定义变量 一个表示上传文件 一个表示文件名称
    * 2.生成变量的get set
    *服务器只认mime类型
    *
    * struts上传文件 默认是2m 可以自己设置上传文件大小 在default.properties struts.multipart.maxSize=2097152
    * */
    //上传文件 变量名称是表单中文件上传项的name
    private File upload;

    //上传文件名称 表单里面文件上传项name值+FileName
    private String uploadFileName;

    public  File   getUpload() {
        return upload;
    }public void   setUpload(File upload) {
        this.upload = upload;
    }public String getUploadFileName() {
        return uploadFileName;
    }public void   setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }


    //联系人列表方法
    public String list(){
        List<LinkMan> list = linkManService.listLinkMan();

        ServletActionContext.getRequest().setAttribute("list",list);
        return "list";
    }

    //到修改联系人页面
    public String updateLinkMan(){
        //使用模型驱动得到id值
        int linkid = linkMan.getLinkid();
        //根据id查询联系人对象
        LinkMan linkMan = linkManService.findOne(linkid);

        //需要所有的customer的list集合
        List<Customer> list = customerService.findAll();

        //上面一步得到联系人信息，再放进jsp页面的域对象中
        ServletActionContext.getRequest().setAttribute("linkman",linkMan);
        ServletActionContext.getRequest().setAttribute("list",list);
        return "updatelinkman";
    }
    public String updateLinkman(){
        linkManService.update(linkMan);
        return "updateLinkman";
    }

}

