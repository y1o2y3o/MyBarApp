package com.zks.app.service.impl;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zks.app.domain.Image;
import com.zks.app.domain.User;
import com.zks.app.enums.GenderType;
import com.zks.app.service.AccountService;
import com.zks.app.util.ContextHelper;
import com.zks.app.domain.BarLabel;
@Service("accountService")
@Transactional
public class AccountServiceBean implements AccountService{
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 注册一个用户
	 */
	public boolean register(User user){
		Session session = sessionFactory.getCurrentSession();
		// 查询重复账户
		Query query = session.createQuery("from User u where u.account=:account or u.username=:username");
		query.setParameter("account", user.getAccount());
		query.setParameter("username", user.getUsername());
		if(query.list().isEmpty()){
			session.save(user);
			return true; // 注册成功
		}
		return false; // 存在重复注册
	}
	
	/**
	 * 登陆一个用户
	 */
	public User login(String account, String password){
		Session session = sessionFactory.getCurrentSession();
		// 查询并返回登陆的用户
		Query query = session.createQuery("from User u where u.account=:account and u.password=:password");
		query.setParameter("account", account);
		query.setParameter("password", password);
		User user = (User)query.uniqueResult();
		return user;
	}
	
	
	public void test(){
		Session session = sessionFactory.getCurrentSession();
		BarLabel label = new BarLabel();
		label.setName("123f23");
		session.save(label);
	}
	
	public static void main(String[] args){
		AccountService as = ContextHelper.getAccountService();
		User u = new User();
		u.setAccount("sdf");
		u.setGender(GenderType.FEMALE);
		u.setPassword("adfsdf");
		u.setPhonenum("adff");
		u.setUsername("asdffs");
		as.register(u);
		
	}
}
