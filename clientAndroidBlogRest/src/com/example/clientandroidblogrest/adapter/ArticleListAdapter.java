package com.example.clientandroidblogrest.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.clientandroidblogrest.CellArticleView;
import com.example.clientandroidblogrest.model.Article;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ArticleListAdapter  extends BaseAdapter{
	private Context mContext ;
	
 
	private List<Article> listLivre = new ArrayList<Article>();
	
	@Override
	public int getCount() {
		return listLivre.size();
	}

	@Override
	public Object getItem(int position) {
		return listLivre.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
	
		 CellArticleView cell = new CellArticleView(this.mContext, listLivre.get(position));
		return cell;
		
	}
	public Context getmContext() {
		return mContext;
	}

	public void setmContext(Context mContext) {
		this.mContext = mContext;
	}

	public List<Article> getListLivre() {
		return listLivre;
	}

	public void setListLivre(List<Article> listLivre) {
		this.listLivre = listLivre;
	}
	
}
