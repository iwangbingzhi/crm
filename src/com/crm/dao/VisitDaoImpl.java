package com.crm.dao;

import com.crm.entity.Visit;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class VisitDaoImpl extends HibernateDaoSupport implements VisitDao {

    //添加客户拜访
    public void add(Visit visit) {
        this.getHibernateTemplate().save(visit);
    }
}
