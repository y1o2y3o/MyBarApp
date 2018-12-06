package com.zks.app.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Formula;

@Entity
public class MainPost extends Post{
	@NotNull
	@Column(nullable=false)
	protected String title;
	
	@NotNull
	@ManyToOne(optional=false)
	@JoinColumn(updatable=false)
	protected Bar hostBar;

	@OneToMany(mappedBy="hostPost", fetch=FetchType.EAGER)
	protected Set<ReplyPost> replies = new HashSet<ReplyPost>();
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastReplyOn = new Date();
	
	@NotNull
	protected Integer replyNum = 0;
	
	public Date getLastReplyOn() {
		return lastReplyOn;
	}

	public void setLastReplyOn(Date lastReplyOn) {
		this.lastReplyOn = lastReplyOn;
	}

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

	public Set<ReplyPost> getReplies() {
		return replies;
	}

	public void setReplies(Set<ReplyPost> replies) {
		this.replies = replies;
	}
	
	
}
