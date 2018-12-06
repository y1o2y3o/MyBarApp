package com.zks.app.util;

import com.zks.app.domain.Bar;
import com.zks.app.domain.MainPost;
import com.zks.app.domain.User;

public class PostPager<T> extends Pager<T> {
	
	// MainPost:
	protected String orderby;
	protected Bar bar;
	
	// ReplyPost:
	protected String sc;
	protected User postStarter;
	protected MainPost hostPost;
	
	public String getSc() {
		return sc;
	}
	
	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}
	
	
}
