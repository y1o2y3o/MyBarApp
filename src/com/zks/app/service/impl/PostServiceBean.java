package com.zks.app.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import com.zks.app.util.PostPager;
import com.zks.app.util.Pager;
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
		
		//更新宿主主题贴
		hostPost.setLastReplyOn(new Date());
		postDao.updatePost(hostPost);
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
		
		//更新宿主主题贴
		MainPost hostPost = postDao.findMainPostById(form.getInput_mainpost_id());
		hostPost.setLastReplyOn(new Date());
		postDao.updatePost(hostPost);
		
		secondaryReplyPost.setAuthor(author);
		secondaryReplyPost.setHostReply(hostReply);
		secondaryReplyPost.setReplyTarget(target);
		
		postDao.createSecondaryReplyPost(secondaryReplyPost);
		return true;
	}
	
	
	// 列出主题贴: 分页
	public PostPager<MainPost> listMain(Integer page, Integer size, Long bar_id, String orderBy){
		List<Long> bar_idList = new ArrayList<Long>();
		bar_idList.add(bar_id);
		
		String[] arr = {"createOn", "lastReplyOn", "replyNum",};
		if(!Arrays.asList(arr).contains(orderBy))
			orderBy = "lastReplyOn";
		
		// set pager
		PostPager<MainPost> pager = postDao.listMainPost(page, size, null, bar_idList, orderBy);
		pager.setBar(barDao.findBarById(bar_id)); // set bar
		
		return pager;
	}
	
	
	// 列出回复贴: 分页
	public PostPager<ReplyPost> listReply(Integer page, Integer size,
			Long replyAuthorId, Long hostMainId, String sc){
		// 是否只看楼主?
		List<Long> replyAuthorIdList = null;
		if(replyAuthorId != null)	{
			replyAuthorIdList = new ArrayList<Long>();
			replyAuthorIdList.add(replyAuthorId);
		}
		
		// 宿主主题帖id
		List<Long> hostMainIdList = new ArrayList<Long>();
		hostMainIdList.add(hostMainId);	
		
		// 升序还是降序?: 默认降序
		String[] arr = {"desc", "asc",};
		if(!Arrays.asList(arr).contains(sc))
			sc = "desc";
		
		// set pager
		PostPager<ReplyPost> pager = postDao.listReplyPost(page, size, replyAuthorIdList, hostMainIdList, sc);
		pager.setSc(sc);
		pager.setHostPost(postDao.findMainPostById(hostMainId));
		pager.setReplyAuthorId(replyAuthorId);
		
		return pager;
	}
	
	
}
