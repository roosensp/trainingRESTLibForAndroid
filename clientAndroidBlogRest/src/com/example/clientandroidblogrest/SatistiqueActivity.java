package com.example.clientandroidblogrest;

import com.example.clientandroidblogrest.getdata.GetSatistique;
import com.example.clientandroidblogrest.model.Article;
import com.example.clientandroidblogrest.model.Comment;
import com.example.clientandroidblogrest.model.User;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class SatistiqueActivity extends Activity {

	private GetSatistique getSatistique ;
	private BlogApplication blogApplication ;
	private TextView tv_countArticleTotal ;
	private TextView tv_countArticlePublish ;
    private TextView tv_countUser ;
    private TextView tv_countcomment ;
    private TextView tv_avgCommentByArticle ;
    
    
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_satistique);
		
		tv_countArticleTotal = (TextView) findViewById(R.id.tv_countarticle) ;
		tv_countcomment = (TextView) findViewById(R.id.tv_countcomment) ;
		tv_countUser = (TextView) findViewById(R.id.tv_countuser) ;
		tv_avgCommentByArticle = (TextView) findViewById(R.id.tv_avg) ;
		tv_countArticlePublish = (TextView) findViewById(R.id.tv_countarticlevalid) ;
		
		
		getSatistique = new GetSatistique(this) ;
		blogApplication = (BlogApplication)this.getApplicationContext() ;
		getSatistique.getObjectsSpecialRequest(Article.class , "count/token/"+blogApplication.getTokenKey() , false) ;
		getSatistique.getObjectsSpecialRequest(Article.class , "valid/count/token/"+blogApplication.getTokenKey() , false) ;
		
		getSatistique.getObjectsSpecialRequest(Comment.class , "count/token/"+blogApplication.getTokenKey() , false) ;
		getSatistique.getObjectsSpecialRequest(User.class    , "count/token/"+blogApplication.getTokenKey() , false) ;
		
	
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_satistique, menu);
		return true;
	}

	public GetSatistique getGetSatistique() {
		return getSatistique;
	}

	public void setGetSatistique(GetSatistique getSatistique) {
		this.getSatistique = getSatistique;
	}

	public BlogApplication getBlogApplication() {
		return blogApplication;
	}

	public void setBlogApplication(BlogApplication blogApplication) {
		this.blogApplication = blogApplication;
	}

	public TextView getTv_countArticleTotal() {
		return tv_countArticleTotal;
	}

	public void setTv_countArticleTotal(TextView tv_countArticleTotal) {
		this.tv_countArticleTotal = tv_countArticleTotal;
	}

	public TextView getTv_countArticlePublish() {
		return tv_countArticlePublish;
	}

	public void setTv_countArticlePublish(TextView tv_countArticlePublish) {
		this.tv_countArticlePublish = tv_countArticlePublish;
	}

	public TextView getTv_countUser() {
		return tv_countUser;
	}

	public void setTv_countUser(TextView tv_countUser) {
		this.tv_countUser = tv_countUser;
	}

	public TextView getTv_countcomment() {
		return tv_countcomment;
	}

	public void setTv_countcomment(TextView tv_countcomment) {
		this.tv_countcomment = tv_countcomment;
	}

	public TextView getTv_avgCommentByArticle() {
		return tv_avgCommentByArticle;
	}

	public void setTv_avgCommentByArticle(TextView tv_avgCommentByArticle) {
		this.tv_avgCommentByArticle = tv_avgCommentByArticle;
	}

}
