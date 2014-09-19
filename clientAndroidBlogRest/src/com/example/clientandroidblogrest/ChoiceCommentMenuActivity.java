package com.example.clientandroidblogrest;

import com.example.clientandroidblogrest.resttool.ImplementRESTObject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;

import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class ChoiceCommentMenuActivity extends Activity implements ImplementRESTObject{

	private ListView lb ;
	private Context mContext ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_choice_comment_menu);
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
				tv_name.setText(mContext.getString(R.string.edit));
			
				}else
				{
				tv_name.setText(mContext.getString(R.string.delete));
				
					
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
				return 2;
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
					editComment() ;
				}else if(arg2 == 1)
				{
					deleteComment() ;
				}
				
				
			}
		});
	}
	
	public void editComment()
	{
		BlogApplication appA = (BlogApplication) mContext.getApplicationContext() ;	
		Intent intent = new Intent(mContext , EditCommentActivity.class) ;
		Bundle b = new Bundle() ;
		Log.v("test" ,Integer.toString(appA.getCommentSelect().getId() ) ) ;
		b.putInt("idcomment", appA.getCommentSelect().getId() ) ;
	    intent.putExtras(b) ;
		startActivity(intent) ;
	}
	public void deleteComment()
	{
	    BlogApplication appA = (BlogApplication) mContext.getApplicationContext() ;	
	    appA.getCommentSelect().deleteSecure(mContext, appA.getTokenKey()) ;
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_choice_comment_menu, menu);
		return true;
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
		this.finish() ;
	}

}
