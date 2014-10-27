package com.devbian.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb")
public class Hospital {

	@Id @GeneratedValue
	private Integer id;
	private String imagePath;
	private String name;
	
	public Hospital(){}

	public Hospital(String imagePath, String name) {
		super();
		this.imagePath = imagePath;
		this.name = name;
	}
	 
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
