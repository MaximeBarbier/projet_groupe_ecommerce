package com.intiformation.gestion.commerce.dao;

import java.util.List;

import com.intiformation.gestion.commerce.bean.Categorie;
import com.intiformation.gestion.commerce.bean.Client;
import com.intiformation.gestion.commerce.bean.Commande;
import com.intiformation.gestion.commerce.bean.Panier;
import com.intiformation.gestion.commerce.bean.Produit;
import com.intiformation.gestion.commerce.bean.Role;
import com.intiformation.gestion.commerce.bean.User;

public interface IBoutiqueDAO {
	
	public Long ajouterCategorie(Categorie c);
	
	public List<Categorie> listCategories();
	
	public List<String> listNomCategorie();
	
	public Categorie getCategorieByName(String name);
	
	public Categorie getCategorie(Long idCat);
	
	public void supprimerCategorie(Long idcat);
	
	public void modifierCategorie(Categorie c);
	
	public Long ajouterProduit(Produit p, Long idCat);
	
	public List<Produit> listproduits();
	
	public List<Produit> produitsParMotCle(String mc);
	
	public List<Produit> produitsParCategorie(Long idCat);
	
	public List<Produit> produitsSelectionnes();
	
	public Produit getProduit(Long idP);
	
	public void supprimerProduit(Long idP);
	
	public void modifierProduit(Produit p);
	
	public void ajouterUser(User u);
	
	public void attribuerRole(Role r, Long userID);
	
	public Commande enregistrerCommande(Panier p, Client c);
	

}
