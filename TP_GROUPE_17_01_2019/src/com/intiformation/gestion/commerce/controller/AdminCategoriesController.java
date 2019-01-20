package com.intiformation.gestion.commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.gestion.commerce.bean.Categorie;
import com.intiformation.gestion.commerce.metier.IAdminCategoriesMetier;


@Controller
public class AdminCategoriesController {

	
	private IAdminCategoriesMetier adminCategorie;

	// ctor chargé pour injection de spring
	@Autowired
	public AdminCategoriesController(IAdminCategoriesMetier adminCategorie) {
		this.adminCategorie = adminCategorie;
	}

	/**
	 * Méthode index pour afficher la liste des produits et des catégories
	 * 
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,  path="/listCat")
	public String generateList(Model model) {
		
		List<Categorie> categories = adminCategorie.getListCategories();
		model.addAttribute("categoriesAttribute", categories);
		
		Categorie cat = new Categorie();
		model.addAttribute("categorie", cat);
		
		return "categories";
	}
	
	/**
	 * Méthode delete catégorie
	 * @param idcat
	 * @param model
	 */
	@RequestMapping(value="/deleteCategorie*", method=RequestMethod.GET)
	@Transactional
	public String suppCat(@RequestParam(required=true, value="idcat") Long idcat, Model model)  {
		
		adminCategorie.deleteCategorie(idcat);
    
		List<Categorie> categories = adminCategorie.getListCategories();
		model.addAttribute("categoriesAttribute", categories);
		
		Categorie cat = new Categorie();
		model.addAttribute("categorie", cat);
		
		return "redirect:/listCat";
	}	

	@RequestMapping(path="/listCat", method=RequestMethod.POST)
	public String saveCat(@ModelAttribute("categorie") Categorie cat, Model model) {
		
		adminCategorie.addCategorie(cat);
		
		List<Categorie> categories = adminCategorie.getListCategories();
		model.addAttribute("categoriesAttribute", categories);
		
		Categorie cat1 = new Categorie();
		model.addAttribute("catVide", cat1);
		
		return "redirect:/listCat";
		
	}
	
	/**
	 * afficher le formulaire en réponse à une requête GET pour la modification
	 * 
	 * @return
	 */
	@RequestMapping(path = "/updatecategorieform*", method = RequestMethod.GET)
	public ModelAndView setUpFormulaireUpdate(@RequestParam("catid") long pIdcategorie) {
		
		//1. recup du fonctionnaire de la bdd (c'est l'objet de commande)
		Categorie categorie = adminCategorie.getCategorie(pIdcategorie);
		
		return new ModelAndView("editCategorie","categorieUpCommand", categorie);
	}

	/**
	 * modifier une cat
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/updatecategorieform*", method = RequestMethod.POST)
	public String updateCategorie(@ModelAttribute("categorieUpCommand") Categorie categorie,
			                       Model model) {
		
		//modif
		adminCategorie.editCategorie(categorie);
		

		List<Categorie> categories = adminCategorie.getListCategories();
		model.addAttribute("categoriesAttribute", categories);
		
		Categorie cat = new Categorie();
		model.addAttribute("categorie", cat);
		
		return "categories";
	}
//	
//	/**
//	 * Méthode pour afficher la photo
//	 * @return
//	 */
//	@RequestMapping(value="/photo", method=RequestMethod.GET)
//	public String getPhoto(@RequestParam(required=true, value="cat") Categorie cat, Model model) {
//		
//		String photoController = cat.getPhoto();
//		
//		
//		return photoController;
//	}

}
