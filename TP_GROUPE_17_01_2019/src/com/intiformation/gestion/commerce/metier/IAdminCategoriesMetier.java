package com.intiformation.gestion.commerce.metier;

import com.intiformation.gestion.commerce.bean.Categorie;
import com.intiformation.gestion.commerce.bean.Role;
import com.intiformation.gestion.commerce.bean.User;

public interface IAdminCategoriesMetier extends IAdminProduitMetier {

	public void addCategorie(Categorie c);
	
	public void deleteCategorie(Long idcat);
	
	public void editCategorie (Categorie c);
	
	public void addUser(User u);
	
	public void setUserRole(Role r, Long userID);
}
