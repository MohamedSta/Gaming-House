package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vote
 *
 */
@Entity
public class Vote implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private Date date_debut;
	private Date date_Fin;
	private int nbRequiredAdmin;
	private List<Election> candidats;
	
	public Vote() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@OneToMany(mappedBy = "vote")
	public List<Election> getCandidats() {
		return candidats;
	}

	public void setCandidats(List<Election> candidats) {
		this.candidats = candidats;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_Fin() {
		return date_Fin;
	}

	public void setDate_Fin(Date date_Fin) {
		this.date_Fin = date_Fin;
	}

	public int getNbRequiredAdmin() {
		return nbRequiredAdmin;
	}

	public void setNbRequiredAdmin(int nbRequiredAdmin) {
		this.nbRequiredAdmin = nbRequiredAdmin;
	}


}
