package com.intiformation.gestion.commerce.bean;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "categorie")
@Table(name = "categories")
public class Categorie {
	
	
/*__________________________________________les champs___________________________________________*/
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="id_categorie")
	private Long idCategorie;
	@Column(name="nom_categorie")
	private String nomCategorie;
	@Column(name="description")
	private String description;
	
	@Column(name="photo")
	private String photo;

	@OneToMany(mappedBy = "categorie", cascade= CascadeType.ALL)
	private List<Produit> produits = new ArrayList<Produit>();
	
	/*_______________________________________les ctors_______________________________________________*/


	public Categorie() {
		
	}

	public Categorie(Long idCategorie, String nomCategorie, String description, String photo) {
	
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.description = description;
		this.photo = photo;
	}

	public Categorie(String nomCategorie, String description, String photo, List<Produit> produits) {
	
		this.nomCategorie = nomCategorie;
		this.description = description;
		this.photo = photo;
		this.produits = produits;
	}
	
	public Categorie(String nomCategorie, String description, String photo) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
		this.photo = photo;
	}

	/*__________________________________________Les encapsulations______________________________________*/
	
	
	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	
	
	

}
