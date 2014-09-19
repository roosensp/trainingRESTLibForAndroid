package com.exmple.clientandroidrest.datarest;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.example.clientandroidrest.activity.CategoriesActivity;
import com.example.clientandroidrest.activity.LivreActivity;
import com.example.clientandroidrest.model.Categorie;
import com.example.clientandroidrest.model.Livre;
import com.example.restfull.tools.AskRestObjects;

public class AskLivreObjects extends AskRestObjects {
	   
		 private LivreActivity c ;
		
		
		 public AskLivreObjects(Context context)
		 {
			 
			 super(context);
			 c = (LivreActivity) context ;
			 
		 }
		 
		public AskLivreObjects(Context context, String nameObject , Class o) {
			super(context, nameObject , o);
			c = (LivreActivity) context ;
			// TODO Auto-generated constructor stub
		}
		
		public AskLivreObjects(Context context, Class o) {
			super(context , o);
			c = (LivreActivity) context ;
			// TODO Auto-generated constructor stub
		}
			
		@Override
		public void receiveObjects(List<Object> listObject, String nameObjet) {
			// TODO Auto-generated method stub
		   Log.v("test" ,"Receive Objects ") ;
		    List<Livre> list = new ArrayList<Livre>() ;
		    Log.v("test" , "taille LIST => " + listObject.size()) ;
		    for(int i = 0 ; i< listObject.size() ; i++ )
		    {
		    	
		    	list.add( (Livre)listObject.get(i)) ;
		    }
		    Log.v("test" ,"apres boucle de castage") ;
		    
		    this.c.setList(list);
		    this.c.receiveData() ;
			
		}
	}
