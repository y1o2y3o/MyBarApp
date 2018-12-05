package com.zks.app.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Post {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createOn = new Date();
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="AUTHOR_USER_ID")
	protected User author;
	
	protected String description;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="POST_PICTURES")
	protected Set<Image> pictures = new HashSet<Image>();
	
	@NotNull
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	protected VisibilityType visibility = VisibilityType.PUBLIC;

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public VisibilityType getVisibility() {
		return visibility;
	}

	public void setVisibility(VisibilityType visibility) {
		this.visibility = visibility;
	}

	public Long getId() {
		return id;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public Set<Image> getPictures() {
		return pictures;
	}
	
	
}
