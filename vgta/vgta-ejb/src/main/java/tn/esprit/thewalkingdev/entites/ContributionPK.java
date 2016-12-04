package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContributionPK implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idEvent;
	private int idSponsor;

	@Column(name = "id_event")
	public int getIdEvent() {
		return idEvent;
	}
	@Column(name = "id_sponsor")
	public int getIdSponsor() {
		return idSponsor;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public void setIdSponsor(int idSponsor) {
		this.idSponsor = idSponsor;
	}

	public ContributionPK(int idEvent, int idSponsor) {
		this.idEvent = idEvent;
		this.idSponsor = idSponsor;
	}

	public ContributionPK() {
	}

	@Override
	public String toString() {
		return "ContributionPK [idEvent=" + idEvent + ", idSponsor="
				+ idSponsor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEvent;
		result = prime * result + idSponsor;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContributionPK other = (ContributionPK) obj;
		if (idEvent != other.idEvent)
			return false;
		if (idSponsor != other.idSponsor)
			return false;
		return true;
	}

}
