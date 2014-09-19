package com.example.clientandroidrest.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.clientandroidrest.activity.CategoriesActivity;
import com.example.clientandroidrest.model.Categorie;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListCateAdapter extends BaseAdapter{
	
private Context  mContext ;


private List<Categorie> listCategorie;


public ListCateAdapter() {
	// TODO Auto-generated constructor stub
	listCategorie = new ArrayList<Categorie>() ;
}

@Override
public int getCount() {
	// TODO Auto-generated method stub
	return listCategorie.size();
}

@Override
public Object getItem(int position) {
	// TODO Auto-generated method stub
	return listCategorie.get(position);
}

@Override
public long getItemId(int position) {
	// TODO Auto-generated method stub
	return position;
}

@Override
public View getView(final int position, View convertView, ViewGroup parent) {
	// TODO Auto-generated method stub
	LinearLayout ll = new LinearLayout(this.mContext);

	TextView tv_name = new TextView(this.mContext) ;
	tv_name.setText( Integer.toString(listCategorie.get(position).getId())+ " - "+ listCategorie.get(position).getNom());
	

	ll.addView(tv_name) ;
	return ll;
}


public Context getmContext() {
	return mContext;
}

public void setmContext(Context mContext) {
	this.mContext = mContext;
}

public List<Categorie> getListCategorie() {
	return listCategorie;
}

public void setListCategorie(List<Categorie> listCategorie) {
	this.listCategorie = listCategorie;
}

}