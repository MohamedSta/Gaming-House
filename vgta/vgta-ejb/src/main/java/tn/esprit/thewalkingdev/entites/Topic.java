package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Topic implements Serializable {

	private int id_topic;
	private String title;
	private Date post_time;
	private SubCategory subCategory;
	private Gamer gamer;
	private List<Message> messages;
	private static final long serialVersionUID = 1L;
	
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_topic() {
		return id_topic;
	}
	
	public void setId_topic(int id_topic) {
		this.id_topic = id_topic;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getPost_time() {
		return post_time;
	}
	
	public void setPost_time(Date post_time) {
		this.post_time = post_time;
	}
	
	@ManyToOne
	@JoinColumn(name="id_subcategory")
	public SubCategory getSubCategory() {
		return subCategory;
	}
	
	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
	
	@ManyToOne
	@JoinColumn(name="id_gamer")
	public Gamer getGamer() {
		return gamer;
	}
	
	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}
	
	@OneToMany(mappedBy="topic")
	public List<Message> getMessages() {
		return messages;
	}
	
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	
}
