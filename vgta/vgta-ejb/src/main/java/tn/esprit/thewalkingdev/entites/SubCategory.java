package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CategoryForum
 *
 */
@Entity
public class SubCategory implements Serializable {

	
	private int id_subcategory;
	private String title;
	private Category category;
	private List<Topic> topics;
	private static final long serialVersionUID = 1L;
	

	public SubCategory() {
		super();
	}   

	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_subcategory() {
		return id_subcategory;
	}

	public void setId_subcategory(int id_subcategory) {
		this.id_subcategory = id_subcategory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToOne
	@JoinColumn(name="id_category")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@OneToMany(mappedBy="subCategory")
	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}   
	
	
   
}
