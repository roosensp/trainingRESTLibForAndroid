package com.example.clientandroidrest.adapter;

import com.example.clientandroidrest.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
	
    private Context mContext;
    private  String[] menuValues ;
    private Integer[] mThumbIds;
    
    public ImageAdapter(Context c) {
        mContext = c;
        menuValues =mContext.getResources().getStringArray(R.array.menu);
        mThumbIds = new Integer[]{
                R.drawable.cat_pict, R.drawable.menu_livre,
        };
    }
    public int getCount() {
        return mThumbIds.length;
    }
    public Object getItem(int position) {
        return null;
    }
    public long getItemId(int position) {
        return 0;
    }
    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
    	LayoutInflater inflater = (LayoutInflater) mContext
    			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);   
    		View gridView;
    		if (convertView == null) {
    			gridView = new View(mContext);
    			// get layout from mobile.xml
    			gridView = inflater.inflate(R.layout.layout_menu_model, null);
    			// set value into textview
    			TextView textView = (TextView) gridView
    					.findViewById(R.id.grid_item_label);
    			textView.setText(menuValues[position]);
    			// set image based on selected text
    			ImageView imageView = (ImageView) gridView
    					.findViewById(R.id.grid_item_image);
    				imageView.setImageResource(mThumbIds[position]);
    		} else {
    			gridView = (View) convertView;
    		}
    		return gridView;
    } 
}