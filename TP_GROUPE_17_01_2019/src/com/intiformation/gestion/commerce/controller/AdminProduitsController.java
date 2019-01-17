package com.intiformation.gestion.commerce.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.intiformation.gestion.commerce.metier.IAdminProduitMetier;
import com.intiformation.modele.Categorie;
import com.intiformation.modele.Produit;

@Controller
@RequestMapping("/produits")
public class AdminProduitsController {

	// Recup IAdminProduitMetier
	private IAdminProduitMetier iAdminProduitMetier;

	// ctor charg� pour injection spring
	public AdminProduitsController(IAdminProduitMetier iAdminProduitMetier) {
		super();
		this.iAdminProduitMetier = iAdminProduitMetier;
	}
	
	/**
	 * M�thode pour afficher la liste des produits
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Model model) {
		
		// Cr�ation de la liste des produits 
		List<Produit> listeProduits = Collections.emptyList();		
		listeProduits = dao.listproduits();
		model.addAttribute("produitsAttribute", listeProduits);
		
		// nom de la vue : index | r�solution : WEB-INF/views/index.jsp
		return "index";
	}
	
	/**
	 * M�thode pour ajouter un produit dans une cat�gorie
	 * @param prod
	 * @param idCat
	 * @return
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveProd(@ModelAttribute("prod") Produit prod,
							@ModelAttribute("idcat") Long idCat) {
		
		iAdminProduitMetier.ajouterProduit(prod, idCat);
		
		return "redirect:/index";
		
	}
	/**
	 * M�thode pour supprimer un produit par son id
	 * @param idProduit
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deleteProd", method=RequestMethod.GET)
	public String suppProd(@RequestParam(required=true, value="idProduit") Long idProduit, Model model) {
		
		//Categorie categorie = iAdminProduitsMetier.getProduit(idcat); Pas s�re d'en avoir besoin
		iAdminProduitMetier.supprimerProduit(idProduit);
		model.addAttribute("produitsAttribute", dao.listproduits());
				
		return "redirect:/index";
		
	}
	
	/**
	 * M�thode pour modifier un produit
	 * @param prod
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String editProd(@RequestParam(required=true, value="prod") Produit prod, Model model) {
		
		// Recup de la categorie par l'id
		iAdminProduitMetier.modifierProduit(prod);
				
		model.addAttribute("produitsAttribute", dao.listproduits());
				
		return "redirect:/index";
		
	}
	
	/**
	 * M�thode pour afficher la photo
	 * @return
	 */
	@RequestMapping(value="/photo", method=RequestMethod.GET)
	public byte[] getPhoto(@RequestParam(required=true, value="cat") Categorie cat, Model model) {
		
		byte[] photo = cat.getPhoto();
		
		
		return photo;
	}
}
