package com.example.restfull.tools;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;


import android.util.Log;

import com.example.clientandroidrest.model.Categorie;
import com.example.clientandroidrest.model.Livre;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonToObjects {
  private String json ; 
  private Class o ;
	
	public JsonToObjects( String json  , Class o ) {
		this.json = json ;
	
		this.o = o ;

	}
	
	public List<Object> getListObjects()
	{
		List<Object> listFinal = new ArrayList<Object>() ;
		try
		{
			Gson gson = new Gson() ;
		
			JSONArray jsonArray = new JSONArray(this.json);
			
		  	for(int i = 0 ; i< jsonArray.length() ; i++)
		  	{
		  		
		  		listFinal.add( gson.fromJson( jsonArray.get(i).toString() ,this.o ));
		  		Log.v("test" , "dans la boucle");
		  	}
		  	
			return listFinal ;
		}catch(Exception e)
		{
			Log.v("test" , "ERREUR "+ e.getMessage()) ;
			return listFinal ;
		}
		
//		Type listType = 
//				new TypeToken<ArrayList <Object>>() {
//        }.getType();
//       
//        List<Object> listJsonObject = new Gson().fromJson(this.json, listType);
//	  	Log.v("test"  , "premiére list") ;
		
	  	
//	    List<Object> listFinal = new ArrayList<Object>() ;
//	  	for(int i = 0 ; i< listJsonObject.size() ; i++)
//	  	{
//	  		Log.v("test"  , "dans boucle" + listJsonObject.get(i).toString()) ;
//	  		listFinal.add( gson.fromJson( listJsonObject.get(i).toString() ,this.o ));
//	  		Log.v("test" , " Add good ") ;
//	  	}
	
	  	
	}
		

  
}
