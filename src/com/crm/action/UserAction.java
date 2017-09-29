package com.crm.action;

import com.crm.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by 王炳智 on 2017/9/28.
 */
public class UserAction extends ActionSupport{

    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String login(){
            return "login";
        }
}
