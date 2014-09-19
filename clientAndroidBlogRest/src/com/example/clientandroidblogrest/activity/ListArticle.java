package com.example.clientandroidblogrest.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.clientandroidblogrest.BlogApplication;
import com.example.clientandroidblogrest.ChoiceValidateArticle;
import com.example.clientandroidblogrest.EditArticle;
import com.example.clientandroidblogrest.R;
import com.example.clientandroidblogrest.SatistiqueActivity;
import com.example.clientandroidblogrest.adapter.ArticleListAdapter;
import com.example.clientandroidblogrest.getdata.GetArticlesREST;
import com.example.clientandroidblogrest.model.Article;
import com.example.clientandroidblogrest.resttool.ImplementRESTObject;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ListArticle extends Activity implements ImplementRESTObject{

	private ArrayList<Article> list = new ArrayList<Article>() ;
	private ListView lv;
	private ArticleListAdapter listAdpater ;
	private Button bt_back ;
	private Button bt_next ;
	private Button bt_listToValid ;
	private Button bt_addArticle ;
	private Button bt_satistique ;
	private LinearLayout llNavigationAction ;
	private ImageView  imageLogin ;
	private Boolean validArticle = false ;
	private TextView title_acitvity ;
	private GetArticlesREST getArticles = new GetArticlesREST(this, Article.class) ;
	private int page = 0 ;
	private int nbElementByPage = 10 ;
	 BlogApplication clientApp ;
	
	
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_article);
		this.lv = (ListView) findViewById(R.id.lv_article);
		this.bt_back = (Button) findViewById(R.id.bt_back) ;
		 this.bt_back.setEnabled(false );
		this.bt_next = (Button) findViewById(R.id.bt_next) ;
		this.bt_next.setEnabled(false) ;
		this.bt_addArticle = (Button) findViewById(R.id.bt_add_article) ;
		this.bt_listToValid = (Button)findViewById(R.id.bt_list_tovalid) ;
		this.bt_satistique = (Button)findViewById(R.id.bt_satistique) ;
		this.llNavigationAction = (LinearLayout)findViewById(R.id.llactionnavigation) ;
		this.imageLogin = (ImageView) findViewById(R.id.image_login) ;
		this.title_acitvity = (TextView)findViewById(R.id.tv_content) ;
		clientApp = (BlogApplication) this.getApplicationContext();
		this.listAdpater  = new ArticleListAdapter() ;
		this.listAdpater.setmContext(this) ;
		this.listAdpater.setListLivre(this.list) ;
		gestionVisibility();
		this.loadData() ;
	  
	    this.lv.setOnItemClickListener(  new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				selectArticle( arg2) ;
				
			}
		});
	    
	    bt_back.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pageBack();
			}
		}) ;
	    bt_next.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pageNext() ;
			}
		}) ;
	    
	    bt_satistique.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				goToStatistique() ;
			}
		}) ;
	    bt_listToValid.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switchToValidArticle() ;
			}
		}) ;
	    imageLogin.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				goLogin() ;
			}
		}) ;
	    bt_addArticle.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				addArticle() ;
			}
		}) ;
	    
	}
	
	@Override
	public void onResume ()
	{
		super.onResume();
		gestionVisibility();
		this.loadData();
		Log.v("test" , "RESUME") ;
		  
	}
	
	private void goToStatistique() 
	{
		Intent intent = new Intent( this , SatistiqueActivity.class ) ;
		startActivity(intent);	
	}
	private void switchToValidArticle()
	{
		validArticle = !validArticle ;
		this.page = 0 ;
		if(validArticle)
		{
		   this.bt_listToValid.setText( this.getString(R.string.listtonovalid)) ;
		   this.title_acitvity.setText(  this.getString(R.string.title_list_article) + " "+ this.getString(R.string.listtovalid)) ;
		}else
		{
		 this.bt_listToValid.setText(  this.getString(R.string.listtovalid)) ;
		 this.title_acitvity.setText(this.getString(R.string.listtonovalid)) ;
		}
		this.loadData() ;

		
	}
	
	private void gestionVisibility()
	{
		this.bt_listToValid.setVisibility(8) ;
		this.bt_satistique.setVisibility(8) ;
		if(clientApp.getTokenKey() == null)
		{
			this.bt_addArticle.setVisibility(8) ;
			this.llNavigationAction.setVisibility(8);
		}else
		{
			this.llNavigationAction.setVisibility(1);
			this.bt_addArticle.setVisibility(1) ;
			if(clientApp.getUtilisateurActuel() != null)
			{
				if(clientApp.getUtilisateurActuel().getRole().getName().equals("admin")  )
				{
				this.bt_listToValid.setVisibility( 1) ;
				this.bt_satistique.setVisibility(1) ;
				}
			}
		}
		
		
	}
	
	private void addArticle()
	{
       clientApp.setArticleSelect(new Article()) ;
		Intent intent = new Intent( this , EditArticle.class ) ;
		startActivity(intent);	
	}
	
	public void selectArticle(int position)
	{
		if(this.validArticle)
		{
			 Intent intent = new Intent( this , ChoiceValidateArticle.class ) ;
			 clientApp.setArticleSelect(this.list.get(position)) ;
			 startActivity(intent);
		}else
		{
		
		 Intent intent = new Intent( this , ArticleDetailActivity.class ) ;
		 clientApp.setArticleSelect(this.list.get(position)) ;
		 startActivity(intent);
		}

	}
	public void pageBack()
	{
		if(this.page > 0 )
		{
			this.page += -1 ;
			this.loadData() ;
		}
	}
	public void pageNext()
	{
		
		if(this.list.size() == this.nbElementByPage)
		{
			this.page ++ ;
			this.loadData() ;
		}
	}
	
	public void goLogin()
	{
		Intent intent = new Intent( this , LoginActivity.class ) ;
		startActivity(intent);
	} 
	public void loadData()
	{
		if(this.validArticle)
		{
			this.getArticles.getObjectsSpecialRequest(Article.class, "notpublished/"+Integer.toString(page*nbElementByPage)+"/" +Integer.toString( (page*nbElementByPage)+nbElementByPage)+ "/token/"+clientApp.getTokenKey() , true) ;
		}else
		{
			 this.getArticles.getObjectsByPage( Integer.toString(page*nbElementByPage) ,Integer.toString( (page*nbElementByPage)+nbElementByPage)) ;
		}
		 
		    
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_list_article, menu);
		return true;
	}
	
	public void receiveData()
	{
		
		this.listAdpater  = new ArticleListAdapter() ;

		 
		 this.listAdpater.setmContext(this) ;
		 this.listAdpater.setListLivre(list) ;	
		 this.lv.setAdapter(this.listAdpater) ;
		 if(page == 0 )
		 {
			 this.bt_back.setEnabled(false );
		 }else
		 {
			 this.bt_back.setEnabled(true ); 
		 }
		 if(list.size() < nbElementByPage)
		 {
			 this.bt_next.setEnabled(false) ;
		 }else
		 {
			 this.bt_next.setEnabled(true) ; 
		 }
		 
		 this.lv.setAdapter(  listAdpater); 
	}

	public ArrayList<Article> getList() {
		return list;
	}  

	public void setList(ArrayList<Article> list) {
		this.list = list;
	}

	public ArticleListAdapter getListAdpater() {
		return listAdpater;
	}

	public void setListAdpater(ArticleListAdapter listAdpater) {
		this.listAdpater = listAdpater;
	}
	@Override
	public void postCreate(String response) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void postUpdate(Boolean success) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void postDelete(Boolean success) {
		// TODO Auto-generated method stub
		
	}
   
	
}
