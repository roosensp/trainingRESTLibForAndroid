package com.example.clientandroidblogrest.resttool;



import com.example.clientandroidblogrest.R;
import com.google.gson.Gson;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

public class ObjectRest {
	
	protected Integer id ;
	
	
	
	
	public void create( Object c )
	 {
		Gson gson  = new Gson() ;
		String json = gson.toJson(this) ;
		
		  NameResourceREST resourceNameAnnotation = (NameResourceREST) this.getClass().getAnnotation(NameResourceREST.class);
		  String nameResource = resourceNameAnnotation.value() ;
		  RequestServerRest request ;
		  request  = new RequestServerRest("POST", c , ( (Activity)c).getApplicationContext().getText(R.string.urlconnectionrest).toString()  , this.getClass() ,nameResource  ) ;
		  request.setObj(json) ;
		  request.execute("");	
	
	 } 
	
	public void deleteSecure(Object c , String tokenKey)
	{
	
		 NameResourceREST resourceNameAnnotation = (NameResourceREST) this.getClass().getAnnotation(NameResourceREST.class);
		  String nameResource = resourceNameAnnotation.value() ;
		  RequestServerRest request ;
		  request  = new RequestServerRest("DELETE", c , ( (Activity)c).getApplicationContext().getText(R.string.urlconnectionrest).toString()  , this.getClass() ,nameResource+"/" +Integer.toString(this.id) +"/token/"+tokenKey , Integer.toString(this.id)) ;
		  request.execute("");
		   
	}
	
	public void updateSecure(Object o , String tokenKey)
	{
		Gson gson  = new Gson() ;

		 String json = getJsonSecure(gson.toJson(this) , tokenKey) ;
		 NameResourceREST resourceNameAnnotation = (NameResourceREST) this.getClass().getAnnotation(NameResourceREST.class);
		  String nameResource = resourceNameAnnotation.value() ;
		  
		RequestServerRest request 
		= new RequestServerRest( "PUT", o, ( (Activity)o).getApplicationContext().getText(R.string.urlconnectionrest).toString() ,this.getClass(), nameResource , this ) ; 
		request.setObj(json) ;
	   request.execute("");	
		
	}
	
	public void createSecure( Object c , String tokenKey)
	{
		Gson gson  = new Gson() ;
//		String jsonO = gson.toJson(this) ;
//		String json = "{ \"tokenKey\" : \""+tokenKey+"\" ,  \"timeStampClient\" : 982983 , \"entityClass\" :"+jsonO+"  }" ;
	    String json = getJsonSecure(gson.toJson(this) , tokenKey) ;
	    NameResourceREST resourceNameAnnotation = (NameResourceREST) this.getClass().getAnnotation(NameResourceREST.class);
		  String nameResource = resourceNameAnnotation.value() ;
		  RequestServerRest request ;
		  request  = new RequestServerRest("POST", c , ( (Activity)c).getApplicationContext().getText(R.string.urlconnectionrest).toString()  , this.getClass() ,nameResource  ) ;
		  request.setObj(json) ;
		  request.execute("");
	}
	  
	private String getJsonSecure(String jsonO , String tokenKey) 
	{
		return "{ \"tokenKey\" : \""+tokenKey+"\" ,  \"timeStampClient\" : 982983 , \"entityClass\" :"+jsonO+"  }" ;
		   
	}
	
	
	public void sendWithReturn(Object o , String methode)
	{
		Gson gson  = new Gson() ;
		String json = gson.toJson(this) ;
		 NameResourceREST resourceNameAnnotation = (NameResourceREST) this.getClass().getAnnotation(NameResourceREST.class);
		  String nameResource = resourceNameAnnotation.value() ;
			RequestServerRest request 
			= new RequestServerRest( methode, o, ( (Activity)o).getApplicationContext().getText(R.string.urlconnectionrest).toString() ,this.getClass(), nameResource , this ) ; 
			request.setObj(json) ;
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
	 
	 public Integer getId() 
	 {
		 return this.id ;
	 }
	 
	 public void setId(Integer id)
	 {
		 this.id = id ;
	 }
	 
	
	

}
