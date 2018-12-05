package com.zks.app.dao;

import java.util.List;

import com.zks.app.domain.Bar;
import com.zks.app.domain.MainPost;
import com.zks.app.domain.Post;

public interface BarDao {
	public Bar findBarById(Long id);
}
