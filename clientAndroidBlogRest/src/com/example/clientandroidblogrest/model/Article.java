package com.example.clientandroidblogrest.model;

import java.sql.Date;

import com.example.clientandroidblogrest.resttool.NameResourceREST;
import com.example.clientandroidblogrest.resttool.ObjectRest;

@NameResourceREST(value="article")
public class Article  extends ObjectRest {

		
		private String title ;  
	    private Date published_on ;
	    private String content ;
	    private String photo ;
	    private User user ;
	    private Boolean valide ;


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPublished_on() {
		return published_on;
	}
	public void setPublished_on(Date published_on) {
		this.published_on = published_on;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Boolean getValide() {
		return valide;
	}
	public void setValide(Boolean valide) {
		this.valide = valide;
	}

  
}
