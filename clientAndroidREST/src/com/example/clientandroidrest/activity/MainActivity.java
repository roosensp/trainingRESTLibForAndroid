package com.example.clientandroidrest.activity;


import java.util.ArrayList;
import java.util.List;

import com.example.clientandroidrest.R;
import com.example.clientandroidrest.adapter.ImageAdapter;
import com.example.clientandroidrest.model.Categorie;
import com.example.restfull.tools.AskRestObjects;
import com.example.restfull.tools.RequestServerRest;
import com.exmple.clientandroidrest.datarest.AskCategorieObjects;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(new ImageAdapter(this));
	    gridview.setOnItemClickListener(new OnItemClickListener() {
	    	
	    	@Override
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	    	    
	    		if(position == 0)
	    		{
	    			goCategorieActivity() ;
	    		}else
	    		 if( position == 1)
	    		 {
	    			 goLivreActivity() ;
	    		 }	
	           
	        }
	  
	    });	

	}
	
	private void goCategorieActivity()
	{
		  Intent intent = new Intent();
  		intent.setClass(this, CategoriesActivity.class);
  		startActivity(intent) ;	
	}
	private void goLivreActivity()
	{
		Intent intent = new Intent(this ,LivreActivity.class ) ;
		Bundle bundle = new Bundle();
		bundle.putInt("idcat", 0 );
		
		intent.putExtras(bundle);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
