package com.intiformation.gestion.commerce.validateur;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.intiformation.gestion.commerce.bean.Categorie;

@Component

public class CategorieValidateur implements Validator {
	

		@Override
		public boolean supports(Class<?> clazz) {
			return Categorie.class.isAssignableFrom(clazz);
		}

		/**
		 * implémente la logique de validation
		 */
		/*validation des champs*/
		//1. validation du champs nom
		//rejet de la valeur si ell est null pu contiens un espace 
		//=> les arguments erros si le champs est vide créer une errur de champs 
		//=> 2éme argument : nom de la proprieter 
		//=> 3éme args: required.nom: code d'erreur ds la fichier validation.properties(bundle)
		//=>4eme args: message par defaults
		@Override
		public void validate(Object target, Errors errors) {

			/* === validation champs === */

			
			
			
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required.description", "Le champ est obligatoire");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom_categorie", "required.nomCategorie", "Le champ est obligatoire");
			ValidationUtils.rejectIfEmpty(errors, "photo", "required.photo", "Le champ est obligatoire");

			/* === validation objet === */

			Categorie Categorie = (Categorie) target;

}

}
