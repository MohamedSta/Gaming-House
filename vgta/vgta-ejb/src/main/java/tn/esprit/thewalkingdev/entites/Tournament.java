package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tournament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String url;

	private String description;

	@Column(name="hold_third_place_match")
	private byte holdThirdPlaceMatch;

	private String name;

	@Column(name="show_rounds")
	private byte showRounds;

	@Column(name="signup_cap")
	private int signupCap;

	@Column(name="tournament_type")
	private String tournamentType;

	//bi-directional many-to-one association to Participant
	@OneToMany(mappedBy="tournament")
	private List<Participant> participants;

	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="id_event")
	private Events event;

	public Tournament() {
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getHoldThirdPlaceMatch() {
		return this.holdThirdPlaceMatch;
	}

	public void setHoldThirdPlaceMatch(byte holdThirdPlaceMatch) {
		this.holdThirdPlaceMatch = holdThirdPlaceMatch;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getShowRounds() {
		return this.showRounds;
	}

	public void setShowRounds(byte showRounds) {
		this.showRounds = showRounds;
	}

	public int getSignupCap() {
		return this.signupCap;
	}

	public void setSignupCap(int signupCap) {
		this.signupCap = signupCap;
	}

	public String getTournamentType() {
		return this.tournamentType;
	}

	public void setTournamentType(String tournamentType) {
		this.tournamentType = tournamentType;
	}

	public List<Participant> getParticipants() {
		return this.participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public Participant addParticipant(Participant participant) {
		getParticipants().add(participant);
		participant.setTournament(this);

		return participant;
	}

	public Participant removeParticipant(Participant participant) {
		getParticipants().remove(participant);
		participant.setTournament(null);

		return participant;
	}

	public Events getEvent() {
		return this.event;
	}

	public void setEvent(Events event) {
		this.event = event;
	}
	
}
