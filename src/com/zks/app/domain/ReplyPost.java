package com.zks.app.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy="hostReply", fetch=FetchType.EAGER)
	protected Set<SecondaryReplyPost> secondaryReplies = new HashSet<SecondaryReplyPost>();
	
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

	public Set<SecondaryReplyPost> getSecondaryReplies() {
		return secondaryReplies;
	}

	public void setSecondaryReplies(Set<SecondaryReplyPost> secondaryReplies) {
		this.secondaryReplies = secondaryReplies;
	}
	
	
}
