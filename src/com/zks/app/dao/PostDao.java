package com.zks.app.dao;

import java.util.List;

import com.zks.app.domain.MainPost;
import com.zks.app.domain.Post;

public interface PostDao {
	public List<MainPost> listAllMain(Long id);
}
