package com.example.clientandroidblogrest;

import java.util.ArrayList;

import com.example.clientandroidblogrest.activity.ArticleDetailActivity;
import com.example.clientandroidblogrest.activity.LoginActivity;
import com.example.clientandroidblogrest.adapter.ArticleListAdapter;
import com.example.clientandroidblogrest.adapter.CommentListAdapter;
import com.example.clientandroidblogrest.getdata.GetCommentsREST;
import com.example.clientandroidblogrest.model.Article;
import com.example.clientandroidblogrest.model.Comment;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class CommentActivity extends Activity {

	private ArrayList<Comment> list = new ArrayList<Comment>() ;
	private ListView lv ;
	private CommentListAdapter listAdpater ;
	private Button bt_laisserMessage ;
	
	
	private Article article ;
	
	private GetCommentsREST getComments = new GetCommentsREST(this, Comment.class) ;
	private BlogApplication clientApp  ;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comment);
		this.lv = (ListView)findViewById(R.id.lv_comment) ;
		this.bt_laisserMessage = (Button)findViewById(R.id.bt_laisser_comment);
		
		clientApp = (BlogApplication) this.getApplicationContext();
		this.article = clientApp.getArticleSelect();
			
		
		this.loadData() ;
		
		
		  this.lv.setOnItemClickListener(  new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					// TODO Auto-generated method stub
			         goMenuComment(arg2) ;
					
				}
			});
		  bt_laisserMessage.setOnClickListener( new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					goMakeCommment() ;
				}
			}) ;
		  
		
		 
	}
	
	private void goMenuComment(Integer position)
	{
		clientApp.setCommentSelect( this.list.get(position)) ;
		 Intent intent = new Intent( this , ChoiceCommentMenuActivity.class ) ;
		 startActivity(intent);
	}
	public void goMakeCommment() 
	{
		 Intent intent = new Intent( this , EditCommentActivity.class ) ;
	    startActivity(intent);
			
	}
	public void loadData()
	{
		 this.getComments.getObjectsByOtherObjectAndSecure( Comment.class, Article.class, this.article.getId(), clientApp.getTokenKey());
	}
	
	public void receiveData()
	{
		
		this.listAdpater  = new CommentListAdapter() ;

		 this.lv.setAdapter(this.listAdpater) ;
		 this.listAdpater.setmContext(this) ;
		 this.listAdpater.setListComment(list);		
		 this.lv.setAdapter(  listAdpater); 
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_comment, menu);
		return true;
	}

	public ArrayList<Comment> getList() {
		return list;
	}

	public void setList(ArrayList<Comment> list) {
		this.list = list;
	}

	public ListView getLv() {
		return lv;
	}

	public void setLv(ListView lv) {
		this.lv = lv;
	}

	public CommentListAdapter getListAdpater() {
		return listAdpater;
	}

	public void setListAdpater(CommentListAdapter listAdpater) {
		this.listAdpater = listAdpater;
	}

	


	

}
