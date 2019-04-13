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
		user.setUsername("�ŷ�");
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
		user.setUsername("����");
		user.setBirth(new Date());
		s.update(user);
		tx.commit();
		s.close();
	}
	//hibernate��֧��5�ֲ�ѯ����  
	//	OID  load/get  load(UserBean.class,id)  ����idִ�в�ѯ
	//  HQL (�������Ĳ�ѯ����(Hibernate Query Language)) hibernate��ѯ����   ��һ����SQL���������Ĳ�ѯ����       from UserBean   Hibernate�Ƽ�ʹ��
	//  QBC  ʹ��Criteria�Ĳ�ѯ   ��һ�ֱ�HQL�����������Ĳ�ѯ����   һ�鹤�����������ɲ�ѯ
	//NativeSQL ���ػ�SQL  ��sql
	//ONG  ���󵼺�   ���ڶ������
	
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
