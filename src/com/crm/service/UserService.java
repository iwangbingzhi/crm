package com.crm.service;

import com.crm.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 王炳智 on 2017/9/29.
 */
@Transactional
public class UserService {
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private UserDao userDao;
}
