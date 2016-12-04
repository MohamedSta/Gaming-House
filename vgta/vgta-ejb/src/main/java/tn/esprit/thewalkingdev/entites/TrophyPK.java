package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TrophyPK implements Serializable {

	private int idEvent;
	private int idGamer;
	private static final long serialVersionUID = 1L;

	public TrophyPK() {
		// TODO Auto-generated constructor stub
	}

	public TrophyPK(int idEvent, int idGamer) {

		this.idEvent = idEvent;
		this.idGamer = idGamer;
	}

	@Column(name = "id_event")
	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	@Column(name = "id_gamer")
	public int getIdGamer() {
		return idGamer;
	}

	public void setIdGamer(int idGamer) {
		this.idGamer = idGamer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEvent;
		result = prime * result + idGamer;
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
		TrophyPK other = (TrophyPK) obj;
		if (idEvent != other.idEvent)
			return false;
		if (idGamer != other.idGamer)
			return false;
		return true;
	}

}
