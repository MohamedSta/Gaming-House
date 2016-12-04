package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;



public enum Role implements Serializable {

	Gamer ("Gamer"),
	VIP ("VIP Member"),
	TeamLogistics ("Team Logistics"),
	TeamMedia ("Team Media"),
	TeamOrganisation ("Team Organisation"),
	TeamSponsor ("Team Sponsoring"),
	AdministativeCouncil ("Administrative Council")
	;
	
	private String role ="";
	private static final long serialVersionUID = 1L;

	Role(String role) {
		this.role = role;
	}

	public String toString(){
		return role;
	}

}
