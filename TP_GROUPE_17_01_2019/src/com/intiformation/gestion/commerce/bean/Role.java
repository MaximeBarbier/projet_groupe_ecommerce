package com.intiformation.gestion.commerce.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity(name="role")
@Table(name="roles")
public class Role {
	
	/*____________________________________Champs_______________________________________________________________________________*/
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_role")
	private Long idRole;
	@Column(name="role_name")
	private String roleName;
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="id_user")
	private User user;
	
	/*___________________________________Ctor____________________________________________________________________________________*/
	
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	public Role() {
		super();
	}
	
	public Role(Long idRole, String roleName) {
		super();
		this.idRole = idRole;
		this.roleName = roleName;
	}
	
	/*___________________________________Encapsulation_________________________________________________________________________________*/
	
	
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
