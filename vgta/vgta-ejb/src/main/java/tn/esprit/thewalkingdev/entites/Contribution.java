package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contribution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="matriculecontribution")
	private int idContribution;

	private float amount;
@Column (name="descriptions")
	private String description;

	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="event")
	private Events event;

	//bi-directional many-to-one association to Sponsor
	@ManyToOne
	@JoinColumn(name="sponsor")
	private Sponsor sponsor;

	public Contribution() {
	}

	public int getIdContribution() {
		return this.idContribution;
	}

	public void setIdContribution(int idContribution) {
		this.idContribution = idContribution;
	}

	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Events getEvent() {
		return this.event;
	}

	public void setEvent(Events event) {
		this.event = event;
	}

	public Sponsor getSponsor() {
		return this.sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

	@Override
	public String toString() {
		return "Contribution [amount=" + amount + ", description="
				+ description + ", event=" + event + ", sponsor=" + sponsor
				+ "]";
	}



}
