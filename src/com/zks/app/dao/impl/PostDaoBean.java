package com.zks.app.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zks.app.dao.PostDao;
import com.zks.app.domain.MainPost;

@Repository("postDao")
@Transactional
public class PostDaoBean implements PostDao{
	@Autowired
	SessionFactory sessionFactory;
	
	// list指定吧的所有贴
	public List<MainPost> listAllMain(Long id){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from MainPost").list();
	}
}
