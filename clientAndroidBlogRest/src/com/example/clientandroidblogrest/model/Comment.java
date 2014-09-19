package com.example.clientandroidblogrest.model;

import java.sql.Date;

import com.example.clientandroidblogrest.resttool.NameResourceREST;
import com.example.clientandroidblogrest.resttool.ObjectRest;

@NameResourceREST(value="comment")
public class Comment extends ObjectRest{
	private String comment ;
    private String commented_date; 
    
    private User user ;
    private Article article ;
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCommented_date() {
		return commented_date;
	}
	public void setCommented_date(String commented_date) {
		this.commented_date = commented_date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	
}
