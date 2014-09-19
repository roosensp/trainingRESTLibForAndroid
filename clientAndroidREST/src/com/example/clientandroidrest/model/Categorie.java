package com.example.clientandroidrest.model;

import android.view.ViewDebug.FlagToString;

import com.example.restfull.tools.NameResourceREST;
import com.example.restfull.tools.ObjectRest;

@NameResourceREST(value="categorie")
public class Categorie extends ObjectRest{

    private String nom ;
	private String description ;
	
	
	public Categorie() {
		// TODO Auto-generated constructor stub
	}

	public Categorie(int id , String nom , String description) {
		
		
		super.id = id  ;
		this.nom = nom ;
		this.description = description ;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setName(String name) {
		this.nom = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
