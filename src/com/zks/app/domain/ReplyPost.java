package com.zks.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class ReplyPost extends Post{
	@NotNull
	@Column(name="_order", nullable=false)
	protected Integer order;
	
	@ManyToOne(optional=false)
	@JoinColumn(updatable=false)
	protected MainPost hostPost;

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public MainPost getHostPost() {
		return hostPost;
	}

	public void setHostPost(MainPost hostPost) {
		this.hostPost = hostPost;
	}
	
	
}
