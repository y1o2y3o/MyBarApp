package com.zks.app.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zks.app.dao.BarDao;
import com.zks.app.dao.PostDao;
import com.zks.app.domain.Bar;
import com.zks.app.domain.MainPost;
import com.zks.app.domain.Post;

@Repository("barDao")
@Transactional
public class BarDaoBean implements BarDao{
	@Autowired
	SessionFactory sessionFactory;
	
	// 通过id查找一个Bar
	public Bar findBarById(Long id){
		Session session = sessionFactory.getCurrentSession();
		return (Bar)session.createQuery("from Bar b where b.id=:id").setParameter("id", id)
				.uniqueResult();
	}
}
