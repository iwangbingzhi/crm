package com.crm.dao;

import com.crm.entity.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by 王炳智 on 2017/9/29.
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    //登陆方法
    public User loginUser(User user) {
        //登陆的查询操作
        //根据用户名和密码查询
        List<User> list = (List<User>) this.getHibernateTemplate().
                find("from User where username=? and password=?",
                user.getUsername(),user.getPassword());
        if(list != null && list.size()!=0) {
            User u = list.get(0);
            return u;
        }
        return null;

    }
}
