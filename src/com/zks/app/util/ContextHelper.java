package com.zks.app.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zks.app.domain.User;
import com.zks.app.enums.GenderType;
import com.zks.app.service.AccountService;
import com.zks.app.service.BarService;
import com.zks.app.service.PostService;

public class ContextHelper {
	private static final AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	private static final SessionFactory sf = (SessionFactory)ctx.getBean("sessionFactory");
	private static final AccountService accountService = (AccountService)ctx.getBean("accountService");
	private static final BarService barService = (BarService)ctx.getBean("barService");
	private static final PostService postService = (PostService)ctx.getBean("postService");
	
	private ContextHelper(){
	}
	public static AbstractApplicationContext getApplicationContext(){
		return ctx;
	}
	public static SessionFactory getSessionFactory(){
		return sf;
	}
	
	public static AccountService getAccountService(){
		return accountService;
	}
	
	public static BarService getBarService() {
		return barService;
	}
	public static PostService getPostService() {
		
		return postService;
	}
}
