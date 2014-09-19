package com.example.clientandroidblogrest.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.clientandroidblogrest.CellCommentView;
import com.example.clientandroidblogrest.model.Comment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CommentListAdapter extends BaseAdapter {

	private Context mContext ;
	
	private List<Comment>listComment = new ArrayList<Comment>() ;
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listComment.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listComment.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
	   CellCommentView cell = new CellCommentView(this.mContext, this.listComment.get(position)) ;
	   return cell ;
	}
	public Context getmContext() {
		return mContext;
	}

	public void setmContext(Context mContext) {
		this.mContext = mContext;
	}

	public List<Comment> getListComment() {
		return listComment;
	}

	public void setListComment(List<Comment> listComment) {
		this.listComment = listComment;
	}



}
