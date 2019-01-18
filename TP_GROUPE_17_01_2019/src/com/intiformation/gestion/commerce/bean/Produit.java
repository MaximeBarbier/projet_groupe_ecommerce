package com.intiformation.gestion.commerce.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity(name="produit")
@Table(name="produits")
public class Produit {
	/*__________________________________________les champs___________________________________________*/
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_produit")
	private Long idProduit; 
	@Column(name="designation")
	private String designation;
	@Column(name="description")
	private String description; 
	@Column(name="prix")
	private double prix;
	@Column(name="photo")
	private String photo;
	@Column(name="quantite")
	private int quantite; 
	@Column(name="selectionne")
	private boolean selectionne;
	
	@ManyToOne (cascade= CascadeType.ALL)
	@JoinColumn(name="categorie_id", referencedColumnName="id_categorie") 
	private Categorie categorie;
	/*_______________________________________les ctors_______________________________________________*/
	public Produit() {
		
	}

	public Produit(Long idProduit, String designation, String description, double prix, String photo, int quantite,
			boolean selectionne, Categorie categorie) {
		
		this.idProduit = idProduit;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.photo = photo;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.categorie = categorie;
	}

	public Produit(String designation, String description, double prix, String photo, int quantite, boolean selectionne,
			Categorie categorie) {
		
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.photo = photo;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.categorie = categorie;
	}
	/*__________________________________________Les encapsulations______________________________________*/
	
	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public boolean isSelectionne() {
		return selectionne;
	}

	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	} 
	
	
}
