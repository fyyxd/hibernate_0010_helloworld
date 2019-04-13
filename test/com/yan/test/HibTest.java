package com.yan.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.yan.entity.UserBean;

public class HibTest {

	@Test
	public void testSave() {
		UserBean user = new UserBean();
		user.setUsername("张飞");
		user.setPassword("123456");

		Configuration cfg = new Configuration().configure();
		SessionFactory fac = cfg.buildSessionFactory();
		Session s = fac.openSession();
		Transaction tx = s.beginTransaction();
		s.save(user);
		tx.commit();
		s.close();
	}

	@Test
	public void testRemove() {
		Configuration cfg = new Configuration().configure();
		SessionFactory fac = cfg.buildSessionFactory();
		Session s = fac.openSession();
		Transaction tx = s.beginTransaction();
		UserBean user = (UserBean) s.load(UserBean.class, 2L);
		s.delete(user);
		tx.commit();
		s.close();
	}

	@Test
	public void testModify() {
		Configuration cfg = new Configuration().configure();
		SessionFactory fac = cfg.buildSessionFactory();
		Session s = fac.openSession();
		Transaction tx = s.beginTransaction();
		UserBean user = (UserBean) s.load(UserBean.class, 3L);
		user.setUsername("刘备");
		user.setBirth(new Date());
		s.update(user);
		tx.commit();
		s.close();
	}
	//hibernate中支持5种查询方法  
	//	OID  load/get  load(UserBean.class,id)  按照id执行查询
	//  HQL (面向对象的查询语言(Hibernate Query Language)) hibernate查询语言   是一种类SQL的面向对象的查询语言       from UserBean   Hibernate推荐使用
	//  QBC  使用Criteria的查询   是一种比HQL更加面向对象的查询语言   一组工具类用于生成查询
	//NativeSQL 本地化SQL  是sql
	//ONG  对象导航   用于多个关联
	
	@Test
	public void testLoad(){
		Configuration cfg=new Configuration().configure();
		SessionFactory fac=cfg.buildSessionFactory();
		Session s=fac.openSession();
		UserBean user=(UserBean) s.load(UserBean.class, 3L);
		System.out.println(user);
		s.close();
	}
	@Test
	public void testGet(){
		Configuration cfg=new Configuration().configure();
		SessionFactory fac=cfg.buildSessionFactory();
		Session s=fac.openSession();
		UserBean user=(UserBean) s.get(UserBean.class, 3L);
		System.out.println(user);
		s.close();
	}
	@Test
	public void testHql(){
		Configuration cfg=new Configuration().configure();
		SessionFactory fac=cfg.buildSessionFactory();
		Session s=fac.openSession();
		//select * from t_users
		Query q=s.createQuery("select u from UserBean u");
		List<UserBean> ulist=q.list();
		for(UserBean temp:ulist)
			System.out.println(temp);
		s.close();
	}
}
