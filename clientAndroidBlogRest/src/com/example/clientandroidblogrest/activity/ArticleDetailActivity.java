package com.example.clientandroidblogrest.activity;

import java.util.List;

import com.example.clientandroidblogrest.BlogApplication;

import com.example.clientandroidblogrest.CommentActivity;
import com.example.clientandroidblogrest.EditArticle;
import com.example.clientandroidblogrest.EditCommentActivity;
import com.example.clientandroidblogrest.R;

import com.example.clientandroidblogrest.model.Article;
import com.example.clientandroidblogrest.resttool.ImplementRESTObject;

import android.opengl.Visibility;
import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ArticleDetailActivity extends Activity implements ImplementRESTObject {

	private TextView tvTitre ; 
	private TextView tvContent ;
	private Article article ;
	private Button bt_comments ;
	private Button bt_del ; 
	private Button bt_edit ;
	private Button bt_valid ;
	private Button bt_share ;
	private BlogApplication clientApp ;
	private ImageView  imageLogin ;
	
	
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_article_detail);
		this.tvTitre = (TextView) findViewById(R.id.tv_titre) ;
		this.tvContent = (TextView) findViewById(R.id.tv_content) ;
		this.bt_valid = (Button)findViewById(R.id.bt_valid) ;
		this.bt_share = (Button)findViewById(R.id.bt_share) ;
		clientApp = (BlogApplication) this.getApplication();
		 this.article = clientApp.getArticleSelect() ;
		 
		 this.tvTitre.setText(this.article.getTitle())  ;
		 this.tvContent.setText(this.article.getContent()) ;
		 this.imageLogin = (ImageView) findViewById(R.id.image_login) ;
			
		 
		
		 
		 this.bt_comments = (Button) findViewById(R.id.bt_comment) ;
		 this.bt_del = (Button) findViewById(R.id.bt_del) ;
		 this.bt_edit = (Button)findViewById(R.id.bt_edit) ;
		 
		 if(clientApp.getUtilisateurActuel() != null)
		 {
			 if(clientApp.getUtilisateurActuel().getRole().getName().equals("admin") || clientApp.getUtilisateurActuel().getId() == this.article.getUser().getId()  )
			 {
				 this.bt_del.setOnClickListener( new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Log.v("test" , "ON clique del") ;
							 deleteArticle() ;
						}
					}) ;
					 
					
					 this.bt_edit.setOnClickListener( new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Log.v("test" , "ON clique edit") ;
							goEditArticle() ;
						}
					}) ; 
			 }else
			 {
				 this.bt_valid.setVisibility(8) ;
				 bt_del.setVisibility(8) ;
				 bt_edit.setVisibility(8) ; 
			 }
			 
		 }else
		 {
			 this.bt_valid.setVisibility(8) ;
			 bt_del.setVisibility(8) ;
			 bt_edit.setVisibility(8) ;
			 
		 }
		
		 
		  this.bt_valid.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				valideArticle() ;
			}
		}) ;
		  this.bt_share.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent shareIntent = new Intent(Intent.ACTION_SEND);
//				  shareIntent.setType("text/plain");
//				  shareIntent.putExtra(Intent.EXTRA_TEXT, "URLyouWantToShare");
//				  shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Text qsdqsdqs ");
//				  shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Super article de fou");
//				  startActivity(Intent.createChooser(shareIntent, "Share..."));
//			
				 share() ;
			
			}
		}) ;
		 
		 this.bt_comments.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				goComments() ;
				
			}
		}) ;
		 
		 imageLogin.setOnClickListener( new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					goLogin() ;
				}
			}) ;
		
		 
	}
	public void share()
	{
	    Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
	    shareIntent.setType("text/plain");
	    shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "share");
	    shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "http://www.google.ca");    

	   startActivity(Intent.createChooser(shareIntent, "share"));

	}
	public void goLogin()
	{
		Intent intent = new Intent( this , LoginActivity.class ) ;
		startActivity(intent);
	} 
	
	private void valideArticle() 
	{
		BlogApplication appA = (BlogApplication) this.getApplicationContext() ;	
		Article a = appA.getArticleSelect() ;
		a.setValide(true);
		a.updateSecure(this, appA.getTokenKey()) ;
		
		
	}
	private void goEditArticle()
	{
		Intent intent = new Intent(this , EditArticle.class) ;
		startActivity(intent) ;
	}
	private void deleteArticle()
	{
		this.article.deleteSecure(this , clientApp.getTokenKey()) ;
	}
	private void goComments()
	{
		if(clientApp.getTokenKey() != null)
		{
			Intent intent = new Intent( this , CommentActivity.class ) ;
			startActivity(intent);
		}else
		{
			Intent intent = new Intent( this , LoginActivity.class ) ;
			startActivity(intent);
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_article_detail, menu);
		return true;
	}

	@Override
	public void postCreate(String response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postUpdate(Boolean success) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postDelete(Boolean success) {
		// TODO Auto-generated method stub
		
	}

}
