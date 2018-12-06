package com.zks.app.dao;

import java.util.List;

import com.zks.app.domain.MainPost;
import com.zks.app.domain.Post;
import com.zks.app.domain.ReplyPost;
import com.zks.app.domain.SecondaryReplyPost;
import com.zks.app.util.PostPager;
import com.zks.app.util.Pager;

public interface PostDao {
	/**
	 * 返回分页的主题帖
	 * @param clazz
	 * @param page
	 * @param size
	 * @param author_idList
	 * @param bar_idList
	 * @param orderBy
	 * @return
	 */
	public PostPager listMainPost(Integer page, Integer size, 
			List<Long> author_idList, List<Long> bar_idList, String orderBy);
	/**
	 * 返回分页的回复帖
	 * @param page
	 * @param size
	 * @param author_idList
	 * @param hostMain_idList
	 * @param sc
	 * @return
	 */
	public PostPager listReplyPost(Integer page, Integer size, 
			List<Long> author_idList, List<Long> hostMain_idList, String sc);
	
	/**
	 * 创建主题帖
	 * @param mainPost
	 */
	public void createMainPost(MainPost mainPost);
	/**
	 * 通过id查找主题帖
	 * @param id
	 * @return
	 */
	public MainPost findMainPostById(Long id);
	/**
	 * 得到一个主题贴的最后回复楼层
	 * @param post_id
	 * @return
	 */
	public Integer getLastReplyOrder(Long post_id);
	/**
	 * 创建回复贴
	 * @param replyPost
	 */
	public void createReplyPost(ReplyPost replyPost);
	/**
	 * 通过id查找回复贴
	 * @param input_hostreply_id
	 * @return
	 */
	public ReplyPost findReplyPostById(Long input_hostreply_id);
	/**
	 * 创建楼中楼回复贴
	 * @param secondaryReplyPost
	 */
	public void createSecondaryReplyPost(SecondaryReplyPost secondaryReplyPost);
	/**
	 * 更新一个post
	 * @param post
	 * @param clazz
	 */
	public void updatePost(Post post);
	
}
