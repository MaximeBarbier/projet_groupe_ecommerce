package com.intiformation.gestion.commerce.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="user")
@Table(name="users")
	public class User {
		
		/*____________________________________champs__________________________________________________________________________*/
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id_user")
		private long idUser;
		@Column(name="username")
		private String username;
		@Column(name="password")
		private String password;
		@Column(name="activated")
		private boolean activated;
		
		
		/*___________________________________ctor_________________________________________________________________________________*/
		
		public User() {
			
		}
		
		
		public User(String username, String password, boolean activated) {
			super();
			this.username = username;
			this.password = password;
			this.activated = activated;
		}


		public User(long idUser, String username, String password, boolean activated) {
			super();
			this.idUser = idUser;
			this.username = username;
			this.password = password;
			this.activated = activated;
		}

		/*___________________________________encapsulation_________________________________________________________________________________*/
		public long getIdUser() {
			return idUser;
		}
		public void setIdUser(long idUser) {
			this.idUser = idUser;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public boolean isActivated() {
			return activated;
		}
		public void setActivated(boolean activated) {
			this.activated = activated;
		}
		

}
