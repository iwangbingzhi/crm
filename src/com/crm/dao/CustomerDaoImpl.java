package com.crm.dao;

import com.crm.entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by 王炳智 on 2017/9/29.
 */
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {
    //添加客户功能
  /*  public void add(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }
*/
    //显示出客户列表功能
   /* public List<Customer> findAll() {
        return (List<Customer>) this.getHibernateTemplate().find("from Customer ");
    }*/

    //删除客户
  /*  public Customer findOne(int cid) {
        return this.getHibernateTemplate().get(Customer.class,cid);
    }*/

   /* public void delete(Customer c) {
        this.getHibernateTemplate().delete(c);
    }
*/
    //修改客户数据
   /* public void update(Customer customer) {
        this.getHibernateTemplate().update(customer);
    }*/

    //分页页面
    public void listpage(Integer currentPage) {

    }

    //查询总记录数
    public int findCount() {
        List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Customer");
        //从list中把值得到
        if(list!=null && list.size()!=0){
            Object obj = list.get(0);
            //变成int类型
            Long lobj = (Long) obj;
            int count = lobj.intValue();
            return count;
        }
        return 0;
    }

    //分页查询操作
    public List<Customer> findPage(int begin, int pageSize) {
/*        //第一种 使用hibernate底层代码实现（了解）
        SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        //设置分页信息
        Query query = session.createQuery("from Customer ");
            query.setFirstResult(begin);
            query.setMaxResults(pageSize);
            List<Customer> list = query.list();*/
        //第二种 使用离线对象和hibernateTemplete实现
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);

        //调用hibernateTemplete实现
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
        return list;
    }

    //条件查询 三种方式做到
    public List<Customer> findCondition(Customer customer) {
       /*   //第一种 使用hibernate底层代码实现（了解）
        SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer  where custName like ?");
        query.setParameter(0,"%"+customer.getCustName()+"%");
        List<Customer> list = query.list();*/

        //第二种 调用hibernateTemplete模板中的find方法实现（掌握）
/*
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().find
                ("from Customer  where custName like ?", "%" + customer.getCustName() + "%");
*/

        //第三种 (常用)
        //1.创建离线对象
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        //2.设置对实体类哪个属性
        detachedCriteria.add(Restrictions.like("custName","%"+customer.getCustName()+"%"));
        //3.调用hibernate模板的方法 放list集合
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        return list;
    }
}
