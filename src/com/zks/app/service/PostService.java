package com.zks.app.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zks.app.domain.MainPost;
import com.zks.app.domain.Post;
import com.zks.app.util.PostPager;
import com.zks.app.util.Pager;
import com.zks.app.web.form.CreateMainPostForm;
import com.zks.app.web.form.CreateReplyPostForm;
import com.zks.app.web.form.CreateSecondaryReplyPostForm;

public interface PostService {
	/**
	 * 创建主题帖
	 * @param form
	 * @return
	 */
	public boolean crateMainPost(CreateMainPostForm form);
	/**
	 * 浏览主题帖
	 * @param mainpost_id
	 * @param request
	 * @return
	 */
	public boolean viewMainPostById(Long mainpost_id, HttpServletRequest request);
	/**
	 * 创建回复贴
	 * @param form
	 * @return
	 */
	public boolean createReply(CreateReplyPostForm form);
	/**
	 * 创建楼中楼回复帖
	 * @param form
	 * @return
	 */
	public boolean createSecondaryReply(CreateSecondaryReplyPostForm form);
	/**
	 * 返回主题帖(分页)
	 * @param page
	 * @param size
	 * @param bar_id
	 * @return
	 */
	public PostPager<MainPost> listMain(Integer page, Integer size, Long bar_id, String orderBy);
}
