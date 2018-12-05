package com.zks.app.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Bar {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	@NotNull
	@Column(nullable=false, unique=true)
	protected String name;
	
	@ManyToMany
	@JoinTable(name="BAR_LABELS")
	protected Set<BarLabel> labels = new HashSet<BarLabel>();

	@Embedded
	protected Image icon;
	
	public Bar() {
	}
	public Bar(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public Set<BarLabel> getLabels() {
		return labels;
	}
	public Image getIcon() {
		return icon;
	}
	public void setIcon(Image icon) {
		this.icon = icon;
	}
	public void setName(String name) {
		this.name = name;
		
	}


}
