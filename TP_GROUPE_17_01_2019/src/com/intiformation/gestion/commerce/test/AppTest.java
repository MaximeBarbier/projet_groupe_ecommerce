package com.intiformation.gestion.commerce.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intiformation.gestion.commerce.bean.Categorie;
import com.intiformation.gestion.commerce.metier.IAdminCategoriesMetier;

public class AppTest {

	public static void main(String[] args) {
		
		ApplicationContext cont = new ClassPathXmlApplicationContext("/WEB-INF/appicationContext.xml");
		
		IAdminCategoriesMetier catBean = (IAdminCategoriesMetier) cont.getBean("serviceBean");
		
		
		Categorie cat = new Categorie("Ordi", "geek master 8000", "photo");
		
		catBean.addCategorie(cat);
	}

}
