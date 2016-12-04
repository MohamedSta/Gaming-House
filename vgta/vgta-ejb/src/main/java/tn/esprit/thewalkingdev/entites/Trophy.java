package tn.esprit.thewalkingdev.entites;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Trophy {

	private Gamer gamer;
	private Events event;
	private RankTrophy rankTrophy; 
	private String description;
	private TrophyPK trophyPK;
	
	
	public Trophy() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Trophy(Gamer gamer, Events event, RankTrophy rankTrophy,
			String description, TrophyPK trophyPK) {
		
		this.gamer = gamer;
		this.event = event;
		this.rankTrophy = rankTrophy;
		this.description = description;
		this.trophyPK = new TrophyPK(gamer.getId(), event.getIdEvent());
	}


	@ManyToOne
	@JoinColumn(referencedColumnName="id", name="id_gamer", insertable=false, updatable=false)
	public Gamer getGamer() {
		return gamer;
	}
	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}
	@ManyToOne
	@JoinColumn(referencedColumnName="id_event", name="id_event", insertable=false, updatable=false)
	public Events getEvent() {
		return event;
	}
	public void setEvent(Events event) {
		this.event = event;
	}
	public RankTrophy getRankTrophy() {
		return rankTrophy;
	}
	public void setRankTrophy(RankTrophy rankTrophy) {
		this.rankTrophy = rankTrophy;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@EmbeddedId
	public TrophyPK getTrophyPK() {
		return trophyPK;
	}
	public void setTrophyPK(TrophyPK trophyPK) {
		this.trophyPK = trophyPK;
	}
	
	
}
