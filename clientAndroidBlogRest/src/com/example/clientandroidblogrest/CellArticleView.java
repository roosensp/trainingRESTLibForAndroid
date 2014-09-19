package com.example.clientandroidblogrest;
import com.example.clientandroidblogrest.model.Article;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class CellArticleView  extends LinearLayout{

	private Activity parentActivity;
//	final TextView cellComment;
//	final TextView cellName ;
//	
//	final ImageView logoCat;
	

	
	
	public CellArticleView(Context c , Article a )
	{
		super(c) ;

		TextView cellComment = new TextView(c);
		TextView cellName =  new TextView(c);
		int width = 700;
		LinearLayout ll = new LinearLayout(c);
		ll.setOrientation(VERTICAL);
		ll.setPadding(10, 0, 0, 0) ;

		Integer taillePhoto = 90 ;
	
		cellName.setWidth( width- taillePhoto );
		cellName.setMaxHeight(150);
		cellName.setText( a.getTitle());
		cellName.setTextSize(17) ;
		cellName.setTypeface(null,Typeface.BOLD);
		cellName.setTextColor(Color.BLACK);

		
		if(a.getUser()!=null)
		{
			cellComment.setWidth(width-taillePhoto);
			cellComment.setMaxHeight(150);
			cellComment.setText( "By "+a.getUser().getUsername());
			cellComment.setTextColor( Color.BLACK);
		}
	
	
		ll.addView(cellName);
		ll.addView(cellComment);
		ImageView logoCat = new ImageView(c) ;
		logoCat.setImageResource(R.drawable.interogation);
//		
////		if(livre.getPhoto() != "")
////		{
////			DownloadImageTask download =   new DownloadImageTask(logoLivre , livre.getPhoto()) ;
////			download.execute("");	
////		}
//		
//		
//
//	
		 logoCat.setScaleType( ImageView.ScaleType.FIT_XY) ;
		 logoCat.setMaxHeight(taillePhoto);
		logoCat.setMaxWidth(taillePhoto);
		logoCat.setAdjustViewBounds(true);
		logoCat.setPadding(5,5,0, 5); 
		this.addView(logoCat); 
		this.addView(ll);  
		
	}
}
