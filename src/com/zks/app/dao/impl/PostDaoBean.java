package com.zks.app.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zks.app.dao.PostDao;
import com.zks.app.domain.MainPost;
import com.zks.app.domain.ReplyPost;
import com.zks.app.domain.SecondaryReplyPost;

@Repository("postDao")
@Transactional
public class PostDaoBean implements PostDao{
	@Autowired
	SessionFactory sessionFactory;
	
	// list指定吧的所有贴
	public List<MainPost> listAllMain(Long id){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from MainPost mp where mp.hostBar.id=:id")
				.setParameter("id", id).list();
	}
	
	// 创建一个主题帖
	public void createMainPost(MainPost mainPost){
		Session session = sessionFactory.getCurrentSession();
		session.save(mainPost);
	}
	
	// 查找主题帖
	public MainPost findMainPostById(Long id){
		Session session = sessionFactory.getCurrentSession();
		return (MainPost)session.get(MainPost.class, id);
	}
	
	// 返回当前主题帖的楼高
	public Integer getLastReplyOrder(Long post_id){
		Session session = sessionFactory.getCurrentSession();
		Integer n = (Integer)session.createQuery("select max(r.order) from ReplyPost r where r.hostPost.id=:id")
			.setParameter("id", post_id).uniqueResult();
		if(n==null)
			n = 1;
		return n;
	}
	
	// 创建回复贴
	public void createReplyPost(ReplyPost replyPost){
		Session session = sessionFactory.getCurrentSession();
		session.save(replyPost);
	}

	@Override
	public ReplyPost findReplyPostById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (ReplyPost)session.get(ReplyPost.class, id);
	}

	@Override
	public void createSecondaryReplyPost(SecondaryReplyPost secondaryReplyPost) {
		Session session = sessionFactory.getCurrentSession();
		session.save(secondaryReplyPost);
	}
}
