package com.zks.app.dao;

import com.zks.app.domain.User;

public interface AccountDao {
	public User findUserById(Long id);
}
