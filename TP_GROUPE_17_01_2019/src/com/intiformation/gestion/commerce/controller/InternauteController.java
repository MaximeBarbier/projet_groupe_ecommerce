package com.intiformation.gestion.commerce.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.intiformation.gestion.commerce.bean.Categorie;
import com.intiformation.gestion.commerce.bean.Client;
import com.intiformation.gestion.commerce.bean.Produit;
import com.intiformation.gestion.commerce.metier.IInternauteBoutique;

@Controller
public class InternauteController {

	// Recup de IInternauteBoutique
	@Autowired
	private IInternauteBoutique internauteBoutique;

	// ctor chargé pour injection spring
	public InternauteController(IInternauteBoutique internauteBoutique) {
	
		this.internauteBoutique = internauteBoutique;
	}
	
	/**
	 * affiche la liste des categories
	 * @param model
	 */
	
	@RequestMapping(path = "/listListe", method = RequestMethod.GET)
	public String afficherCat(Model model) {

		// Création de la liste des categories
		List<Categorie> listeCategories = Collections.emptyList();
		listeCategories = internauteBoutique.getListCategories();
		model.addAttribute("categorieAttribute", listeCategories);

		// Affichage de tous les produits présents dans la bdd
		List<Produit> produits = internauteBoutique.getListproduits();
		model.addAttribute("produitsAttribute", produits);

		model.addAttribute("KWAttribute", " ");
		
		
		return "internaute";

	}

	/**
	 * afficher les produits d'une catégorie
	 * 
	 * @param idcat
	 * @param model
	 */
	@RequestMapping(value = "/afficherProduitParCategorie", method = RequestMethod.GET)
	public String afficherCatParId(@RequestParam(required = true, value = "idcat") Long idcat, Model model) {

		Categorie cat = internauteBoutique.getCategorie(idcat);
		List<Produit> listeProduits = Collections.emptyList();
		listeProduits = cat.getProduits();
		model.addAttribute("listProduitAttribute", listeProduits);

		List<Categorie> listeCategories = Collections.emptyList();
		listeCategories = internauteBoutique.getListCategories();
		model.addAttribute("categorieAttribute", listeCategories);

		Produit produit = new Produit();

		return "afficherProduitParCategorie";
	}

	/**
	 * afficher les produits par mot-clé
	 * 
	 * @return
	 */
	@RequestMapping(value = "/afficherProdParMotCle", method = RequestMethod.GET)
	public String afficherProdByKeyWord(@RequestParam(required = true, value = "mc") String mc, Model model) {
		
		List<Produit> listeProdByKeyWord = Collections.emptyList();		
		listeProdByKeyWord = internauteBoutique.getProduitsParMotCle(mc);
		model.addAttribute("afficherProdParMotAttribute", listeProdByKeyWord);
		model.addAttribute("KWAttribute", mc);
		
		return "afficherProdParMotCle";

	}
	
	
	/**
	 * afficher les produits d'une catégorie
	 * @param idcat
	 * @param model
	 */
//	@RequestMapping(value="/afficherCategorieParId", method=RequestMethod.GET)
//	public String afficherCatParId(@RequestParam(required=true, value="idcat") Long idcat, Model model) {
//		
//		Categorie cat = iInternauteBoutique.getCategorie(idcat);
//		model.addAttribute("categoriesAttribute", cat);
//		
//		return "afficherCategorieParId";
//	}
	
	/**
	 * consulter les produits sélectionnés
	 */
//	@RequestMapping(value="/afficherProdSelectionnes", method=RequestMethod.GET)
//	public String afficherProdSelect(@RequestParam(required=true, value="idProd") Long idProd,Model model) {
//		
//		List<Produit> listeProdSelectionnes = Collections.emptyList();	
//		
//		listeProdSelectionnes = iInternauteBoutique.getProduitsSelectionnes();
//		model.addAttribute("prodSelecAttribute", listeProdSelectionnes);
//		
//		return "afficherProdSelectionnes";
//	}
	
	/**
	 * afficher les produits par mot-clé
	 * @return
	 */
//	@RequestMapping(value="/afficherProdParMotClé", method=RequestMethod.GET)
//	public String afficherProdByKeyWord(@RequestParam(required=true, value="mc") String mc, Model model) {
//		
//		List<Produit> listeProdByKeyWord = Collections.emptyList();
//		listeProdByKeyWord = iInternauteBoutique.getProduitsParMotCle(mc);
//		model.addAttribute("afficherProdParMotClé", listeProdByKeyWord);
//		
//		return "afficherProdParMotClé";
//		
//	}
	
	/**
	 * ajouter un produit au panier avec la quantite
	 */
//	@RequestMapping(value="/ajoutProdEtQuantite", method=RequestMethod.POST)
//	public String ajouterProdWithQuantite(@ModelAttribute("prod") Produit prod){
//		
//		iInternauteBoutique.saveCommande(p, c);
//		
//	}
//	
	/**
	 * supprimer un produit du panier
	 */
//	@RequestMapping(value="/deleteProdPanier", method=RequestMethod.GET)
//	public String supprimerProdPanier(@RequestParam(required=true, value="idprod") Long idprod, Model model){
//		
//		iInternauteBoutique.deleteProdPanier(idprod);
//		model.addAttribute("deleteProdPanierAttribute", iInternauteBoutique.getListproduits());
//		
//		return ""; // A VOIR
//	}
//	
	/**
	 * enregistrer le client et la commande des produits du panier
	 */
//	@RequestMapping(value="/enregistrerCommandeEtClient", method=RequestMethod.GET)
//	public String enregistrerCC(@RequestParam Produit p, Client c, Model model){
//		iInternauteBoutique.saveCommande(p, c);
//		model.addAttribute("", iInternauteBoutique.saveCommande(p, c));
//		
//		return "enregistrerCommandeEtClient"; // A VOIR
//		
//	}
	
}
