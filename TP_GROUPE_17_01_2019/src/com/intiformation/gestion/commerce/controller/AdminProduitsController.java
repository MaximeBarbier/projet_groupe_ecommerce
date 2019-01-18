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

import com.intiformation.gestion.commerce.metier.EBoutiqueMetierImpl;
import com.intiformation.gestion.commerce.metier.IAdminProduitMetier;
import com.intiformation.gestion.commerce.bean.Categorie;
import com.intiformation.gestion.commerce.bean.Produit;

@Controller
@RequestMapping("/produits")
public class AdminProduitsController {

	// Recup IAdminProduitMetier
	@Autowired
	private IAdminProduitMetier iAdminProduitMetier;

	// ctor chargé pour injection spring
	public AdminProduitsController(IAdminProduitMetier iAdminProduitMetier) {
		super();
		this.iAdminProduitMetier = iAdminProduitMetier;
	}
	
	/**
	 * Méthode pour afficher la liste des produits
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Model model) {
		
		// Création de la liste des produits 
		List<Produit> listeProduits = Collections.emptyList();		
		listeProduits = iAdminProduitMetier.getListproduits();
		model.addAttribute("produitsAttribute", listeProduits);
		
		// nom de la vue : index | résolution : WEB-INF/views/index.jsp
		return "index";
	}
	
	/**
	 * Méthode pour ajouter un produit dans une catégorie
	 * @param prod
	 * @param idCat
	 * @return
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveProd(@ModelAttribute("prod") Produit prod,
							@ModelAttribute("idcat") Long idCat) {
		
		iAdminProduitMetier.addProduit(prod, idCat);
		
		return "redirect:/index";
		
	}
	/**
	 * Méthode pour supprimer un produit par son id
	 * @param idProduit
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deleteProd", method=RequestMethod.GET)
	public String suppProd(@RequestParam(required=true, value="idProduit") Long idProduit, Model model) {
		
		//Categorie categorie = iAdminProduitsMetier.getProduit(idcat); Pas sûre d'en avoir besoin
		iAdminProduitMetier.deleteProduit(idProduit);
		model.addAttribute("produitsAttribute", iAdminProduitMetier.getListproduits());
				
		return "redirect:/index";
		
	}
	
	/**
	 * Méthode pour modifier un produit
	 * @param prod
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String editProd(@RequestParam(required=true, value="prod") Produit prod, Model model) {
		
		// Recup de la categorie par l'id
		iAdminProduitMetier.editProduit(prod);
				
		model.addAttribute("produitsAttribute", iAdminProduitMetier.getListproduits());
				
		return "redirect:/index";
		
	}
	
	/**
	 * Méthode pour afficher la photo
	 * @return
	 */
	@RequestMapping(value="/photo", method=RequestMethod.GET)
	public String getPhoto(@RequestParam(required=true, value="cat") Categorie cat, Model model) {
		
		String photoController = cat.getPhoto();
		
		
		return photoController;
	}
}
