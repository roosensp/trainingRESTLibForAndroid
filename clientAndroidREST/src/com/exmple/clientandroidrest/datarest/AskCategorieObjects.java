package com.exmple.clientandroidrest.datarest;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.example.clientandroidrest.activity.CategoriesActivity;
import com.example.clientandroidrest.model.Categorie;
import com.example.restfull.tools.AskRestObjects;

public class AskCategorieObjects extends AskRestObjects {
   
	 private CategoriesActivity c ;
	
	
	public AskCategorieObjects(Context context, String nameObject , Class o) {
		super(context, nameObject , o);
		c = (CategoriesActivity) context ;
		// TODO Auto-generated constructor stub
	}
	public AskCategorieObjects(Context context, Class o) {
		super(context , o);
		c = (CategoriesActivity) context ;
		
	}
		
	@Override
	public void receiveObjects(List<Object> listObject, String nameObjet) {
		// TODO Auto-generated method stub
	   
	    List<Categorie> list = new ArrayList<Categorie>() ;
	    for(int i = 0 ; i< listObject.size() ; i++ )
	    {
	    	list.add( (Categorie)listObject.get(i)) ;
	    }
	    
	    this.c.setList(list);
	    this.c.receiveData() ;
		
	}
}
