package com.crm.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
    private Class pClass;


    //构造方法
    public BaseDaoImpl() {
        //1.得到当前运行类的class
        Class clazz = this.getClass();
        System.out.println("=========="+clazz);
        //2.得到运行类的父类的参数化类型BaseDaoImpl<Customer>
        //2.1调用Type getGenericSuperclass()
        Type type = clazz.getGenericSuperclass();
        //2.2使用type子接口ParameterizedType,得到参数化类型BaseDaoImpl<Customer>
        ParameterizedType ptype = (ParameterizedType) type;
        System.out.println("++++++++++++"+ptype);

        //3.得到实际的类型参数<Customer>里面的customer实体
        Type[] types = ptype.getActualTypeArguments();
        //type接口的实现类是Class,因为数组中只有一个值，所以只用取[0]
        Class tclass = (Class) types[0];
        //System.out.println("!!!!!!!"+pclass);
        this.pClass = tclass;

    }

    @Override
    public void add(T t) {
        this.getHibernateTemplate().save(t);
    }

    @Override
    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    @Override
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }



    //根据id查询
    @Override
    public T findOne(int id) {
       return (T) this.getHibernateTemplate().get(pClass, id);

    }

    @Override
    public List<T> findAll() {
        //使用class里面的getSimpleName()得到类的名称
        return (List<T>) this.getHibernateTemplate().find("from "+pClass.getSimpleName());
    }
}
