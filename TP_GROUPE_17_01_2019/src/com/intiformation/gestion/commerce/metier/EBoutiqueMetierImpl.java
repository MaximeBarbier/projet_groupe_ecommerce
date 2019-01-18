package com.intiformation.gestion.commerce.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.gestion.commerce.bean.Categorie;
import com.intiformation.gestion.commerce.bean.Client;
import com.intiformation.gestion.commerce.bean.Commande;
import com.intiformation.gestion.commerce.bean.Panier;
import com.intiformation.gestion.commerce.bean.Produit;
import com.intiformation.gestion.commerce.bean.Role;
import com.intiformation.gestion.commerce.bean.User;
import com.intiformation.gestion.commerce.dao.IBoutiqueDAO;

@Service("serviceBean")
public class EBoutiqueMetierImpl implements IAdminCategoriesMetier{
	
	@Autowired
	private IBoutiqueDAO boutiqueDAO;
	

	public IBoutiqueDAO getBoutiqueDAO() {
		return boutiqueDAO;
	}

	public void setBoutiqueDAO(IBoutiqueDAO boutiqueDAO) {
		this.boutiqueDAO = boutiqueDAO;
	}

	@Override
	public void addProduit(Produit p, Long idCat) {
		
		boutiqueDAO.ajouterProduit(p,idCat);
	}

	@Override
	public void deleteProduit(Long idP) {
		boutiqueDAO.supprimerProduit(idP);
	}

	@Override
	public void editProduit(Produit p) {
		boutiqueDAO.modifierProduit(p);
	}
	
	@Override
	public List<Categorie> getListCategories() {
		List<Categorie> listeCat = boutiqueDAO.listCategories();
		return listeCat;
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		return boutiqueDAO.getCategorie(idCat);
	}

	@Override
	public List<Produit> getListproduits() {
		return boutiqueDAO.listproduits();
	}

	@Override
	public List<Produit> getProduitsParMotCle(String mc) {
		return boutiqueDAO.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> getProduitsParCategorie(Long idCat) {
		return boutiqueDAO.produitsParCategorie(idCat);
	}

	@Override
	public List<Produit> getProduitsSelectionnes() {
		return boutiqueDAO.produitsSelectionnes();
	}

	@Override
	public Produit getProduct(Long idP) {
		return boutiqueDAO.getProduit(idP);
	}

	@Override
	public Commande saveCommande(Panier p, Client c) {
		return boutiqueDAO.enregistrerCommande(p,c);
	}
	
	@Override
	public void addCategorie(Categorie c) {
		boutiqueDAO.ajouterCategorie(c);
	}

	@Override
	public void deleteCategorie(Long idcat) {
		boutiqueDAO.supprimerCategorie(idcat);
	}

	@Override
	public void editCategorie(Categorie c) {
		boutiqueDAO.modifierCategorie(c);
	}

	@Override
	public void addUser(User u) {
		boutiqueDAO.ajouterUser(u);
	}

	@Override
	public void setUserRole(Role r, Long userID) {
		boutiqueDAO.attribuerRole(r, userID);
	}

	@Override
	public void deleteProdPanier(Long idP) {
		boutiqueDAO.supprimerProduit(idP);
	}// A VOIR
}
