package com.intiformation.gestion.commerce.bean;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity(name="client")
@Table (name="clients")
public class Client {
	/*__________________________________________les champs___________________________________________*/	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="id_client")
	private Long idClient; 
	@Column(name="nom_client")
	private String nomClient; 
	@Column(name="adresse")
	private String adresse;
	@Column(name="email")
	private String email;
	@Column(name="tel")
	private String tel;
	
	@OneToMany(mappedBy="client", cascade= CascadeType.ALL) 
	private List<Commande> commandes; 
	
	/*_______________________________________les ctors_______________________________________________*/

	public Client() {
		
	}
	public Client(String nomClient, String adresse, String email, String tel) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}
	public Client(Long idClient, String nomClient, String adresse, String email, String tel) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}
	/*__________________________________________Les encapsulations______________________________________*/
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
	
}
