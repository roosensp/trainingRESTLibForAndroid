package com.example.clientandroidrest.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.clientandroidrest.model.Categorie;
import com.example.clientandroidrest.model.Livre;
import com.example.clientandroidrest.view.CellLivreView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListLivreAdapter extends BaseAdapter{

	private Context  mContext ;



	private List<Livre> listLivre = new ArrayList<Livre>();
	
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listLivre.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		 return listLivre.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return  position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		
		CellLivreView cell = new CellLivreView(this.mContext, listLivre.get(position));
		
		return cell;
	}
	
	public Context getmContext() {
		return mContext;
	}

	public void setmContext(Context mContext) {
		this.mContext = mContext;
	}

	public List<Livre> getListLivre() {
		return listLivre;
	}

	public void setListLivre(List<Livre> listLivre) {
		this.listLivre = listLivre;
	}

}
