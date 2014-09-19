package com.example.clientandroidrest.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.clientandroidrest.R;
import com.example.clientandroidrest.R.layout;
import com.example.clientandroidrest.R.menu;
import com.example.clientandroidrest.adapter.ListCateAdapter;
import com.example.clientandroidrest.adapter.ListLivreAdapter;
import com.example.clientandroidrest.model.Categorie;
import com.example.clientandroidrest.model.Livre;
import com.exmple.clientandroidrest.datarest.AskCategorieObjects;
import com.exmple.clientandroidrest.datarest.AskLivreObjects;

import android.opengl.Visibility;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class LivreActivity extends Activity {
	private List<Livre> list = new ArrayList<Livre>()  ; 
	

	private ListView lv;
	private ListLivreAdapter listAdpater ;
	private Button btAddCath ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_categories);
		
	
		int catID = 0 ;
		
		try
		{
			Bundle bundle = this.getIntent().getExtras();
			catID =	bundle.getInt("idcat") ;
		}catch(Exception e)
		{
			Log.e("test", e.getMessage()) ;
		}
		
		this.lv = (ListView) findViewById(R.id.lv_categorie);

		 if(catID != 0)
		 {
			 AskLivreObjects askLivre = new AskLivreObjects(this) ;
			 askLivre.getObjectsByOtherObject( Livre.class , Categorie.class, catID) ;
			 
		 }else
		 {
			 AskLivreObjects askLivre = new AskLivreObjects(this  , Livre.class) ;
			 askLivre.getObjects() ; 
		 }
		 
		 this.btAddCath = (Button)findViewById(R.id.bt_add) ;
		 this.btAddCath.setVisibility( 8) ;
//         btAddCath.setOnClickListener( new Button.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				creationNewLivre() ;
//			}
//		}) ;
		 
		 
	}
	
	private void creationNewLivre()
	{
		Livre l = new Livre() ;
		l.create( this) ;
		
	}
	
	
	public void receiveData()
	{
		 this.listAdpater = new ListLivreAdapter() ;
		 this.lv.setAdapter(this.listAdpater) ;
		 this.listAdpater.setmContext(this) ;
		 this.listAdpater.setListLivre(list) ;
		
		 this.lv.setAdapter(  listAdpater); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_livre, menu);
		return true;
	}

	public List<Livre> getList() {
		return list;
	}

	public void setList(List<Livre> list) {
		this.list = list;
	}

	public ListView getLv() {
		return lv;
	}

	public void setLv(ListView lv) {
		this.lv = lv;
	}

	public ListLivreAdapter getListAdpater() {
		return listAdpater;
	}

	public void setListAdpater(ListLivreAdapter listAdpater) {
		this.listAdpater = listAdpater;
	}
}
