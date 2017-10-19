package com.crm.dao;

import com.crm.entity.LinkMan;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {
    //添加联系人的方法
    @Override
    public void add(LinkMan linkMan) {
        this.getHibernateTemplate().save(linkMan);
    }


    //联系人列表方法
    @SuppressWarnings("all")
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


    /*//多条件查询----hql语句拼接
    @SuppressWarnings("all")
    @Override
    public List<LinkMan> findCondition(LinkMan linkMan) {
        String hql = "from LinkMan where 1 = 1";
        List<Object> p = new ArrayList<Object>();
        //判断条件值是否为空
        if(linkMan.getLkmName()!=null && !"".equals(linkMan.getLkmName())){
            hql += " and lkmName=?";
            p.add(linkMan.getLkmName());
        }
        //判断是否选择客户 通过option中value=0来判断是否选择
        if(linkMan.getCustomer().getCid()!=null && linkMan.getCustomer().getCid()>0){
            //判断客户里面cid值
            hql += " and customer.cid=?";
            p.add(linkMan.getCustomer().getCid());
        }
        return (List<LinkMan>) this.getHibernateTemplate().find(hql,p.toArray());
    }*/

      //多条件查询----离线对象方式
    @SuppressWarnings("all")
    @Override
    public List<LinkMan> findCondition(LinkMan linkMan) {
        //创建离线对象
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
        if (linkMan.getLkmName() != null && !"".equals(linkMan.getLkmName())){
            detachedCriteria.add(Restrictions.eq("lkmName",linkMan.getLkmName()));
        }
        if(linkMan.getCustomer().getCid()!=null && linkMan.getCustomer().getCid()>0){
            detachedCriteria.add(Restrictions.eq("customer.cid",linkMan.getCustomer().getCid()));
        }
        return (List<LinkMan>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
    }
}
