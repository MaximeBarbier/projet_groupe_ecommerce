package com.intiformation.gestion.commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	// ctor charg� pour injection de spring
	@Autowired
	public AdminCategoriesController(IAdminCategoriesMetier adminCategorie) {
		this.adminCategorie = adminCategorie;
	}

	/**
	 * M�thode index pour afficher la liste des produits et des cat�gories
	 * 
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,  path="/listCat")
	public String generateList(Model model) {
		
		List<Categorie> categories = adminCategorie.getListCategories();
		model.addAttribute("categoriesAttribute", categories);
		
		Categorie cat = new Categorie();
		model.addAttribute("catVide", cat);
		
		return "categories";
	}
	
	/**
	 * M�thode delete cat�gorie
	 * @param idcat
	 * @param model
	 */
	@RequestMapping(value="/deleteCategorie*", method=RequestMethod.GET)
	public String suppCat(@RequestParam(required=true, value="idcat") Long idcat, Model model)  {
		
		adminCategorie.deleteCategorie(idcat);
    
		List<Categorie> categories = adminCategorie.getListCategories();
		model.addAttribute("categoriesAttribute", categories);
		
		Categorie cat = new Categorie();
		model.addAttribute("catVide", cat);
		
		return "redirect:/listCat";
	}	

//	@RequestMapping(value="/save", method=RequestMethod.POST)
//	public String saveCat(@ModelAttribute("cat") Categorie cat ) {
//		
//		iAdminCategoriesMetier.addCategorie(cat);
//		
//		return "redirect:/listCategories";
//		
//	}
//	
//	
//	
//	
//	
//	/**
//	 * afficher le formulaire en r�ponse � une requ�te GET pour la modification
//	 * 
//	 * @return
//	 */
//	@RequestMapping(value = "/updatecategorieform", method = RequestMethod.GET)
//	public ModelAndView setUpFormulaireUpdate(@RequestParam("catid") long pIdcategorie) {
//		
//		//1. recup du fonctionnaire de la bdd (c'est l'objet de commande)
//		Categorie categorie = iAdminCategoriesMetier.getCategorie(pIdcategorie);
//		
//		return new ModelAndView("editCategorie","categorieUpCommand", categorie);
//	}
//	
//	
//	
//	
//	/**
//	 * modifier une cat
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/updatecategorie", method = RequestMethod.POST)
//	public String updateCategorie( @ModelAttribute("categorieUpCommand") Categorie pcategorie,
//			                           Model model) {
//		
//		//modif
//		iAdminCategoriesMetier.editCategorie(pcategorie);
//		
//
//		// recup les fonctionnaires de la bdd + renvoi des donn�es vers
//		// fonctionnaires.jsp
//		model.addAttribute("categoriesAttribute", iAdminCategoriesMetier.getListCategories());
//		
//
//		// redirection vers fonctionnaires.jsp
//		return "redirect:/listCategories";
//	}
//	
//	
//
//	
//	
//	
//	/**
//	 * M�thode pour afficher la photo
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
//	
//	
//	
//	/**
//	 * ajout d'une cat a la bdd
//	 * @return
//	 */
//	@RequestMapping(value = "/addCat", method = RequestMethod.POST)
//	public String addCategorie (@ModelAttribute("categorieCommand") 
//    							@Validated Categorie pcategorie) {
//		
//		//ajout d'une categorie
//		iAdminCategoriesMetier.addCategorie(pcategorie);
//
//
//		return "redirect:/listCategories";
//		
//	}
	
	

		


}
