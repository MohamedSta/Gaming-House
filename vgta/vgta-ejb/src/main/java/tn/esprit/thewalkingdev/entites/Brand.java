package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;


@Entity
public class Brand implements Serializable {

	private int id;
	private String brand;
	private List<Equipment> equipements;
	private static final long serialVersionUID = 1L;

	public Brand() {
	}   

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@OneToMany(mappedBy = "brand")
	public List<Equipment> getEquipements() {
		return equipements;
	}

	public void setEquipements(List<Equipment> equipements) {
		this.equipements = equipements;
	}

}
