package com.zks.app.service;

import org.springframework.transaction.annotation.Transactional;

import com.zks.app.domain.User;

public interface AccountService {
	public void test();
	public boolean register(User user);
	public User login(String account, String password);
}
