package com.zks.app.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Identity implements Serializable{
	protected String realname;
	protected String idcard;
	
	public Identity(){
	}
	
	public Identity(String realname, String idcard){
		this.realname = realname;
		this.idcard = idcard;
	}
	
	//getters
	public String getRealname() {
		return realname;
	}

	public String getIdcard() {
		return idcard;
	}
	
	public void setRealname(String realname) {
		this.realname = realname;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	@Override
	public boolean equals(Object o){
		if(o == this) return true;
		if(o == null) return false;
		if(!(o instanceof Identity)) return false;
		Identity other = (Identity)o;
		return getRealname().equals(other.getRealname())
				&& getIdcard().equals(other.getIdcard());
	}
	
	@Override
	public int hashCode(){
		return getIdcard().hashCode();
	}
}
