package com.crm.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 * Created by 王炳智 on 2017/9/29.
 */
public class UserDaoImpl implements UserDao {
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    private HibernateTemplate hibernateTemplate;
}
