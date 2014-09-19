package com.example.clientandroidblogrest;

import com.example.clientandroidblogrest.model.Comment;
import com.example.clientandroidblogrest.resttool.ImplementRESTObject;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EditCommentActivity extends Activity  implements ImplementRESTObject{

	 private EditText et_comment ;
	 private Button  bt_valider ;
	 private Comment comment ;
	 private BlogApplication app ;
	 private Integer commentID  = -1 ; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_comment);
		et_comment = (EditText) findViewById(R.id.et_comment) ;
		bt_valider = (Button) findViewById(R.id.bt_valider) ;
		app = (BlogApplication) this.getApplicationContext() ;
	
		try
		{
			Bundle bundle = this.getIntent().getExtras();
			if(bundle != null)
			{
				 commentID =	bundle.getInt("idcomment") ;	
			}
			
		}catch(Exception e)
		{
			
		}
	
		if(commentID >-1)
		{
			if(app.getCommentSelect() != null)
			{
			comment = app.getCommentSelect();
			et_comment.setText( comment.getComment()) ;
			Log.v("test" , "Edit one ") ;
			}
		}else
		{
			Log.v("test" , "new one ") ;
			comment = new Comment() ;
		}
		
		
		
		
		
		
		bt_valider.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				validerMessage() ;
				
			}
		});
	}

	public void validerMessage()
	{
	
	BlogApplication clientApp = (BlogApplication)	this.getApplicationContext() ;
      if(clientApp.getArticleSelect() != null)
      {
    	  Log.v("test" , "article ? present" ) ;
    	  comment.setArticle(clientApp.getArticleSelect()) ;
    	  if(clientApp.getUtilisateurActuel() != null )
          {
         	  Log.v("test" , "user ? present" ) ;  
           comment.setUser(clientApp.getUtilisateurActuel()) ;
              if(et_comment.getText().toString() != null)
              {
            	  
            	  Log.v("test" , "comment ? present" ) ; 
            	  if(commentID >-1)
            	  {
            		  // edit
            		  comment.setComment(et_comment.getText().toString()) ;
            		  comment.updateSecure(this,  clientApp.getTokenKey());
            	  }else
            	  {
            		  // create
            		  comment.setComment(et_comment.getText().toString()) ;
                	  comment.createSecure(this,  clientApp.getTokenKey()) ;
            	  }
            	
              }
          }
    	  
      }
	 
      
      
     
//	  this.comment.setArticle(clientApp.getArticleSelect());
//	  this.comment.setUser(clientApp.getUtilisateurActuel()) ;
//	  this.comment.setComment(et_comment.getText().toString()) ;
//	  
//	  this.comment.create(this) ;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_edit_comment, menu);
		return true;
	}

	@Override
	public void postCreate(String response) {
		// TODO Auto-generated method stub
		
		this.finish() ;
	}

	@Override
	public void postUpdate(Boolean success) {
		// TODO Auto-generated method stub
		this.finish() ;
	}

	@Override
	public void postDelete(Boolean success) {
		// TODO Auto-generated method stub
		this.finish() ;
	}

}
