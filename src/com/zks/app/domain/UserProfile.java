package com.zks.app.domain;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class UserProfile {
	@Embedded
	protected Image icon;
	
	protected String signature;
	
	protected String email;
	
	public UserProfile(){
	}
	
	public UserProfile(Image icon, String signature, String email){
		this.icon = icon;
		this.signature = signature;
		this.email = email;
	}
	
	//setters and getters
	public Image getIcon() {
		return icon;
	}

	public void setIcon(Image icon) {
		this.icon = icon;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
