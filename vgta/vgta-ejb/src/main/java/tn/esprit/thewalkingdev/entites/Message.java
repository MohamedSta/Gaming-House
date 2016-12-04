package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Publication
 *
 */
@Entity
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_msg")
	private int idMsg;

	@Lob
	private String message;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="post_time")
	private Date postTime;

	private String title;

	//bi-directional many-to-one association to Gamer
	@ManyToOne
	@JoinColumn(name="id_gamer")
	private Gamer gamer;

	//bi-directional many-to-one association to Topic
	@ManyToOne
	@JoinColumn(name="id_topic")
	private Topic topic;

	public Message() {
	}

	public int getIdMsg() {
		return this.idMsg;
	}

	public void setIdMsg(int idMsg) {
		this.idMsg = idMsg;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getPostTime() {
		return this.postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Gamer getGamer() {
		return this.gamer;
	}

	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}


}
