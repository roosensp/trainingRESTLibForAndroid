package com.example.clientandroidrest ;

import com.example.clientandroidrest.model.Categorie;
import com.example.clientandroidrest.model.Livre;

import android.app.Application;

public class ClientAndroidRESTApp extends Application {
	
	private static  Categorie categorieSelect ;
	private static Livre livreSelect ;

	public  Categorie getCategorieSelect() {
		return categorieSelect;
	}

	public  void setCategorieSelect(Categorie categorieSelect) {
		ClientAndroidRESTApp.categorieSelect = categorieSelect;
	}

	public  Livre getLivreSelect() {
		return livreSelect;
	}

	public  void setLivreSelect(Livre livreSelect) {
		ClientAndroidRESTApp.livreSelect = livreSelect;
	}

}
