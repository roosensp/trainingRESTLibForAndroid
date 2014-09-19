package com.example.clientandroidrest.activity;



import com.example.clientandroidrest.ClientAndroidRESTApp;
import com.example.clientandroidrest.R;
import com.example.clientandroidrest.R.layout;
import com.example.clientandroidrest.R.menu;
import com.example.clientandroidrest.model.Categorie;
import com.example.restfull.tools.ImplementRESTObject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class CategorieDetailActivity extends Activity implements ImplementRESTObject {

	private Categorie cat ;
	private EditText nomCat ; 
	private EditText descriptionCat ;
	private TextView idCat ;
	private Button btUpdate ;
	private Button btDel ; 
	private Button lookBooks ;
	private Button lookAllBooks ;
	private Context mContext ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_categorie_detail);
		ClientAndroidRESTApp clientApp = (ClientAndroidRESTApp)this.getApplicationContext() ;
		this.mContext = this ;
		this.cat = clientApp.getCategorieSelect() ;
		this.idCat = (TextView) findViewById(R.id.labelidvalue);
		this.nomCat = (EditText)findViewById(R.id.edit_text_nom) ;
		this.descriptionCat = (EditText)findViewById(R.id.edit_text_description) ;
		this.btUpdate = (Button)findViewById(R.id.bt_update) ;
		this.btDel = (Button)findViewById(R.id.bt_delete) ;
		this.lookBooks = (Button)findViewById(R.id.bt_see_books) ;
		this.lookAllBooks = (Button)findViewById(R.id.bt_see_all_books) ;
		
		
		this.idCat.setText( Integer.toString( this.cat.getId()));
		this.nomCat.setText( this.cat.getNom()) ;
		this.descriptionCat.setText( this.cat.getDescription()) ;
		
		
		
		
		
		
		this.btUpdate.setOnClickListener( new OnClickListener() {
	   	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				update();
				}
		}) ;
		
		
		this.btDel.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				supprimerCat() ;
			}
		});
		this.lookBooks.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(mContext ,LivreActivity.class ) ;
				Bundle bundle = new Bundle();
				bundle.putInt("idcat", cat.getId() );
				
				intent.putExtras(bundle);
				startActivity(intent);
			}
		}) ;
		
		this.lookAllBooks.setOnClickListener( new OnClickListener() {
		   	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(mContext ,LivreActivity.class ) ;
				Bundle bundle = new Bundle();
				bundle.putInt("idcat", 0);
				
				intent.putExtras(bundle);
				startActivity(intent);
				}
		}) ;
	}

	private void supprimerCat()
	{
		cat.delete(this) ;
	}
	public void update()
	{
		cat.setName(this.nomCat.getText().toString() ) ;
		cat.setDescription(this.descriptionCat.getText().toString()) ;
		cat.update(this);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_categorie_detail, menu);
		return true;
	}

	@Override
	public void postCreate(int idObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postUpdate(Boolean success) {
	
     	
		finish() ;
	}

	@Override
	public void postDelete(Boolean success) {
		
		finish() ;
	}

}
