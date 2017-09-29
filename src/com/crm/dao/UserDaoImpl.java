package com.crm.dao;

import com.crm.entity.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * Created by 王炳智 on 2017/9/29.
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    //登陆方法
    public User loginUser(User user) {
        //调用hibernateTemplate对象
        HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
        //登陆的查询操作
        return null;
    }
}
