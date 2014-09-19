package com.example.clientandroidrest.activity;


import java.util.ArrayList;
import java.util.List;
import com.example.clientandroidrest.ClientAndroidRESTApp;
import com.example.clientandroidrest.R;
import com.example.clientandroidrest.adapter.ListCateAdapter;
import com.example.clientandroidrest.model.Categorie;
import com.example.restfull.tools.ImplementRESTObject;
import com.exmple.clientandroidrest.datarest.AskCategorieObjects;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;





public class CategoriesActivity extends Activity  implements ImplementRESTObject{

	private List<Categorie> list = new ArrayList<Categorie>()  ; 
	private ListView lv;
	private ListCateAdapter listAdpater ;
	private Button btAddCath ;
	private Context mContext ;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_categories);
		 mContext = this ;
		 this.lv = (ListView) findViewById(R.id.lv_categorie);
         this.btAddCath = (Button)findViewById(R.id.bt_add) ;
         btAddCath.setOnClickListener( new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				creationNewCat();
			}
		}) ;
         lv.setOnItemClickListener( new OnItemClickListener()
 		{

 			@Override
 			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
 			{
 				
				showDetailCathegorie( list.get(arg2));
 			}});
	   
         askCats() ;
	}
	
	private void askCats()
	{
		  AskCategorieObjects askCategorie = new AskCategorieObjects(this , Categorie.class) ;
			 askCategorie.getObjects() ;	
	}
	
	@Override
	public void onResume ()
	{
		super.onResume();
		askCats() ;
	}
	
	private void showDetailCathegorie( Categorie c )
	{
		   Intent intent = new Intent(mContext ,CategorieDetailActivity.class ) ;
			ClientAndroidRESTApp clientApp = (ClientAndroidRESTApp) mContext.getApplicationContext();
			clientApp.setCategorieSelect(c);
		    startActivity(intent);	
	}
	
	private void creationNewCat()
	{
		Categorie c = new Categorie() ;
		c.create( this) ;
		
	}
	
	
	
	// reception DATA
	public void receiveData()
	{
		 this.listAdpater = new ListCateAdapter() ;
		 this.lv.setAdapter(this.listAdpater) ;
		 listAdpater.setmContext(this) ;
		 listAdpater.setListCategorie(list);
		 lv.setAdapter(  listAdpater); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_categories, menu);
		return true;
	}
	
	public List<Categorie> getList() {
		return list;
	}

	public void setList(List<Categorie> list) {
		this.list = list;
	}

	public ListView getLv() {
		return lv;
	}

	public void setLv(ListView lv) {
		this.lv = lv;
	}

	public ListCateAdapter getListAdpater() {
		return listAdpater;
	}

	public void setListAdpater(ListCateAdapter listAdpater) {
		this.listAdpater = listAdpater;
	}

	@Override
	public void postCreate(int idObject) {
		// TODO Auto-generated method stub
		Categorie c = new Categorie(idObject, "", "") ;
		showDetailCathegorie(  c );
		
	}

	@Override
	public void postUpdate(Boolean success) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postDelete(Boolean success) {
		// TODO Auto-generated method stub
		
	}
	

//	@Override
//	public void receiveId(int id) {
//		// TODO Auto-generated method stub
//		Log.v("test" , "RECU ") ;
//		Categorie c = new Categorie(id, "", "") ;
//		showDetailCathegorie(  c );
//	}


}
