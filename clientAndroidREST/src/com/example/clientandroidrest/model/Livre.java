package com.example.clientandroidrest.model;

import com.example.restfull.tools.NameResourceREST;
import com.example.restfull.tools.ObjectRest;

@NameResourceREST(value="livre")
public class Livre  extends ObjectRest{
 

  private String titre ;
  private String resume ;
  private String isbn ;
  private Categorie categorie ;
  private int quantite ;
  private String photo ;

  private String publishedDate ; 
  private Auteur ecrit_par ;
  
  
   public int getId() {
		return  super.id;
	}
	public void setId(int id) {
		super.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	  public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
  
	
}
