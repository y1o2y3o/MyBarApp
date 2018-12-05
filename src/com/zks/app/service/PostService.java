package com.zks.app.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zks.app.domain.MainPost;
import com.zks.app.domain.Post;

public interface PostService {
	public List<MainPost> listAllMain(Long id);
	public void viewBarById(Long id, HttpServletRequest request);
}
