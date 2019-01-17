package com.intiformation.gestion.commerce.metier;

import com.intiformation.gestion.commerce.bean.Produit;

public interface IAdminProduitMetier extends IInternauteBoutique {
	
	public void addProduit(Produit p, Long idCat);
	
	public void deleteProduit(Long idP);
	
	public void editProduit(Produit p);
		
}
