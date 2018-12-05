package com.zks.app.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zks.app.domain.Bar;
import com.zks.app.service.BarService;


@Service("barService")
@Transactional
public class BarServiceBean implements BarService{
	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * 创建贴吧
	 */
	public boolean create(Bar bar){
		Session session = sessionFactory.getCurrentSession();
		// 查询贴吧是否已经存在
		Query query = session.createQuery("from Bar b where b.name=:name")
						.setParameter("name", bar.getName());
		
		if(query.list().isEmpty()){
			session.save(bar);
			return true; // 成功创建贴吧
		} 
		//创建失败
		return false;
	}
	
	/**
	 * list所有贴吧
	 */
	public List<Bar> list(){
		Session session = sessionFactory.getCurrentSession();
	
		Query query = session.createQuery("from Bar");
		
		return query.list(); 
	}
}
