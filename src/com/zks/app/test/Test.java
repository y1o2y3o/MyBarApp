package com.zks.app.test;

import static org.junit.Assert.*;

import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zks.app.domain.User;
import com.zks.app.enums.GenderType;
import com.zks.app.service.AccountService;
import com.zks.app.util.ContextHelper;

public class Test {
	
	
	@org.junit.Test
	public void test() {
		AccountService as = ContextHelper.getAccountService();
		User u = new User();
		u.setAccount("sdf");
		u.setGender(GenderType.FEMALE);
		u.setPassword("adfsdf");
		u.setPhonenum("adff");
		u.setUsername("asdffs");
		as.register(u);
	}
}


