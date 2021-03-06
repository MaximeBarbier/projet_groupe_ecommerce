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
import com.intiformation.gestion.commerce.validator.ProduitValidateur;
import com.intiformation.gestion.commerce.bean.Categorie;
import com.intiformation.gestion.commerce.bean.Produit;

@Controller
public class AdminProduitsController {

	// Recup IAdminProduitMetier
	private IAdminProduitMetier iAdminProduitMetier;

	// ctor charg� pour injection spring
	@Autowired
	public AdminProduitsController(IAdminProduitMetier iAdminProduitMetier) {
		super();
		this.iAdminProduitMetier = iAdminProduitMetier;
	}

	/**
	 * M�thode index pour afficher la liste des produits
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/listProd")
	public String generateList(Model model) {

		List<Produit> produits = iAdminProduitMetier.getListproduits();
		model.addAttribute("produitsAttribute", produits);

		Produit prod = new Produit();
		model.addAttribute("prodVide", prod);

		 List<String> listName = iAdminProduitMetier.findListNomCategorie();
		 model.addAttribute("listNameCategories", listName);

		return "produits";
	}

	/**
	 * afficher le formulaire en r�ponse � une requ�te GET
	 * 
	 * @return
	 */
	@RequestMapping(value = "/produit/addproduitform", method = RequestMethod.GET)
	public ModelAndView setUpFormulaireAjout() {

		/* /// Donn�es � retourner vers la vue /// */

		Map<String, Object> data = new HashMap<>();

		// 1.d�finition de l'objet de commande
		Produit produit = new Produit();

		// 2.d�finition du nom de l�objet de commande
		String objetDeCommandeProduit = "produitCommand";

		// 3.association du nom � l'objet
		data.put(objetDeCommandeProduit, produit);

		/* /// le nom logique de la vue /// */
		String viewName = "ajouterProduit";

		return new ModelAndView(viewName, data);
	}

	/**
	 * M�thode pour ajouter un produit dans une cat�gorie
	 * 
	 * @param prod
	 * @param idCat
	 * @return
	 */
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public String saveProd(@ModelAttribute("prodVide") Produit prod, Model modele) {

		// validation du champs � l'ajout
		// result de type BindingResult : contient les resultats du process de la
		// validation

		/* pas d'erreurs de validation */

		Categorie cat = iAdminProduitMetier.findCategorieByName(prod.getCategorie().getNomCategorie());
		prod.setCategorie(cat);
		// ajout du produit
		iAdminProduitMetier.addProduit(prod, cat.getIdCategorie());
		// recup des produits de la bdd + renvoi des donn�es vers
		// produits.jsp
		modele.addAttribute("produitsAttribute", iAdminProduitMetier.getListproduits());

		// redirection vers produits.jsp
		return "produits";
	}

	/**
	 * supprimmer un produit
	 * 
	 * @param prodID
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/deleteProd", method = RequestMethod.GET)
	public String produitDelete(@RequestParam(required = true, value = "idProd") long prodID) {

		// Produit produit = iAdminProduitMetier.getProduct(prodID);
		iAdminProduitMetier.deleteProduit(prodID);
		// model.addAttribute("produitAttribute",
		// iAdminProduitMetier.getListproduits());

		return "redirect:/listProd";
	}

	/**
	 * M�thode pour modifier un produit (charger formulaire avec le produit)
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/editProd", method = RequestMethod.GET)
	// produitAttribute se trouve dans le formulaire de la page editProduit.jsp
	public String chargementProduitFormulaire(@RequestParam("idProd") Long pIDProd,
			Model model) {
		
		Produit produit = iAdminProduitMetier.getProduct(pIDProd);
		
		model.addAttribute("produitAModif", produit);
		
		return "editProduit";
		
	}

	/**
	 * edit le produit de editProduit.jsp
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(path = "/saveEditProd", method = RequestMethod.POST)
	// produitAttribute se trouve dans le formulaire de la page editProduit.jsp
	public String modifProduit(@ModelAttribute("produitAModif") Produit produit, Model model) {

		iAdminProduitMetier.editProduit(produit);

		Produit prod = new Produit();
		model.addAttribute("prodVide", prod);

		 List<String> listName = iAdminProduitMetier.findListNomCategorie();
		 model.addAttribute("listNameCategories", listName);

		return "produits";
	}

	/**
	 * chargement de la liste d�roulante des categories
	 * 
	 * @return
	 */
	@ModelAttribute("ListCategories")
	public List<String> categoriesList() {
		
		//Map<String, Categorie> Categories = new HashMap<>();
		List<String> listeCategories = new ArrayList<>();
		
		listeCategories = iAdminProduitMetier.findListNomCategorie();
		
		
		
		return listeCategories;
	}

}
