package com.example.clientandroidblogrest;

import com.example.clientandroidblogrest.model.Article;
import com.example.clientandroidblogrest.model.Comment;
import com.example.clientandroidblogrest.model.User;

import android.app.Application;


public class BlogApplication extends Application {
	
	private Article articleSelect  ;


	private User utilisateurActuel ;
	private String tokenKey  ;
	private Comment commentSelect ;
	
	public BlogApplication() {
		// TODO Auto-generated constructor stub
	}

	public Article getArticleSelect() {
		return articleSelect;
	}

	public void setArticleSelect(Article articleSelect) {
		this.articleSelect = articleSelect;
	}
	public User getUtilisateurActuel() {
		return utilisateurActuel;
	}

	public void setUtilisateurActuel(User utilisateurActuel) {
		this.utilisateurActuel = utilisateurActuel;
	}

	public String getTokenKey() {
		return tokenKey;
	}

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}

	public Comment getCommentSelect() {
		return commentSelect;
	}

	public void setCommentSelect(Comment commentSelect) {
		this.commentSelect = commentSelect;
	}
	

}
