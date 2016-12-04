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
public class Category implements Serializable {

	
	private int id_category;
	private String title;
	private List<SubCategory> subCategories;
	private static final long serialVersionUID = 1L;
	

	public Category() {
		super();
	}   
	
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_category() {
		return this.id_category;
	}

	public void setId_category(int id_category) {
		this.id_category = id_category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@OneToMany(mappedBy="category")
	public List<SubCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

   
}
