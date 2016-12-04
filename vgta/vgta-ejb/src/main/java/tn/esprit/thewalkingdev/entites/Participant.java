package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Participant implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String name;

	@Column(name="checked_in")
	private byte checkedIn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="checked_in_at")
	private Date checkedInAt;

	private int id;

	//bi-directional many-to-one association to Tournament
	@ManyToOne
	@JoinColumn(name="tournament_id")
	private Tournament tournament;

	public Participant() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getCheckedIn() {
		return this.checkedIn;
	}

	public void setCheckedIn(byte checkedIn) {
		this.checkedIn = checkedIn;
	}

	public Date getCheckedInAt() {
		return this.checkedInAt;
	}

	public void setCheckedInAt(Date checkedInAt) {
		this.checkedInAt = checkedInAt;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tournament getTournament() {
		return this.tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	
}
