package com.example.clientandroidblogrest;

import com.example.clientandroidblogrest.activity.ArticleDetailActivity;
import com.example.clientandroidblogrest.model.Article;
import com.example.clientandroidblogrest.resttool.ImplementRESTObject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ChoiceValidateArticle extends Activity  implements ImplementRESTObject{

	private ListView lb ;
	private Context mContext ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_choice_validate_article);
	
		mContext = this ;
		lb = (ListView) findViewById(R.id.lv_option) ;
		
		
		lb.setAdapter( new ListAdapter() {
			
			@Override
			public void unregisterDataSetObserver(DataSetObserver observer) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void registerDataSetObserver(DataSetObserver observer) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean hasStableIds() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public int getViewTypeCount() {
				// TODO Auto-generated method stub
				return 1;
			}
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				LinearLayout ll = new LinearLayout(mContext);
				ll.setPadding(5, 5, 5, 5) ;
				
				TextView tv_name = new TextView(mContext) ;
				tv_name.setTextSize(20);
				tv_name.setTextColor(Color.BLACK );
				
				if(position == 0)
				{
					
					tv_name.setText(mContext.getString(R.string.valid));
					
				
				}else if(position ==1)
				{
					
					tv_name.setText(mContext.getString(R.string.delete));
				
					
				}else
				{
					tv_name.setText(mContext.getString(R.string.see_detail));
				
					
				}
				ll.addView(tv_name) ;
				return ll;
				
				
			}
			
			@Override
			public int getItemViewType(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
			
				return null;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 3;
			}
			
			@Override
			public boolean isEnabled(int position) {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean areAllItemsEnabled() {
				// TODO Auto-generated method stub
				return true;
			}
		});
		lb.setOnItemClickListener( new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				if(arg2 == 0)
				{
					validArticle() ;
				}else if(arg2 == 1)
				{
					deleteArticle() ;
				}else if(arg2 == 2)
				{
					seeDetails() ;
				}
				
				
			}
		});
	
	}
	
	public void seeDetails()
	{
		 Intent intent = new Intent( this , ArticleDetailActivity.class ) ;
		
		 startActivity(intent);
	}
	public void validArticle() 
	{
		BlogApplication appA = (BlogApplication) mContext.getApplicationContext() ;	
		Article a = appA.getArticleSelect() ;
		a.setValide(true);
		a.updateSecure(this, appA.getTokenKey()) ;
		
	}
	public void deleteArticle()
	{
	    BlogApplication appA = (BlogApplication) mContext.getApplicationContext() ;	
	    appA.getArticleSelect().deleteSecure(mContext, appA.getTokenKey()) ;
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.activity_choice_validate_article, menu);
		return true;
	}

	@Override
	public void postCreate(String response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postUpdate(Boolean success) {
		// TODO Auto-generated method stub
		this.finish() ;
	}

	@Override
	public void postDelete(Boolean success) {
		// TODO Auto-generated method stub
		Log.v("test" , "qsdqs" );
		this.finish() ;
	}

}
