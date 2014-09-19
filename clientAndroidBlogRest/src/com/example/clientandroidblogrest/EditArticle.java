package com.example.clientandroidblogrest;

import com.example.clientandroidblogrest.model.Article;
import com.example.clientandroidblogrest.resttool.ImplementRESTObject;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EditArticle extends Activity  implements ImplementRESTObject{

	private Article article ;
	private EditText et_title ; 
	private EditText et_content ;
	private BlogApplication blogApp ;
	private Button bt_edit ;
	private Boolean modeEditCreate = true ;  // true => EDIT  || false => Create
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_edit_article);
		et_title = (EditText) findViewById(R.id.et_title) ;
		et_content = (EditText) findViewById(R.id.et_content) ;
		
		blogApp = (BlogApplication) this.getApplicationContext() ;
	
		if(blogApp.getArticleSelect().getId() != null)
		{
			
			this.article = blogApp.getArticleSelect() ;
			et_title.setText( this.article.getTitle()) ;
			et_content.setText(this.article.getContent()) ;
		}else
		{
			
			this.modeEditCreate = false ;
			this.article = new Article() ;
		//	this.bt_edit.setText( "Create") ;
		}
		
		bt_edit = (Button) findViewById(R.id.bt_edit) ;
		bt_edit.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				editArticle() ;
			}
		}) ;
		
		
	}
	
	private void editArticle()
	{
		this.article.setTitle( et_title.getText().toString()) ;
		this.article.setContent( et_content.getText().toString()) ;
		if(modeEditCreate)
		{
			this.article.updateSecure(this , blogApp.getTokenKey()) ;
		}else
		{
			this.article.createSecure(this , blogApp.getTokenKey()) ;
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_edit_article, menu);
		return true;
	}

	@Override
	public void postCreate(String response) {
		// TODO Auto-generated method stub
		if(response != null)
		{
			Log.v("test" , response) ;
		}
		
	}

	@Override
	public void postUpdate(Boolean success) {
		// TODO Auto-generated method stub
		Log.v("test" , "OUAI  :D") ;
	}

	@Override
	public void postDelete(Boolean success) {
		// TODO Auto-generated method stub
		
	}
	

}
