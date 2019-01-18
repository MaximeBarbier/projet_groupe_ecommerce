package com.intiformation.gestion.commerce.bean;

import java.util.HashMap;
import java.util.Map;

public class Panier {
	
	private Map<Long,LigneCommande> article=new HashMap<>();
	
	private LigneCommande lc;
	public void addProduit(Produit p, int quantite) {
		this.lc=article.get(p.getIdProduit());
		if(this.lc==null) {
			 this.lc= new LigneCommande();
			 this.lc.setProduit(p);
			this.lc.setQuantite(quantite);
			
		}else {
			this.lc.setQuantite(quantite+lc.getQuantite());
		}
	}

	public void supprimerProduit(Long idProduit) {
		article.remove(idProduit);
	}
	
	public double prixTotalPanier(double prixTotal) {
		for (LigneCommande lc : article.values()) {
			prixTotal += lc.getPrix() ;
			
		}
		return prixTotal;
	}

	public Map<Long, LigneCommande> getArticle() {
		return article;
	}

	public void setArticle(Map<Long, LigneCommande> article) {
		this.article = article;
	}

	public LigneCommande getLc() {
		return lc;
	}

	public void setLc(LigneCommande lc) {
		this.lc = lc;
	}
	
	
}
