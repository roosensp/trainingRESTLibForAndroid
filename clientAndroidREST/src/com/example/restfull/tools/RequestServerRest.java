package com.example.restfull.tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import com.example.clientandroidrest.model.Categorie;
import com.google.gson.Gson;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class RequestServerRest extends AsyncTask<String, Void, String>{

	
	private String  typeConnection ;
	private String  rechercheEndUrl ; 
	private String 	response ;
	private AskRestObjects classWhoAsk ; // lile list 
	private Object objectRestWhoAsk ;    // like create 
    private String url  ;
    private String typeAnwswer = "application/json" ;
    private Class objectSearch ;
	private String obj ="{}";
	private String idToDelete = "" ;
    


	public RequestServerRest( String connection , String rechercheEndUrl , AskRestObjects classWhoAsk , String url, Class whoSearch ) {
		  this.classWhoAsk = classWhoAsk ;
		  this.rechercheEndUrl = rechercheEndUrl ;
		  this.typeConnection = connection ;
		 
		  this.url = url ;
		  this.objectSearch = whoSearch ;
		  
	
		  
		}
	
	// with call back
	public RequestServerRest( String connection , Object classWhoAsk , String url, Class whoSearch ,  String  rechercheEndUrl ) {
		  this.objectRestWhoAsk = classWhoAsk ;
		  this.rechercheEndUrl = rechercheEndUrl ;
		  this.typeConnection = connection ;
		 
		  this.url = url ;
	  
		}
	public RequestServerRest( String connection , Object classWhoAsk , String url, Class whoSearch ,  String  rechercheEndUrl , Object o) {
		  this.objectRestWhoAsk = classWhoAsk ;
		  this.rechercheEndUrl = rechercheEndUrl ;
		  this.typeConnection = connection ;
		  Gson gson = new Gson() ;
		  
		  this.obj = gson.toJson(o) ;
		  this.url = url ;
	  
		}
	public RequestServerRest( String connection , Object classWhoAsk , String url, Class whoSearch ,  String  rechercheEndUrl , String idToDelete ) {
		  this.objectRestWhoAsk = classWhoAsk ;
		  this.rechercheEndUrl = rechercheEndUrl ;
		  this.typeConnection = connection ;
		 
		  this.url = url ;
		  this.idToDelete = idToDelete ;
	  
		}
	
	
	
	public RequestServerRest( String connection , String rechercheEndUrl   , String url) {
		  
		  this.rechercheEndUrl = rechercheEndUrl ;
		  this.typeConnection = connection ;
		 
		  this.url = url ;
		  
		
	
		}
    
    @Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		
		if(this.typeConnection == "GET")
		{
			this.getRequest() ;
		}else if(this.typeConnection == "POST")
		{
			this.postRequest();
		}else if(this.typeConnection == "PUT")
		{
			this.putRequest();
		}else if(this.typeConnection == "DELETE")
		{
			this.deleteRequest() ;
		}
		return "" ;
		
	}
    
    

    private void deleteRequest( )
	{
		try
		{
			 
			 HttpClient client = new DefaultHttpClient();
			 HttpDelete request = new HttpDelete(this.url + this.rechercheEndUrl+"/"+this.idToDelete);
			 request.addHeader("Content-type", this.typeAnwswer);
			
			
			 HttpResponse response = client.execute(request);
			 int code = response.getStatusLine().getStatusCode();
			 if (code == 200) {  
					BufferedReader rd = new BufferedReader(
		                    new InputStreamReader(response.getEntity().getContent()));
		            StringBuffer result = new StringBuffer();
		            String line = "";
		            while ((line = rd.readLine()) != null) {
		                result.append(line);
		            }
		            this.response = result.toString() ;
		            Log.v("test",  result.toString() ) ; 
				} else {     
		          
		           Log.v("test", Integer.toString(code)) ; 
		        }	
		}catch(Exception e)
		{
			Log.v("test" , "Erreur  "+e.getMessage() );
		}
		
		 
	}
	
	private void putRequest( )
	{
		try
		{
			 StringEntity entity = new StringEntity(obj, "UTF-8");
			 Log.v("test" , obj.toString()) ;
			 HttpClient client = new DefaultHttpClient();
			 Log.v("test" ,this.url + this.rechercheEndUrl) ;
			 HttpPut request = new HttpPut(this.url + this.rechercheEndUrl);
			 request.addHeader("Content-type", this.typeAnwswer);
			 request.setEntity(entity) ;
				
			 HttpResponse response = client.execute(request);
			 int code = response.getStatusLine().getStatusCode();
			 if (code == 200) {  
					BufferedReader rd = new BufferedReader(
		                    new InputStreamReader(response.getEntity().getContent()));
		            StringBuffer result = new StringBuffer();
		            String line = "";
		            while ((line = rd.readLine()) != null) {
		                result.append(line);
		            }
		            this.response = result.toString() ;
		            Log.v("test",  result.toString() ) ; 
				} else {     
		          
		           Log.v("test", Integer.toString(code)) ; 
		        }	
		}catch(Exception e)
		{
			Log.v("test" , "Erreur  "+e.getMessage() );
		}
		
		 
	}
	
	private void postRequest()
	{
		try
		{
			 StringEntity entity = new StringEntity("{}", "UTF-8");
				
			HttpClient client = new DefaultHttpClient();
			HttpPost request = new HttpPost(this.url + this.rechercheEndUrl);
			request.addHeader("Content-type", this.typeAnwswer);
			request.setEntity(entity) ;
			HttpResponse response = client.execute(request);
			int code = response.getStatusLine().getStatusCode();
		 
		
			if (code == 200) {  
				BufferedReader rd = new BufferedReader(
	                    new InputStreamReader(response.getEntity().getContent()));
	            StringBuffer result = new StringBuffer();
	            String line = "";
	            while ((line = rd.readLine()) != null) {
	                result.append(line);
	            }
	            this.response = result.toString() ;
	            Log.v("test", "result "+ result.toString() ) ; 
			} else {     
	          
	           Log.v("test", Integer.toString(code)) ; 
	        }
		}catch(Exception e)
		{
			Log.v("test" , "Erreur  "+e.getMessage() );
		
		}
		 
	}
	private void getRequest()
	{
		try{
			 HttpClient client = new DefaultHttpClient();
			 Log.v("test" , "URL GET => " + this.url +this.rechercheEndUrl) ;
			 HttpGet request = new HttpGet(this.url +this.rechercheEndUrl) ;				        
			  request.addHeader("Content-type", this.typeAnwswer);
			  HttpResponse response = client.execute(request);
			  int code = response.getStatusLine().getStatusCode();
			 
			  Log.v("test" , Integer.toString(code) );
			
			  if (code == 200) {   
				 
		            BufferedReader rd = new BufferedReader(
		                    new InputStreamReader(response.getEntity().getContent()));
		            StringBuffer result = new StringBuffer();
		            String line = "";
		            while ((line = rd.readLine()) != null) {
		                result.append(line);
		            }
		            this.response = result.toString() ;
		            Log.v("test",  result.toString() ) ; 
		     
			  }
			  else {     
		          
		           Log.v("test", Integer.toString(code)) ; 
		         
		            
		        }

		}catch(Exception e)
		{
			 Log.v("test" , "Erreur  "+e.getMessage() );
			
		}
		
	}
	
	
	
	@Override
    protected void onPostExecute(String result) { 
		
		if(this.typeConnection == "GET")
		{
			Log.v("test" , "ICI1");
			JsonToObjects  jsonToObjects = new JsonToObjects(this.response ,  this.objectSearch) ;
			Log.v("test" , "ICI2");
			List<Object> list = jsonToObjects.getListObjects() ;
			Log.v("test" , "ICI3 taile list " + list.size());
			classWhoAsk.receiveObjects(list, this.rechercheEndUrl) ;
			Log.v("test" , "ICI4");
		}else if(this.typeConnection == "POST")
		{
			ImplementRESTObject ob =	(ImplementRESTObject)objectRestWhoAsk ;
			ob.postCreate(Integer.parseInt(this.response));
		}else if(this.typeConnection == "DELETE")
		{
			ImplementRESTObject ob =	(ImplementRESTObject)objectRestWhoAsk ;
			ob.postDelete(true);
		}
		else if(this.typeConnection == "PUT")
		{
			Log.v("test" ,"POST EXECUTE") ;
			ImplementRESTObject ob =	(ImplementRESTObject)objectRestWhoAsk ;
			ob.postUpdate(true);
		}
		
    }
	
	public String getObj() {
		return obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}
	
}
