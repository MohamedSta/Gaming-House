package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Team implements Serializable {

	private int id_team;
	private int max_members;
	private String name;
	private static final long serialVersionUID = 1L;
	private List<Gamer> gamers;
	private List<Article> articles;
	private List<Equipment> equipements;
	private List<Sponsor> sponsors;
	private List<Events> events;

	public Team() {
	}

	

	public Team(int id_team, int max_members, String name, List<Gamer> gamers) {
		this.id_team = id_team;
		this.max_members = max_members;
		this.name = name;
		this.gamers = gamers;
	}



	public Team(int id_team) {
		this.id_team = id_team;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_team() {
		return this.id_team;
	}

	public void setId_team(int id_team) {
		this.id_team = id_team;
	}

	@OneToMany(mappedBy="team")
	public List<Gamer> getGamers() {
		return gamers;
	}

	public void setGamers(List<Gamer> gamers) {
		this.gamers = gamers;
	}

	public int getMax_members() {
		return max_members;
	}

	public void setMax_members(int max_members) {
		this.max_members = max_members;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@OneToMany(mappedBy="teamMedia")
	public List<Article> getArticles() {
		return articles;
	}



	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}


	@OneToMany(mappedBy="teamLogistics")
	public List<Equipment> getEquipements() {
		return equipements;
	}



	public void setEquipements(List<Equipment> equipements) {
		this.equipements = equipements;
	}


	@OneToMany(mappedBy="teamSponsor")
	public List<Sponsor> getSponsors() {
		return sponsors;
	}



	public void setSponsors(List<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}


	@OneToMany(mappedBy="teamOrganisation")
	public List<Events> getEvents() {
		return events;
	}



	public void setEvents(List<Events> events) {
		this.events = events;
	}
	

}
