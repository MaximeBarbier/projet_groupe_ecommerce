package com.intiformation.gestion.commerce.bean;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="commande")
@Table (name="commandes")
public class Commande {
	/*__________________________________________les champs___________________________________________*/	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_commande")
	private Long idCommande; 
	@Column(name="date_commande")
	private Date dateCommande;
	
	
	@ManyToOne (cascade= CascadeType.ALL)
	@JoinColumn(name="client_id", referencedColumnName="id_client") 
	private Client client; 
	
	@OneToMany (cascade= CascadeType.ALL)
	@JoinColumn(name="commande_id", referencedColumnName="id_commande") 
	private List<LigneCommande> ligneCommandes; 
	
	/*_______________________________________les ctors_______________________________________________*/
	public Commande() {
		
	}
	
	public Commande(Date dateCommande) {
	
		this.dateCommande = dateCommande;
	}

	public Commande(Long idCommande, Date dateCommande) {
		
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}
	/*__________________________________________Les encapsulations______________________________________*/
	
	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	/*__________________________________________Les encapsulations______________________________________*/
	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(Map<Long, LigneCommande> map) {
		this.ligneCommandes = (List<LigneCommande>) map;
	}

	
}
