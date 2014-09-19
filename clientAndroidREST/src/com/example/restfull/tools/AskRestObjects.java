package com.example.restfull.tools;

import java.util.List;

import com.example.clientandroidrest.R;
import com.example.clientandroidrest.model.Categorie;


import android.content.Context;
import android.util.Log;

public class AskRestObjects  implements ReceiveObjectsRestInterface{

	private String nameObject ;
	private Context mContext ;
	private Class objectSeach ;
	
	
	public AskRestObjects(Context c )
	{
	this.mContext = c ;	
	}
	
	public AskRestObjects(Context context,  String nameObject , Class objet) {
		this.nameObject = nameObject ;
		this.mContext = context  ;
		this.objectSeach = objet ;
	}
	public AskRestObjects(Context context,  Class objet) {
		
		this.mContext = context  ;
		this.objectSeach = objet ;
		NameResourceREST resourceNameAnnotation = (NameResourceREST) objet.getAnnotation(NameResourceREST.class);
		String nameResource = resourceNameAnnotation.value() ;
		this.nameObject = nameResource ;
	}
	
	public void getObjects()
	{
		RequestServerRest requestServer = new RequestServerRest(  "GET" , this.nameObject , this , mContext.getString(R.string.urlconnectionrest), this.objectSeach);
	    requestServer.execute("") ;
	}
	
	public void getObjectsByOtherObject( Class classChercher ,  Class critere , Integer idCritere)
	{
		this.objectSeach =  classChercher ;
		Log.v("test" , "in getObjectsByOtherObject") ;
		NameResourceREST objetChercher = (NameResourceREST) classChercher.getAnnotation(NameResourceREST.class);	
		NameResourceREST objetCriter = (NameResourceREST) critere.getAnnotation(NameResourceREST.class);
		String pathRecherche = objetChercher.value().toString()+"/" + objetCriter.value().toString()+"/"+Integer.toString(idCritere) ;
		Log.v("test" , "in getObjectsByOtherObject path "+pathRecherche) ;
		RequestServerRest requestServer = new RequestServerRest(  "GET" , pathRecherche , this , this.mContext.getString(R.string.urlconnectionrest), this.objectSeach);
	    requestServer.execute("") ;
	}
	
	public void getObjectsByPage()
	{
		
	}

	@Override
	public void receiveObjects(List<Object> listObject, String nameObjet) {
		// TODO Auto-generated method stub
	
		
	}
	protected String getNameObject() {
		return nameObject;
	}

	protected void setNameObject(String nameObject) {
		this.nameObject = nameObject;
	}

	protected Context getmContext() {
		return mContext;
	}

	protected void setmContext(Context mContext) {
		this.mContext = mContext;
	}
}
