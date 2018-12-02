package com.zks.app.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class PrivateLetterPost extends Post{
	@NotNull
	@ManyToOne(optional=false)
	@JoinColumn(nullable=false)
	protected User letterTarget;

	public User getLetterTarget() {
		return letterTarget;
	}

	public void setLetterTarget(User letterTarget) {
		this.letterTarget = letterTarget;
	}
	
	
}
