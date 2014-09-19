package com.example.clientandroidblogrest.resttool;

import java.util.List;

public interface ReceiveObjectsRestInterface {
	
	void receiveObjects( List<Object> listObject , String nameObjet );
	void receiveResponse( String response , String nameObjet);
}
