package com.zks.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class MainPost extends Post{
	@NotNull
	@Column(nullable=false)
	protected String title;
	
	@NotNull
	@ManyToOne(optional=false)
	@JoinColumn(updatable=false)
	protected Bar hostBar;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Bar getHostBar() {
		return hostBar;
	}

	public void setHostBar(Bar hostBar) {
		this.hostBar = hostBar;
	}
	
	
}
