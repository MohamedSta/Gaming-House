package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Candidat
 *
 */
@Entity

public class Election implements Serializable {

	private int id_candidat;
	private int nbreVote;
	private static final long serialVersionUID = 1L;

	private Vote vote;
	private Gamer gamer;
	
	
	public Election() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_candidat() {
		return id_candidat;
	}
	public void setId_candidat(int id_candidat) {
		this.id_candidat = id_candidat;
	}
	
	@OneToOne
	public Gamer getGamer() {
		return gamer;
	}
	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_vote")
	public Vote getVote() {
		return vote;
	}
	public void setVote(Vote vote) {
		this.vote = vote;
	}
	
	public int getNbreVote() {
		return this.nbreVote;
	}

	public void setNbreVote(int nbreVote) {
		this.nbreVote = nbreVote;
	}
 
   
}
