package com.zks.app.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class BarLabel implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	@NotNull
	@Column(nullable=false, unique=true)
	protected String name;
	
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public boolean equals(Object o){
		if(o == this) return true;
		if(o==null)return false;
		if(!(o instanceof BarLabel)) return false;
		BarLabel other = (BarLabel)o;
		return getName().equals(other.getName());
	}
	
	@Override
	public int hashCode(){
		return name.hashCode();
	}
}
