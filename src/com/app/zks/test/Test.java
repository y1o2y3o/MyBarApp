package com.app.zks.test;

import static org.junit.Assert.*;

import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

public class Test {

	
	@org.junit.Test
	public void test() {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)ctx.getBean("sessionFactory");
		Session session = sf.openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
