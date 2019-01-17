package com.intiformation.gestion.commerce.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.intiformation.metier.IInternauteBoutique;
import com.intiformation.modele.Categorie;

@Controller
@RequestMapping("/guest")
public class InternauteController {

	// Recup de IInternauteBoutique
	private IInternauteBoutique iInternauteBoutique;

	// ctor chargé pour injection spring
	public InternauteController(IInternauteBoutique iInternauteBoutique) {
		super();
		this.iInternauteBoutique = iInternauteBoutique;
	}
	
	/**
	 * affiche la liste des categories
	 * @param model
	 */
	@RequestMapping(value="/afficherCategories", method=RequestMethod.GET)
	public String afficherCat(Model model) {
		
		// Création de la liste des categories 
		List<Categorie> listeCategories = Collections.emptyList();		
		listeCategories = dao.listCategories();
		model.addAttribute("categoriesAttribute", listeCategories);
		
	}
	
	/**
	 * afficher les produits d'une catégorie
	 * @param idcat
	 * @param model
	 */
	@RequestMapping(value="/afficherCategorieParId", method=RequestMethod.GET)
	public String afficherCatParId(@RequestParam(required=true, value="idcat") Long idcat, Model model) {
		
		iInternauteBoutique.getCategorie(idcat);
		model.addAttribute("categoriesAttribute", );
	}
	
	/**
	 * consulter les produits sélectionnés
	 */
	public String afficherProdSelect() {
		
	}
	
	/**
	 * afficher les produits par mot-clé
	 * @return
	 */
	public String afficherProdByKeyWord() {
		
	}
	
	/**
	 * ajouter un produit au panier avec la quantite
	 */
	public String ajouterProdWithQuantite{
		
	}
	
	/**
	 * supprimer un produit du panier
	 */
	public String supprimerProdPanier{
		
	}
	
	/**
	 * enregistrer le client et la commande des produits du panier
	 */
	public String enregistrerCC{
		
	}
	
}
