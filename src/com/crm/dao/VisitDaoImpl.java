package com.crm.dao;

import com.crm.entity.Visit;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class VisitDaoImpl extends HibernateDaoSupport implements VisitDao {

    //添加客户拜访
    public void add(Visit visit) {
        this.getHibernateTemplate().save(visit);
    }


    //拜访列表
    @Override
    public List<Visit> findAll() {
      return (List<Visit>) this.getHibernateTemplate().find("from Visit ");
    }
}
