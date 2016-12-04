package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Sponsor implements Serializable {

	private int id_sponsor;
	private String name_sponsor;
	private List<Contribution> contributions;
	private static final long serialVersionUID = 1L;
	private String name_contact_sponsor;
	private String email;
	private Date dateStart;
	private Date dateEnd;
	private Team teamSponsor;

	public Sponsor() {
	}

	public Sponsor(int id_sponsor, String name_sponsor,
			List<Contribution> contributions, String name_contact_sponsor,
			String email) {
		super();
		this.id_sponsor = id_sponsor;
		this.name_sponsor = name_sponsor;
		this.contributions = contributions;
		this.name_contact_sponsor = name_contact_sponsor;
		this.email = email;
	}

	public Sponsor(String name_sponsor, List<Contribution> contributions,
			String name_contact_sponsor, String email) {
		super();

		this.name_sponsor = name_sponsor;
		this.contributions = contributions;
		this.name_contact_sponsor = name_contact_sponsor;
		this.email = email;
	}

	// @Override
	// public String toString() {
	// return "Sponsor [id_sponsor=" + id_sponsor + ", name_sponsor="
	// + name_sponsor + ", teamSponsoring=" + teamSponsoring
	// + ", contributions=" + contributions
	// + ", name_contact_sponsor=" + name_contact_sponsor + ", email="
	// + email + "]";
	// }
	/*
	 * @Override public String toString() { return "Sponsor [id_sponsor=" +
	 * id_sponsor + ", name_sponsor=" + name_sponsor + ", contributions=" +
	 * contributions.toString() + ", name_contact_sponsor=" +
	 * name_contact_sponsor + ", email=" + email + ", dateStart=" + dateStart +
	 * ", dateEnd=" + dateEnd + ", teamSponsor=" + teamSponsor.toString() + "]";
	 * }
	 */
	@Override
	public String toString() {
		return name_sponsor;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_sponsor() {
		return this.id_sponsor;
	}

	public void setId_sponsor(int id_sponsor) {
		this.id_sponsor = id_sponsor;
	}

	public String getName_sponsor() {
		return this.name_sponsor;
	}

	public void setName_sponsor(String name_sponsor) {
		this.name_sponsor = name_sponsor;
	}

	@OneToMany(mappedBy = "sponsor")
	public List<Contribution> getContributions() {
		return contributions;
	}

	public void setContributions(List<Contribution> contributions) {
		this.contributions = contributions;
	}

	public String getName_contact_sponsor() {
		return name_contact_sponsor;
	}

	public void setName_contact_sponsor(String name_contact_sponsor) {
		this.name_contact_sponsor = name_contact_sponsor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	@ManyToOne
	@JoinColumn(name = "teamSponsor")
	public Team getTeamSponsor() {
		return teamSponsor;
	}

	public void setTeamSponsor(Team teamSponsor) {
		this.teamSponsor = teamSponsor;
	}

}
