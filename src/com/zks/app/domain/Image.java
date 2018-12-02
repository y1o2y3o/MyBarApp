package com.zks.app.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Image implements Serializable{
	protected String md5;
	
	public Image(String md5){
		this.md5 = md5;
	}
	
	public String getMd5(){
		return md5;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == this) return true;
		if(o == null) return false;
		if(!(o instanceof Image)) return false;
		Image other = (Image)o;
		return getMd5().equals(other.getMd5());
	}
	
	@Override
	public int hashCode(){
		return getMd5().hashCode();
	}
}
