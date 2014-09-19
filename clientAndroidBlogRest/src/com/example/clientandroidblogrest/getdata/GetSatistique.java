package com.example.clientandroidblogrest.getdata;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.example.clientandroidblogrest.SatistiqueActivity;
import com.example.clientandroidblogrest.model.Article;
import com.example.clientandroidblogrest.resttool.AskRestObjects;

public class GetSatistique extends AskRestObjects  {

	private SatistiqueActivity context ;
	
	public GetSatistique(Context c) {
		super(c);
		this.context = (SatistiqueActivity) c ;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void receiveResponse(String response, String url)
	{
		Log.v("test" , "RECEIVE RESPONSE  URL=>"+url) ;	
	   String[] tblUrl = url.split("/") ;
	    if(tblUrl[0].equals("article") )
	    {
	    	if(tblUrl[1].equals("count"))
	    	{
		    	this.context.getTv_countArticleTotal().setText(response);
		    	if(!this.context.getTv_countcomment().getText().equals("0"))
		    	{
		    		try
		    		{
		    			Integer nbComment = Integer.parseInt(this.context.getTv_countcomment().getText().toString());
		    		    Integer nbArticle = Integer.parseInt(response) ;
		    		    Integer avg = nbComment / nbArticle ;
		    		    this.context.getTv_avgCommentByArticle().setText(Integer.toString(avg)); 
		    		}catch(Exception e)
		    		{
		    			
		    		}
		    		
		    	}
	    	}else if(tblUrl[1].equals("valid"))
	    	{
	    		this.context.getTv_countArticlePublish().setText(response) ;
	    	}
	    }
	    if(tblUrl[0].equals("comment") )
	    {
	    	if(tblUrl[1].equals("count"))
	    	{
	    	this.context.getTv_countcomment().setText(response) ;
	    	
	    	if(!this.context.getTv_countArticleTotal().getText().equals("0"))
	    	{
	    		try
	    		{
	    			Integer nbComment = Integer.parseInt(response);
	    		    Integer nbArticle = Integer.parseInt(this.context.getTv_countArticleTotal().getText().toString()) ;
	    		    Integer avg = nbComment / nbArticle ;
	    		    this.context.getTv_avgCommentByArticle().setText(Integer.toString(avg)); 
	    		}catch(Exception e)
	    		{
	    			
	    		}
	    		
	    	}
	    	}
	    }
	    if(tblUrl[0].equals("user") )
	    {
	    	if(tblUrl[1].equals("count"))
	    	{
	    	this.context.getTv_countUser().setText(response) ;
	    	}
	    }
	
	}

	public SatistiqueActivity getContext() {
		return context;
	}

	public void setContext(SatistiqueActivity context) {
		this.context = context;
	}
	
}
