package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

@Entity
public class Administrator implements Serializable {

	private int id;
	private String username;
	private String password;
	private static final long serialVersionUID = 1L;

	public Administrator() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrator [id=" + id + ", username=" + username
				+ ", password=" + password + "]";
	}

	
}