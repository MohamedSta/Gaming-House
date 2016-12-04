package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_article")
	private int idArticle;

	@Lob
	private byte[] image;

	private int nbeNote;

	private int note;

	@Temporal(TemporalType.TIMESTAMP)
	private Date pubDate;

	@Lob
	private String text;

	private String title;

	private String video;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="teamMedia")
	private Team teamMedia;

	public Article() {
	}

	public int getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getNbeNote() {
		return this.nbeNote;
	}

	public void setNbeNote(int nbeNote) {
		this.nbeNote = nbeNote;
	}

	public int getNote() {
		return this.note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Date getPubDate() {
		return this.pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Team getTeam() {
		return this.teamMedia;
	}

	public void setTeam(Team team) {
		this.teamMedia = team;
	}

	
}
