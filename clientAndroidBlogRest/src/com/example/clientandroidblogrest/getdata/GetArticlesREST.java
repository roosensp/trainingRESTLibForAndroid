package com.example.clientandroidblogrest.getdata;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.example.clientandroidblogrest.activity.ListArticle;
import com.example.clientandroidblogrest.model.Article;
import com.example.clientandroidblogrest.resttool.AskRestObjects;




public class GetArticlesREST extends AskRestObjects {

	 private ListArticle c ;
		
	
	public GetArticlesREST(Context context)
	{
		super(context) ;
		c = (ListArticle) context ;
	}
	
	public GetArticlesREST(Context context , Class o)
	{
		super(context, o ) ;
		c = (ListArticle) context ;
		
	}
	
	@Override
	public void receiveObjects(List<Object> listObject, String nameObjet) {
	
	   ArrayList<Article> list = new ArrayList<Article>() ;
	
	   for(int i = 0 ; i< listObject.size() ; i++ )
	   {
	      list.add( (Article)listObject.get(i)) ;
	   }
	  
	    
	    this.c.setList(list) ;
	    this.c.receiveData() ;
		
	}
}
