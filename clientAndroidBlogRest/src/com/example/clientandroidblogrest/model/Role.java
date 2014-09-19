package com.example.clientandroidblogrest.model;

import com.example.clientandroidblogrest.resttool.ObjectRest;

public class Role  extends ObjectRest{

	private String name ;
	private String description ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
