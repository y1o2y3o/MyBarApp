package com.zks.app.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zks.app.dao.BarDao;
import com.zks.app.dao.PostDao;
import com.zks.app.domain.Bar;
import com.zks.app.domain.MainPost;
import com.zks.app.domain.Post;
import com.zks.app.service.PostService;

@Service("postService")
@Transactional
public class PostServiceBean implements PostService{
	@Autowired
	PostDao postDao;
	@Autowired
	BarDao barDao;
	
	// 列出指定吧的所有主题帖子
	public List<MainPost> listAllMain(Long id){
		return postDao.listAllMain(id);
	}
	
	// 浏览指定贴吧以及主题帖
	public void viewBarById(Long id, HttpServletRequest request){
		List<MainPost> postList = postDao.listAllMain(id);
		Bar bar = barDao.findBarById(id);
		request.setAttribute("postList", postList);
		request.setAttribute("bar", bar);
	}
}
