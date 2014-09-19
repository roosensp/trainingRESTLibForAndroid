package com.example.clientandroidrest.view;

import java.io.BufferedOutputStream;
import java.io.InputStream;

import com.example.clientandroidrest.R;

import com.example.clientandroidrest.imagetool.DownloadImageTask;
import com.example.clientandroidrest.model.Livre;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class CellLivreView extends LinearLayout
{
	private Activity ParentActivity;
	final TextView cellComment;
	final TextView cellName ;

	

	final ImageView logoLivre ;
	
	public CellLivreView(Context context , Livre livre)
	{
		super(context);
		this.ParentActivity = (Activity)context;
		cellComment = new TextView(context);
		cellName =  new TextView(context);
	
		logoLivre =    new ImageView(context);
		int width = 700;
	
		
//		try{
//		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//		Display display = wm.getDefaultDisplay();
////		Point size = new Point();
////		display.getSize(size);
//		 width = display.getWidth();
//		 height = display.getHeight();
//		}catch(Exception e)
//		{
//			Log.e("test" , e.getMessage());
//		}
//	
		LinearLayout ll = new LinearLayout(context);
		ll.setOrientation(VERTICAL);
		ll.setPadding(10, 0, 0, 0) ;
		Log.v("test" , "taile ecran "+ width) ;
		Integer taillePhoto = 90 ;
		
		
		cellName.setWidth( width- taillePhoto );
		cellName.setMaxHeight(150);
		cellName.setText( livre.getTitre());
		cellName.setTextSize(17) ;
		cellName.setTypeface(null,Typeface.BOLD);
		cellName.setTextColor(Color.BLACK);
		

		cellComment.setWidth(width-taillePhoto);
		cellComment.setMaxHeight(150);
		cellComment.setText( livre.getResume());
		cellComment.setTextColor( Color.BLACK);
		 
		
		
		
		ll.addView(cellName);
		ll.addView(cellComment);
		
		logoLivre.setImageResource(R.drawable.interogation);
		
		if(livre.getPhoto() != "")
		{
			DownloadImageTask download =   new DownloadImageTask(logoLivre , livre.getPhoto()) ;
			download.execute("");	
		}
		
		

	
		logoLivre.setScaleType( ImageView.ScaleType.FIT_XY) ;
		logoLivre.setMaxHeight(taillePhoto);
		logoLivre.setMaxWidth(taillePhoto);
		logoLivre.setAdjustViewBounds(true);
		logoLivre.setPadding(5,5,0, 5); 
		this.addView(logoLivre); 
		this.addView(ll);  
		
		
		
	}  
	
	
}  
	
	
