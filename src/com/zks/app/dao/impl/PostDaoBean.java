package com.zks.app.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zks.app.dao.PostDao;
import com.zks.app.domain.MainPost;
import com.zks.app.domain.Post;
import com.zks.app.domain.ReplyPost;
import com.zks.app.domain.SecondaryReplyPost;
import com.zks.app.util.Pager;
import com.zks.app.util.PostPager;

@Repository("postDao")
@Transactional
public class PostDaoBean implements PostDao{
	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * list主题帖子: 分页: 第几页, 单次最大条数, 作者限定范围, 贴吧限定范围, 排序依据
	 */
	public PostPager listMainPost(Integer page, Integer size, 
			List<Long> author_idList, List<Long> bar_idList, String orderBy){
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(MainPost.class);
		Criteria crit2 = session.createCriteria(MainPost.class);
		PostPager pager = new PostPager();
		
		// 作者限定范围, 贴吧限定范围
		if(author_idList != null && !author_idList.isEmpty()){
			crit.add(Restrictions.in("author.id", author_idList));
			crit2.add(Restrictions.in("author.id", author_idList));
		}
			
		if(bar_idList != null && !bar_idList.isEmpty()){
			crit.add(Restrictions.in("hostBar.id", bar_idList));
			crit2.add(Restrictions.in("hostBar.id", bar_idList));
		}
			
		// distinct
		crit.setResultTransformer(crit.DISTINCT_ROOT_ENTITY); // 使得查询结果唯一
		crit2.setResultTransformer(crit.DISTINCT_ROOT_ENTITY); // 使得查询结果唯一
		
		// 限制条件
		crit.setFirstResult(page*size)
			.setMaxResults(size)
			.addOrder(Order.desc(orderBy));
		crit2.setProjection(Projections.rowCount()); 
		
		// 设置pager
		pager.setOrderby(orderBy);
		pager.setPageSize(size);
		pager.setContent(crit.list());
		pager.setRecordTotal(((Long)crit2.uniqueResult()).intValue());
		pager.setCurrentPage(page);
		
		return pager;
	}
	
	/**
	 * list回复贴: 分页: 第几页, 单次最大条数, 作者限定范围, 贴吧限定范围, 排序正负
	 */
	public PostPager listReplyPost(Integer page, Integer size, 
			List<Long> author_idList, List<Long> hostMain_idList, String sc){
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(ReplyPost.class);
		Criteria crit2 = session.createCriteria(ReplyPost.class);
		PostPager pager = new PostPager();
		
		// 作者限定范围, 宿主主题帖范围
		if(author_idList != null && !author_idList.isEmpty()){
			crit.add(Restrictions.in("author.id", author_idList));
			crit2.add(Restrictions.in("author.id", author_idList));
		}
		if(hostMain_idList != null && !hostMain_idList.isEmpty()){
			crit.add(Restrictions.in("hostPost.id", hostMain_idList));
			crit2.add(Restrictions.in("hostPost.id", hostMain_idList));
		}
			
		// distinct
		crit.setResultTransformer(crit.DISTINCT_ROOT_ENTITY); // 使得查询结果唯一
		crit2.setResultTransformer(crit.DISTINCT_ROOT_ENTITY); // 使得查询结果唯一
		
		// 限制条件
		crit.setFirstResult(page*size)
			.setMaxResults(size);
		// 设置时间排序
		if(sc=="desc")
			crit.addOrder(Order.desc("createOn"));
		else
			crit.addOrder(Order.asc("createOn"));
		crit2.setProjection(Projections.rowCount()); 
		
		// 设置pager
		pager.setSc(sc);
		pager.setPageSize(size);
		pager.setContent(crit.list());
		pager.setRecordTotal(((Long)crit2.uniqueResult()).intValue());
		pager.setCurrentPage(page);
		
		return pager;
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
	
	// 查找回复贴
	@Override
	public ReplyPost findReplyPostById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (ReplyPost)session.get(ReplyPost.class, id);
	}

	// 创建一个楼中楼回复贴
	@Override
	public void createSecondaryReplyPost(SecondaryReplyPost secondaryReplyPost) {
		Session session = sessionFactory.getCurrentSession();
		session.save(secondaryReplyPost);
	}	
	
	// 更新一个post
	public void updatePost(Post post){
		Session session = sessionFactory.getCurrentSession();
		session.update(post);
	}
}
