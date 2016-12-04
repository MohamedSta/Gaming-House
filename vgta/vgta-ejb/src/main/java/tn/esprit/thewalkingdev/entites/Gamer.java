package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Gamer implements Serializable {

	private String lastName;
	private int id;
	private String firstName;
	private Integer age;
	private int numtel;
	private boolean hasVoted;
	private boolean isAccepted;
    private Team team;
    private byte[]  image;
	private String email;
	private String pwd;
	private int rank;
	private int record;
	private Role role;
	private static final long serialVersionUID = 1L;
	private List<Message> publications;
	private List<Trophy> trophies;

	public Gamer(String lastName, int id, String firstName, Integer age,
			int numtel, boolean hasvoted, boolean isAccepted, byte[] image,
			String email, String pwd, int rank, int record, Role role,
			Team team, List<Message> publications, List<Trophy> trophies,
			List<Vote> votes) {
		super();
		this.lastName = lastName;
		this.id = id;
		this.firstName = firstName;
		this.age = age;
		this.numtel = numtel;
		this.hasVoted = hasvoted;
		this.isAccepted = isAccepted;
		this.image = image;
		this.email = email;
		this.pwd = pwd;
		this.rank = rank;
		this.record = record;
		this.role = role;
		this.team = team;
		this.publications = publications;
		this.trophies = trophies;
	}

	public int getNumtel() {
		return numtel;
	}

	public void setNumtel(int numtel) {
		this.numtel = numtel;
	}
	
	
	public Gamer() {
	}
	
	public Gamer(String lastName, int id, String firstName, Integer age,
			String email, String pwd, int rank, int record, Role role,
			Team team, List<Message> publications, List<Trophy> trophies,
			List<Vote> votes) {
		super();
		this.lastName = lastName;
		this.id = id;
		this.firstName = firstName;
		this.age = age;
		this.email = email;
		this.pwd = pwd;
		this.rank = rank;
		this.record = record;
		this.role = role;
		this.team = team;
		this.publications = publications;
		this.trophies = trophies;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id_Gamer) {
		this.id = id_Gamer;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getRank() {
		return this.rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRecord() {
		return this.record;
	}

	public void setRecord(int record) {
		this.record = record;
	}

	@OneToMany(mappedBy = "gamer")
	public List<Message> getPublications() {
		return publications;
	}

	public void setPublications(List<Message> publications) {
		this.publications = publications;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne
	@JoinColumn(name="team")
	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}

	@OneToMany(mappedBy = "gamer")
	public List<Trophy> getTrophies() {
		return trophies;
	}
	@Lob
	@Basic(fetch=FetchType.LAZY)
	public byte[]  getImage() {
		return image;
	}
	
	public void setImage(byte[]  image) {
		this.image = image;
	}

	public void setTrophies(List<Trophy> trophies) {
		this.trophies = trophies;
	}

	
	public Gamer(String lastName, String firstName, String email, Role role) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.role = role;
	}

	public boolean isHasvoted() {
		return hasVoted;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setHasvoted(boolean hasvoted) {
		this.hasVoted = hasvoted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public boolean isHasVoted() {
		return hasVoted;
	}


	public void setHasVoted(boolean hasVoted) {
		this.hasVoted = hasVoted;
	}


	
}