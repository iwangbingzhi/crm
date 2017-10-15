package com.crm.dao;

import com.crm.entity.User;

import java.util.List;

/**
 * Created by 王炳智 on 2017/9/29.
 */
public interface UserDao {
    User loginUser(User user);

    List<User> findAll();
}
