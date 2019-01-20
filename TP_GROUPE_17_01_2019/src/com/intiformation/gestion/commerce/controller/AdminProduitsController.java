package com.intiformation.gestion.commerce.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.gestion.commerce.metier.EBoutiqueMetierImpl;
import com.intiformation.gestion.commerce.metier.IAdminProduitMetier;
import com.intiformation.springmvc.entity.Fonctionnaire;
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
	 * afficher le formulaire en réponse à une requête GET
	 * 
	 * @return
	 */
	@RequestMapping(value = "/produit/addproduitform", method = RequestMethod.GET)
	public ModelAndView setUpFormulaireAjout() {

		/* /// Données à retourner vers la vue /// */

		Map<String, Object> data = new HashMap<>();

		// 1.définition de l'objet de commande
		Produit produit = new Produit();

		// 2.définition du nom de l’objet de commande
		String objetDeCommandeProduit = "produitCommand";

		// 3.association du nom à l'objet
		data.put(objetDeCommandeProduit, produit);

		/* /// le nom logique de la vue /// */
		String viewName = "ajouterProduit";

		return new ModelAndView(viewName, data);
	}

	
	
	
	/**
	 * Méthode pour ajouter un produit dans une catégorie
	 * @param prod
	 * @param idCat
	 * @return
	 */
	@RequestMapping(path="/save", method=RequestMethod.POST)
	public String saveProd(
			                @ModelAttribute("produitCommand") Produit prod,
			                @Validated Produit pProduit,
			                ModelMap modele, BindingResult result) {
	
		//validation du champs à l'ajout
				//result de type BindingResult : contiens les resultats du process de  la validations 
				
				validator.validate(pProduit, result);
				
				if (result.hasErrors()) {
					
					/*détection d'erreurs lors de la validation*/
					
					//--> redirection vers ajouterProduit.jsp
					return "ajouterProduit";
					
				}else {
					
					/*pas d'erreurs de validation*/ 
					
					// ajout du produit
					i.ajouterFonctionnaire(pFonctionnaire);

					// recup des produits  de la bdd + renvoi des données vers
					// produits.jsp
					modele.addAttribute("produitsAttribute", iAdminProduitMetier.getListproduits());

					// redirection vers produits.jsp
					return "produits";
				}
			}
		
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
