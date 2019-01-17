package com.intiformation.gestion.commerce.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.intiformation.gestion.commerce.metier.BoutiqueMetierImpl;
import com.intiformation.gestion.commerce.metier.IAdminCategoriesMetier;
import com.intiformation.gestion.commerce.metier.IBoutiqueDao;

@Controller
@RequestMapping("/categorie")
public class AdminCategoriesController {

	BoutiqueMetierImpl boutique = new BoutiqueMetierImpl();
	IBoutiqueDao dao = boutique.getDao();
	
	
	// Recup de IAdminCategoriesMetier
	private IAdminCategoriesMetier iAdminCategoriesMetier;
			
	// ctor chargé pour injection de spring				
	public AdminCategoriesController(IAdminCategoriesMetier iAdminCategoriesMetier) {
		super();
		this.iAdminCategoriesMetier = iAdminCategoriesMetier;
	}



    /**
     * Méthode index pour afficher la liste des produits et des catégories
     * @return
     */
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Model model) {

	// Création de la liste des categories 
	List<Categorie> listeCategories = Collections.emptyList();		
	listeCategories = dao.listCategories();
	model.addAttribute("categoriesAttribute", listeCategories);
	
	// nom de la vue : index | résolution : WEB-INF/views/index.jsp
	return "index";
	
		}
	
	/**
	 * Méthode delete catégorie
	 * @param idcat
	 * @param model
	 */
	@RequestMapping(value="/deleteCategorie", method=RequestMethod.GET)
	//@RequestMapping(value="/deleteCategorie/{idcat}", method=RequestMethod.GET)
	// en argument de suppcat => (@PathVariable long idcat)
	public void suppCat(@RequestParam(required=true, value="idcat") Long idcat, Model model)  {
		
		//Categorie categorie = iAdminCategoriesMetier.getCategorie(idcat); Pas sûre d'en avoir besoin
		iAdminCategoriesMetier.supprimerCategorie(idcat);
		model.addAttribute("categoriesAttribute", dao.listCategories());
		
		return "redirect:/index";
	}	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCat(@ModelAttribute("cat") Categorie cat ) {
		
		iAdminCategoriesMetier.ajouterCategorie(cat);
		
		return "redirect:/index";
		
	}
	
	/**
	 * Méthode pour modifier 
	 * @param idcat
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String editCat(@RequestParam(required=true, value="cat") Categorie cat, Model model) {
		
		// Recup de la categorie par l'id
		iAdminCategoriesMetier.modifierCategorie(cat);
		
		model.addAttribute("categoriesAttribute", dao.listCategories());
		
		return "redirect:/index";
		
	}
	
	/**
	 * Méthode pour afficher la photo
	 * @return
	 */
	@RequestMapping(value="/photo", method=RequestMethod.GET)
	public byte[] getPhoto(@RequestParam(required=true, value="cat") Categorie cat, Model model) {
		
		byte[] photo = cat.getPhoto();
		
		
		return photo;
	}
	
}
