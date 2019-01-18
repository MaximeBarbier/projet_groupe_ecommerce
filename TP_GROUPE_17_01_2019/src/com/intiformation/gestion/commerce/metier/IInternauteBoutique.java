package com.intiformation.gestion.commerce.metier;

import java.util.List;

import com.intiformation.gestion.commerce.bean.Categorie;
import com.intiformation.gestion.commerce.bean.Client;
import com.intiformation.gestion.commerce.bean.Commande;
import com.intiformation.gestion.commerce.bean.Panier;
import com.intiformation.gestion.commerce.bean.Produit;

public interface IInternauteBoutique {

	public List<Categorie> getListCategories();
	
	public Categorie getCategorie(Long idCat);
	
	public List<Produit> getListproduits();
	
	public List<Produit> getProduitsParMotCle(String mc);
	
	public List<Produit> getProduitsParCategorie(Long idCat);
	
	public List<Produit> getProduitsSelectionnes();
	
	public Produit getProduct(Long idP);
	
	public Commande saveCommande(Panier p, Client c);
	
	public void deleteProdPanier(Long idP);
	
}
