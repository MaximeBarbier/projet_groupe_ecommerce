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

@Entity(name="ligneCommande")
@Table (name="ligneCommandes")
public class LigneCommande {
	/*__________________________________________les champs___________________________________________*/	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column(name="quantite")
	private int quantite; 
	@Column(name="prix")
	private double prix;
	
	
	@ManyToOne (cascade= CascadeType.ALL)
	@JoinColumn(name="produit_id", referencedColumnName="id_produit")  
	private Produit produit; 
	
	
	/*__________________________________________Les encapsulations______________________________________*/
	
	public LigneCommande() {
		
	}
	
	public LigneCommande(int quantite, int prix) {
		
		this.quantite = quantite;
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = produit.getPrix()*this.quantite;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	

}
