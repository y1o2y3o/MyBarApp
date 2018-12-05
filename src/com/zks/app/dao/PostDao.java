package com.zks.app.dao;

import java.util.List;

import com.zks.app.domain.MainPost;
import com.zks.app.domain.Post;
import com.zks.app.domain.ReplyPost;
import com.zks.app.domain.SecondaryReplyPost;

public interface PostDao {
	public List<MainPost> listAllMain(Long id);
	public void createMainPost(MainPost mainPost);
	public MainPost findMainPostById(Long id);
	public Integer getLastReplyOrder(Long post_id);
	public void createReplyPost(ReplyPost replyPost);
	public ReplyPost findReplyPostById(Long input_hostreply_id);
	public void createSecondaryReplyPost(SecondaryReplyPost secondaryReplyPost);
}
