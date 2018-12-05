package com.zks.app.domain;

import java.lang.Thread.State;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.zks.app.enums.GenderType;
import com.zks.app.enums.StateType;

@Entity
public class User {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	@NotNull
	@Column(nullable=false, unique=true)
	protected String account;
	
	@NotNull
	@Column(nullable=false)
	protected String password;
	
	@NotNull
	@Column(nullable=false, unique=true)
	protected String username;
	
	@NotNull
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	protected GenderType gender = GenderType.MALE;
	
	@NotNull
	@Column(nullable=false)
	protected String phonenum;
	
	@NotNull
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	protected StateType state = StateType.ACTIVE;
	
	@Embedded
	protected Identity identity = new Identity();
	
	@Embedded
	protected UserProfile userProfile = new UserProfile();
	
	public User(){
	}
	
	//setters and getters
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public StateType getState() {
		return state;
	}

	public void setState(StateType state) {
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public String getAccount() {
		return account;
	}

	public Identity getIdentity() {
		return identity;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
}

