package com.zks.app.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zks.app.dao.AccountDao;
import com.zks.app.dao.BarDao;
import com.zks.app.dao.PostDao;
import com.zks.app.domain.Bar;
import com.zks.app.domain.MainPost;
import com.zks.app.domain.Post;
import com.zks.app.domain.ReplyPost;
import com.zks.app.domain.SecondaryReplyPost;
import com.zks.app.domain.User;
import com.zks.app.service.PostService;
import com.zks.app.web.form.CreateMainPostForm;
import com.zks.app.web.form.CreateReplyPostForm;
import com.zks.app.web.form.CreateSecondaryReplyPostForm;

@Service("postService")
@Transactional
public class PostServiceBean implements PostService{
	@Autowired
	PostDao postDao;
	@Autowired
	BarDao barDao;
	@Autowired
	AccountDao accountDao;
	
	// 列出指定吧的所有主题帖子
	public List<MainPost> listAllMain(Long id){
		return postDao.listAllMain(id);
	}
	
	// 浏览指定贴吧以及主题帖
	public boolean viewBarById(Long id, HttpServletRequest request){
		List<MainPost> postList = postDao.listAllMain(id);
		Bar bar = barDao.findBarById(id);
		if(bar == null) 
			return false; // 吧id不是合法的: 返回false
		request.setAttribute("postList", postList);
		request.setAttribute("bar", bar);
		return true;
	}
	
	// 创建主题帖
	public boolean crateMainPost(CreateMainPostForm form){
		MainPost mainPost = new MainPost();
		mainPost.setTitle(form.getInput_title());
		mainPost.setDescription(form.getInput_description());
		
		// 获得post的作者
		User author = accountDao.findUserById(form.getInput_user_id());
		if(author == null)
			return false;
		System.out.println("author_id:"+author.getId());
		// 获得post所在贴吧
		Bar bar = barDao.findBarById(form.getInput_bar_id());
		if(bar == null)
			return false;
		System.out.println("bar_id:"+bar.getId());
		mainPost.setAuthor(author);
		mainPost.setHostBar(bar);
		postDao.createMainPost(mainPost);
		
		return true;
	}
	
	// 浏览指定主题帖内容
	public boolean viewMainPostById(Long mainpost_id, HttpServletRequest request){
		MainPost mainPost = postDao.findMainPostById(mainpost_id);
		if(mainPost==null)
			return false; // 找不到主题帖: mainpost_id不对
		request.setAttribute("mainPost", mainPost);
		return true;
	}

	// 创建回复贴
	public boolean createReply(CreateReplyPostForm form) {
		// 创建 replyPost
		ReplyPost replyPost = new ReplyPost();
		replyPost.setDescription(form.getInput_description());
		User author = accountDao.findUserById(form.getInput_user_id());
		if(author == null)
			return false; // 作者id不合法
		
		MainPost hostPost = postDao.findMainPostById(form.getInput_hostpost_id());
		if(hostPost == null)
			return false; // mainPost_id 不合法
		
		replyPost.setAuthor(author);
		replyPost.setHostPost(hostPost);		
		// 设置楼层数
		replyPost.setOrder(1+postDao.getLastReplyOrder(form.getInput_hostpost_id()));
		// 创建replyPost
		postDao.createReplyPost(replyPost);
		
		return true;
	}

	// 创建楼中楼回复贴
	@Override
	public boolean createSecondaryReply(CreateSecondaryReplyPostForm form) {
		SecondaryReplyPost secondaryReplyPost = new SecondaryReplyPost();
		secondaryReplyPost.setDescription(form.getInput_description());
		
		User author = accountDao.findUserById(form.getInput_user_id());
		if(author == null)
			return false;
		User target = accountDao.findUserById(form.getInput_target_user_id());
		if(target == null)
			return false;
		ReplyPost hostReply = postDao.findReplyPostById(form.getInput_hostreply_id());
		if(hostReply == null)
			return false;
		secondaryReplyPost.setAuthor(author);
		secondaryReplyPost.setHostReply(hostReply);
		secondaryReplyPost.setReplyTarget(target);
		
		postDao.createSecondaryReplyPost(secondaryReplyPost);
		return true;
	}
}
