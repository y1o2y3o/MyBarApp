package com.zks.app.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zks.app.domain.MainPost;
import com.zks.app.domain.Post;
import com.zks.app.web.form.CreateMainPostForm;
import com.zks.app.web.form.CreateReplyPostForm;
import com.zks.app.web.form.CreateSecondaryReplyPostForm;

public interface PostService {
	public List<MainPost> listAllMain(Long id);
	public boolean viewBarById(Long id, HttpServletRequest request);
	public boolean crateMainPost(CreateMainPostForm form);
	public boolean viewMainPostById(Long mainpost_id, HttpServletRequest request);
	public boolean createReply(CreateReplyPostForm form);
	public boolean createSecondaryReply(CreateSecondaryReplyPostForm form);
}
