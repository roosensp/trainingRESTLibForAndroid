package com.example.clientandroidblogrest;

import com.example.clientandroidblogrest.model.Comment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CellCommentView  extends LinearLayout{

	
	public CellCommentView(Context c , Comment comment) {
		// TODO Auto-generated constructor stub
		super(c) ;
		
		Integer taillePhoto = 90 ;
		int width = 700;
		LinearLayout ll = new LinearLayout(c);
		ll.setOrientation(VERTICAL);
		ll.setPadding(10, 0, 0, 0) ;
		
		TextView cellComment = new TextView(c);
		cellComment.setWidth( width- taillePhoto );
		cellComment.setMaxHeight(150);
		cellComment.setText( comment.getComment());
		cellComment.setTextSize(17) ;
		cellComment.setTypeface(null,Typeface.BOLD);
		cellComment.setTextColor(Color.BLACK);
		ll.addView(cellComment);
		
		TextView nameUserComment = new TextView(c);
		if(comment.getUser()!=null)
		{
			nameUserComment.setWidth(width-taillePhoto);
			nameUserComment.setMaxHeight(150);
			nameUserComment.setText( "By "+comment.getUser().getUsername());
			nameUserComment.setTextColor( Color.BLACK);
		}
		ll.addView(nameUserComment) ;
		
		this.addView(ll) ;
	}
	
}
