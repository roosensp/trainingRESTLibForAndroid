package com.example.clientandroidblogrest.resttool;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;


import android.util.Log;


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
		  		
		  	}
		  	
			return listFinal ;
		}catch(Exception e)
		{
			Log.v("test" , "ERREUR "+ e.getMessage()) ;
			return listFinal ;
		}
		
	  	
	}
		

  
}
