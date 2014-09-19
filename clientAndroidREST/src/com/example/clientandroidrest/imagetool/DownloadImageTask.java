package com.example.clientandroidrest.imagetool;

import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap>{

	 ImageView bmImage;
	 String url ;

	    public DownloadImageTask(ImageView bmImage , String url ) {
	        this.bmImage = bmImage;
	        this.url = url ;
	    }

	    protected Bitmap doInBackground(String... urls) {
	        String urldisplay =  this.url ;
	        Bitmap mIcon11 = null;
	        try {
	            InputStream in = new java.net.URL(urldisplay).openStream();
	            mIcon11 = BitmapFactory.decodeStream(in);
	        } catch (Exception e) {
	            Log.e("test", e.getMessage());
	            e.printStackTrace();
	        }
	        return mIcon11;
	    }

	    protected void onPostExecute(Bitmap result) {
	        bmImage.setImageBitmap(result);
	    }
	
}
