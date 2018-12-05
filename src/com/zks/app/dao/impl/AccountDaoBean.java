package com.zks.app.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zks.app.dao.AccountDao;
import com.zks.app.domain.Bar;
import com.zks.app.domain.User;

@Repository("accountDao")
@Transactional
public class AccountDaoBean implements AccountDao{
	@Autowired
	SessionFactory sessionFactory;
	
	// 通过id查找一个user
	public User findUserById(Long id){
		Session session = sessionFactory.getCurrentSession();
		return (User)session.get(User.class, id);
	}
}
