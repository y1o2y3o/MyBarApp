package com.zks.app.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class SecondaryReplyPost extends Post{
	@NotNull
	@ManyToOne(optional=false)
	@JoinColumn(updatable=false)
	protected ReplyPost hostReply;
	
	@NotNull
	@ManyToOne(optional=false)
	@JoinColumn(updatable=false)
	protected User replyTarget;

	public ReplyPost getHostReply() {
		return hostReply;
	}

	public void setHostReply(ReplyPost hostReply) {
		this.hostReply = hostReply;
	}

	public User getReplyTarget() {
		return replyTarget;
	}

	public void setReplyTarget(User replyTarget) {
		this.replyTarget = replyTarget;
	}
	
	
}
