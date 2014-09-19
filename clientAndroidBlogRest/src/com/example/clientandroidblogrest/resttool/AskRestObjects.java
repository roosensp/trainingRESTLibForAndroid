package com.example.clientandroidblogrest.resttool;

import java.util.List;

import com.example.clientandroidblogrest.R;




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
	
	public void getObjectsByPage(String to , String from)
	{
		String request = this.nameObject+"/"+to+"/"+from ;
		RequestServerRest requestServer = new RequestServerRest(  "GET" , request, this , mContext.getString(R.string.urlconnectionrest), this.objectSeach);
	    requestServer.execute("") ;
	}
	
	public void getObjectsByOtherObject( Class classChercher ,  Class critere , Integer idCritere)
	{
		this.objectSeach =  classChercher ;
	
		NameResourceREST objetChercher = (NameResourceREST) classChercher.getAnnotation(NameResourceREST.class);	
		NameResourceREST objetCriter = (NameResourceREST) critere.getAnnotation(NameResourceREST.class);
		String pathRecherche = objetChercher.value().toString()+"/" + objetCriter.value().toString()+"/"+Integer.toString(idCritere) ;
		RequestServerRest requestServer = new RequestServerRest(  "GET" , pathRecherche , this , this.mContext.getString(R.string.urlconnectionrest), this.objectSeach);
	    requestServer.execute("") ;
	}
	public void getObjectsByOtherObjectAndSecure( Class classChercher ,  Class critere , Integer idCritere , String token)
	{
		this.objectSeach =  classChercher ;
	
		NameResourceREST objetChercher = (NameResourceREST) classChercher.getAnnotation(NameResourceREST.class);	
		NameResourceREST objetCriter = (NameResourceREST) critere.getAnnotation(NameResourceREST.class);
		String pathRecherche = objetChercher.value().toString()+"/" + objetCriter.value().toString()+"/"+Integer.toString(idCritere)+"/token/"+token ;
		RequestServerRest requestServer = new RequestServerRest(  "GET" , pathRecherche , this , this.mContext.getString(R.string.urlconnectionrest), this.objectSeach);
	    requestServer.execute("") ;
	}
	
	public void getObjectsSpecialRequest(Class classChercher , String url , Boolean responseIsArray )
	{
		this.objectSeach =  classChercher ;
		
		NameResourceREST objetChercher = (NameResourceREST) classChercher.getAnnotation(NameResourceREST.class);	
	//	NameResourceREST objetCriter = (NameResourceREST) critere.getAnnotation(NameResourceREST.class);
		String pathRecherche = objetChercher.value().toString()+"/" + url;
		RequestServerRest requestServer = new RequestServerRest(  "GET" , pathRecherche , this , this.mContext.getString(R.string.urlconnectionrest), this.objectSeach);
		if(!responseIsArray)
		{
			requestServer.setResponseIsArray(false) ;
		}
			
		requestServer.execute("") ;
	}
	public void getObjectsByPage()
	{
		
	}

	@Override
	public void receiveObjects(List<Object> listObject, String nameObjet) {
		// TODO Auto-generated method stub
	
		
	}
	
	public void receiveResponse( String response , String nameObjet) {
		
	
		
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
