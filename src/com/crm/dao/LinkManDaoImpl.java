package com.crm.dao;

import com.crm.entity.LinkMan;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {
    //添加联系人的方法
    @Override
    public void add(LinkMan linkMan) {
        this.getHibernateTemplate().save(linkMan);
    }
}
