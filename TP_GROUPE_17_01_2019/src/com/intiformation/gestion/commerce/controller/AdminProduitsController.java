package com.intiformation.gestion.commerce.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.intiformation.gestion.commerce.metier.EBoutiqueMetierImpl;
import com.intiformation.gestion.commerce.metier.IAdminProduitMetier;
import com.intiformation.gestion.commerce.bean.Categorie;
import com.intiformation.gestion.commerce.bean.Produit;

@Controller
public class AdminProduitsController {

	// Recup IAdminProduitMetier
	private IAdminProduitMetier iAdminProduitMetier;

	// ctor chargé pour injection spring
	@Autowired
	public AdminProduitsController(IAdminProduitMetier iAdminProduitMetier) {
		super();
		this.iAdminProduitMetier = iAdminProduitMetier;
	}
	
	
	
	/**
	 * Méthode index pour afficher la liste des produits 
	 * 
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,  path="/listProd")
	public String generateList(Model model) {
		
		List<Produit> produits = iAdminProduitMetier.getListproduits();
		model.addAttribute("produitsAttribute", produits);
		
		Produit prod = new Produit();
		model.addAttribute("prodVide", prod);
		
		return "produits";
	}
	
	
	
	/**
	 * Méthode pour ajouter un produit dans une catégorie
	 * @param prod
	 * @param idCat
	 * @return
	 */
	@RequestMapping(path="/save", method=RequestMethod.POST)
	public String saveProd(@ModelAttribute("prodVide") Produit prod,
							// la methode addProduit a besoin de l'idCategorie, mais je ne sais pas comment le recup seul.
							// l'idCategorie se trouve deja dans le formulaire d'ajout d'un produit
						   @RequestParam(required=true, value="idCat")long catID) {
	
		iAdminProduitMetier.addProduit(prod, catID);
		
		return "redirect:/listProd";
		
	}
	
	
	/**
	 * supprimmer un produit
	 * @param prodID
	 * @param model
	 * @return
	 */
	@RequestMapping(path="/deleteProd", method=RequestMethod.GET)
	public String produitDelete(@RequestParam(required=true, value="idProd")long prodID) {
		
		//Produit produit = iAdminProduitMetier.getProduct(prodID);
		iAdminProduitMetier.deleteProduit(prodID);
		//model.addAttribute("produitAttribute", iAdminProduitMetier.getListproduits());
		
		return "redirect:/listProd";
	}
	
	
	
	/**
	 *  Méthode pour modifier un produit (charger formulaire avec le produit)
	 * @param model
	 * @return
	 */
	@RequestMapping(path="/editProd", method=RequestMethod.GET)
	//produitAttribute se trouve dans le formulaire de la page editProduit.jsp
	public String chargementProduitFormulaire(@RequestParam(required=true, value="idProd")long prodID, Model model) {
		
		Produit produit = iAdminProduitMetier.getProduct(prodID);
		
		
		//iAdminProduitMetier.editProduit(produit);
		model.addAttribute("produitAttribute", produit);
		
		
		
		// vue : /WEb-INF/views/editProduit.jsp
		return "editProd";			
	}
	
	
	
	/**
	 * edit le produit de editProduit.jsp
	 * @param message
	 * @return
	 */
	@RequestMapping(path="/saveEditProd", method=RequestMethod.POST)
	//produitAttribute se trouve dans le formulaire de la page editProduit.jsp
	public String modifProduit(@ModelAttribute("produitAttribute") Produit produit) {
		
			iAdminProduitMetier.editProduit(produit);
			
			return "redirect:/listProd";
		}
		
	
	
	/**
	 * chargement de la liste déroulante des categories 
	 * @return
	 */
	@ModelAttribute("ListCategories")
	public List<Categorie> categoriesList(){
		
		List<Categorie> listeCategories = new ArrayList<>();
		
		listeCategories = iAdminProduitMetier.getListCategories();
		
		return listeCategories;
	}
	
	
	
	

}
