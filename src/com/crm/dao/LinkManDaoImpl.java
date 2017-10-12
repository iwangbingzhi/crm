package com.crm.dao;

import com.crm.entity.LinkMan;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {
    //添加联系人的方法
    @Override
    public void add(LinkMan linkMan) {
        this.getHibernateTemplate().save(linkMan);
    }


    //联系人列表方法
    @Override
    public List<LinkMan> list() {
        return (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan ");

    }


    //根据id查询联系人
    @Override
    public LinkMan findOne(int linkid) {
        return this.getHibernateTemplate().get(LinkMan.class,linkid);
    }



    //修改联系人方法
    @Override
    public void update(LinkMan linkMan) {
        this.getHibernateTemplate().update(linkMan);
    }
}
