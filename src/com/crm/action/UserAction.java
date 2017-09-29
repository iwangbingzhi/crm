package com.crm.action;

import com.crm.entity.User;
import com.crm.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 王炳智 on 2017/9/28.
 */
public class UserAction extends ActionSupport{

    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //属性封装获得用户输入的数据
    private String username;
    private String password;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String login() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User userExit = userService.login(user);


        if (userExit != null) {//成功
            //使用session保持登陆状态
            HttpServletRequest request = ServletActionContext.getRequest();
            request.getSession().setAttribute("user",userExit);
            return "loginSuccess";
        } else {
            return "login";
        }
    }
}
