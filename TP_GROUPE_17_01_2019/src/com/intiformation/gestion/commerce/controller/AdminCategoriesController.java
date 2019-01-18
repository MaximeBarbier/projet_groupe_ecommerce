package com.intiformation.gestion.commerce.controller;

import java.util.Collections;
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
@RequestMapping("/categorie")
public class AdminCategoriesController {

	@Autowired
	private IAdminCategoriesMetier adminCategorie;

	// ctor chargé pour injection de spring
	public AdminCategoriesController(IAdminCategoriesMetier adminCategorie) {
		super();
		this.adminCategorie = adminCategorie;
	}

	/**
	 * Méthode index pour afficher la liste des produits et des catégories
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listCategories", method = RequestMethod.GET)
	public String index(Model model) {

		// Création de la liste des categories
		List<Categorie> listeCategories = Collections.emptyList();
		listeCategories = adminCategorie.getListCategories();
		model.addAttribute("categoriesAttribute", listeCategories);

		// nom de la vue : index | résolution : WEB-INF/views/categories.jsp
		return "categories";

	}

	/**
	 * Méthode delete catégorie
	 * 
	 * @param idcat
	 * @param model
	 */
	@RequestMapping(value = "/deleteCategorie", method = RequestMethod.GET)
	// @RequestMapping(value="/deleteCategorie/{idcat}", method=RequestMethod.GET)
	// en argument de suppcat => (@PathVariable long idcat)
	public void suppCat(@RequestParam(required = true, value = "idcat") Long idcat, Model model) {

		// Categorie categorie = iAdminCategoriesMetier.getCategorie(idcat); Pas sûre
		// d'en avoir besoin
		adminCategorie.deleteCategorie(idcat);
		model.addAttribute("categoriesAttribute", adminCategorie.getListCategories());

		// return "redirect:/index";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCat(@ModelAttribute("cat") Categorie cat) {

		adminCategorie.addCategorie(cat);

		return "redirect:/listCategories";

	}

	/**
	 * afficher le formulaire en réponse à une requête GET pour la modification
	 * 
	 * @return
	 */
	@RequestMapping(value = "/updatecategorieform", method = RequestMethod.GET)
	public ModelAndView setUpFormulaireUpdate(@RequestParam("catid") long pIdcategorie) {

		// 1. recup du fonctionnaire de la bdd (c'est l'objet de commande)
		Categorie categorie = adminCategorie.getCategorie(pIdcategorie);

		return new ModelAndView("editCategorie", "categorieUpCommand", categorie);
	}

	/**
	 * modifier une cat
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updatecategorie", method = RequestMethod.POST)
	public String updateCategorie( @ModelAttribute("categorieUpCommand") Categorie pcategorie,
			                           Model model) {
		

		// Recup de la categorie par l'id
		adminCategorie.editCategorie(pcategorie);

		//modif
		adminCategorie.editCategorie(pcategorie);

		model.addAttribute("categoriesAttribute", adminCategorie.getListCategories());


		// recup les fonctionnaires de la bdd + renvoi des données vers
		// fonctionnaires.jsp
		model.addAttribute("categoriesAttribute", adminCategorie.getListCategories());

		

		// redirection vers fonctionnaires.jsp
		return "redirect:/listCategories";
	}

	/**
	 * Méthode pour afficher la photo
	 * 
	 * @return
	 */
	@RequestMapping(value = "/photo", method = RequestMethod.GET)
	public String getPhoto(@RequestParam(required = true, value = "cat") Categorie cat, Model model) {

		String photoController = cat.getPhoto();

		return photoController;
	}

	/**
	 * ajout d'une cat a la bdd
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addCat", method = RequestMethod.POST)
	public String addCategorie(@ModelAttribute("categorieCommand") @Validated Categorie pcategorie) {

		// ajout d'une categorie
		adminCategorie.addCategorie(pcategorie);

		return "redirect:/listCategories";

	}

}
