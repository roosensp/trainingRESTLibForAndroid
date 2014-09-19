package com.example.restfull.tools;


import com.example.clientandroidrest.R;
import com.google.gson.Gson;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

public class ObjectRest {
	
	protected Integer id ;
	
	 public void create( Object c )
	 {
		  NameResourceREST resourceNameAnnotation = (NameResourceREST) this.getClass().getAnnotation(NameResourceREST.class);
		  String nameResource = resourceNameAnnotation.value() ;
		  RequestServerRest request ;
		  request  = new RequestServerRest("POST", c , ( (Activity)c).getApplicationContext().getText(R.string.urlconnectionrest).toString()  , this.getClass() ,nameResource ) ;
		  request.execute("");	
	
	 }
	 
	 public void update( Object o)
	 {
		
		Gson gson  = new Gson() ;
		String json = gson.toJson(this) ;
		 NameResourceREST resourceNameAnnotation = (NameResourceREST) this.getClass().getAnnotation(NameResourceREST.class);
		  String nameResource = resourceNameAnnotation.value() ;
		  
		RequestServerRest request 
		= new RequestServerRest( "PUT", o, ( (Activity)o).getApplicationContext().getText(R.string.urlconnectionrest).toString() ,this.getClass(), nameResource , this ) ; 
		request.setObj(json) ;
	   request.execute("");	
	 }
	 
	 public void delete(Object c)
	 {
		  NameResourceREST resourceNameAnnotation = (NameResourceREST) this.getClass().getAnnotation(NameResourceREST.class);
		  String nameResource = resourceNameAnnotation.value() ;
		  RequestServerRest request ;
		  request  = new RequestServerRest("DELETE", c , ( (Activity)c).getApplicationContext().getText(R.string.urlconnectionrest).toString()  , this.getClass() ,nameResource , Integer.toString(this.id)) ;
		  request.execute("");	
	 }
}
