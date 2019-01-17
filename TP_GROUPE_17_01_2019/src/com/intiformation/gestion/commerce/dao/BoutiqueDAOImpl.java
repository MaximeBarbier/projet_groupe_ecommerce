package com.intiformation.gestion.commerce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.handler.MatchableHandlerMapping;

@Repository
public class BoutiqueDAOImpl implements IBoutiqueDAO{
	
	//Entity manager pour utiliser les m�thodes jpa
	//Annotation pour que le serveur g�re l'instanciation de l'em sans qu'on utilise l'entity manager 	factory
	@PersistenceContext
	private EntityManager em;
	
	//Setter de l'em pour l'injecter dans le DAO
	public void setEm(EntityManager em) {
		
		this.em = em;
	}

	@Override
	@Transactional
	public Long ajouterCategorie(Categorie c) {
		
		//Ajout de la cat�gorie � la BDD (Pas d'ID car BDD en Auto-Increment)
		em.persist(c);
		
		//Cr�ation d'une requ�te pour recup la cat�gorie que l'on vient d'ajouter � la BDD
		Query query = em.createQuery("SELECT idCategorie FROM categorie WHERE nomCategorie = ?1");
		query.setParameter(1, c.getNomCategorie());
		
		//R�cup�ration et retour de l'ID
		Long idCategorie = query.getSingleResult();
		return idCategorie;	  
	}

	@Override
	@Transactional(readOnly=true)
	public List<Categorie> listCategories() {
		
		Query query = em.createQuery("SELECT c FROM categorie c");
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly=true)
	public Categorie getCategorie(Long idCat) {
		
		Categorie cat = em.find(Categorie.class, idCat);
		return cat;
	}

	@Override
	@Transactional
	public void supprimerCategorie(Long idcat) {
		
		Categorie cat = this.getCategorie(idcat);
		em.remove(cat);
	}

	@Override
	@Transactional
	public void modifierCategorie(Categorie c) {
		
		em.merge(c);	
	}

	@Override
	@Transactional
	public Long ajouterProduit(Produit p, Long idCat) {
		
		//R�cup�ration de la cat�gorie dans laquelle on veut ajouter le produit
		Categorie cat = em.find(Categorie.class, idCat);
		
		//On met la cat�gorie dans le produit et on ajoute le produit � la BDD
		p.setCategorie(cat);
		em.persist(p);
		
		//On r�cup�re le produit qu'on vient d'ajouter dans la BDD et qui vient de recup un ID par auto 		increment
		Query query = em.createQuery("SELECT p.idProduit FROM produit p WHERE p.designation = ?1");
		query.setParameter(1, p.getDesignation());
		Long idProduit = query.getSingleResult();
		return idProduit;	  
	}

	@Override
	@Transactional(readOnly=true)
	public List<Produit> listproduits() {
		
		Query query = em.createQuery("SELECT p FROM produit p");
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Produit> produitsParMotCle(String mc) {
		
		//On cr�� une query o� l'on met un param�tre avec un LIKE sur la d�signation du produit
		Query query = em.createQuery("SELECT p FROM produit p WHERE p.designation LIKE :motClef");
		
		//On met le mot clef en param�tre en ajoutant '%' devant et derri�re pour rechercher toute les 		d�signations contenant le mot clef
		query.setParameter("motClef", "%" + mc + "%");
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Produit> produitsParCategorie(Long idCat) {
		
		Query query = em.createQuery("SELECT p FROM produit p WHERE p.categorie.idCategorie = ?1");
		query.setParameter(1, idCat);
		return query.getResultList();
		
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Produit> produitsSelectionnes() {
		
		Query query = em.createQuery("SELECT p FROM produit p WHERE p.selectionne=true");
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly=true)
	public Produit getProduit(Long idP) {
		
		Produit prod = em.find(Produit.class, idP);
		return prod;
	}

	@Override
	@Transactional
	public void supprimerProduit(Long idP) {
		
		Produit prod = this.getProduit(idP);
		em.remove(cat);	
	}

	@Override
	@Transactional
	public void modifierProduit(Produit p) {
		
		em.merge(p);	
	}

	@Override
	@Transactional
	public void ajouterUser(User u) {
		
		em.persist(u);
	}

	@Override
	@Transactional
	public void attribuerRole(Role r, Long userID) {
		
		//Recup du user avec son id
		User user = em.find(User.class, userID);
		
		//Changement du role du user
		user.setRole(r);
		
		//Modif dans la BDD
		em.merge(user);
	}

	@Override
	@Transactional
	public Commande enregistrerCommande(GestionPanier p, Client c) {
		return null;
	}

}
