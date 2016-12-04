package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Events implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_event")
	private int idEvent;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String name;

	private int nbrReservation;

	private String streaming;

	//bi-directional many-to-one association to Contribution
	@OneToMany(mappedBy="event")
	private List<Contribution> contributions;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="teamOrganisation")
	private Team teamOrganisation;

	//bi-directional many-to-one association to Venue
	@ManyToOne
	@JoinColumn(name="venue")
	private Venue venue;

	//bi-directional many-to-one association to Typeevent
	@ManyToOne
	@JoinColumn(name="type")
	private TypeEvent typeevent;

	//bi-directional many-to-one association to Tournament
	@OneToMany(mappedBy="event")
	private List<Tournament> tournaments;

	//bi-directional many-to-one association to Trophy
	@OneToMany(mappedBy="event")
	private List<Trophy> trophies;

	public Events() {
	}

	public int getIdEvent() {
		return this.idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNbrReservation() {
		return this.nbrReservation;
	}

	public void setNbrReservation(int nbrReservation) {
		this.nbrReservation = nbrReservation;
	}

	public String getStreaming() {
		return this.streaming;
	}

	public void setStreaming(String streaming) {
		this.streaming = streaming;
	}

	public List<Contribution> getContributions() {
		return this.contributions;
	}

	public void setContributions(List<Contribution> contributions) {
		this.contributions = contributions;
	}

	public Contribution addContribution(Contribution contribution) {
		getContributions().add(contribution);
		contribution.setEvent(this);

		return contribution;
	}

	public Contribution removeContribution(Contribution contribution) {
		getContributions().remove(contribution);
		contribution.setEvent(null);

		return contribution;
	}

	public Team getTeam() {
		return this.teamOrganisation;
	}

	public void setTeam(Team team) {
		this.teamOrganisation = team;
	}

	public Venue getVenue() {
		return this.venue;
	}

	public void setVenue(Venue venueBean) {
		this.venue = venueBean;
	}

	public TypeEvent getTypeevent() {
		return this.typeevent;
	}

	public void setTypeevent(TypeEvent typeevent) {
		this.typeevent = typeevent;
	}

	public List<Tournament> getTournaments() {
		return this.tournaments;
	}

	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	public Tournament addTournament(Tournament tournament) {
		getTournaments().add(tournament);
		tournament.setEvent(this);

		return tournament;
	}

	public Tournament removeTournament(Tournament tournament) {
		getTournaments().remove(tournament);
		tournament.setEvent(null);

		return tournament;
	}

	public List<Trophy> getTrophies() {
		return this.trophies;
	}

	public void setTrophies(List<Trophy> trophies) {
		this.trophies = trophies;
	}

	public Trophy addTrophy(Trophy trophy) {
		getTrophies().add(trophy);
		trophy.setEvent(this);

		return trophy;
	}

	public Trophy removeTrophy(Trophy trophy) {
		getTrophies().remove(trophy);
		trophy.setEvent(null);

		return trophy;
	}


}
