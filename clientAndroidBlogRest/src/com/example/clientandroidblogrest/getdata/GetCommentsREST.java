package com.example.clientandroidblogrest.getdata;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.example.clientandroidblogrest.CommentActivity;
import com.example.clientandroidblogrest.model.Article;
import com.example.clientandroidblogrest.model.Comment;
import com.example.clientandroidblogrest.resttool.AskRestObjects;

public class GetCommentsREST  extends AskRestObjects{
   private CommentActivity activity ;
	
	public GetCommentsREST(Context c) {
		super(c) ;
		activity = (CommentActivity) c ;
		
	}
	public GetCommentsREST(Context c , Class o) {
		// TODO Auto-generated constructor stub
		super(c, o ) ;
		this.activity = (CommentActivity)c ;
	}
	
	@Override
	public void receiveObjects(List<Object> listObject, String nameObjet) {
		// TODO Auto-generated method stub
	   Log.v("test" ,"Receive Objects ") ;
	   ArrayList<Comment> list = new ArrayList<Comment>() ;
	   Log.v("test" , "taille LIST => " + listObject.size()) ;
	   for(int i = 0 ; i< listObject.size() ; i++ )
	   {
	      list.add( (Comment)listObject.get(i)) ;
	   }
	    Log.v("test" ,"apres boucle de castage") ;
	    
	    this.activity.setList(list) ;
	    this.activity.receiveData() ;
		
	}
	
}
