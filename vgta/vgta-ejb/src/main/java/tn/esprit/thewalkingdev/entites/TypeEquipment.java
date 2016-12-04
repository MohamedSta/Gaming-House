package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TypeEquipment
 *
 */
@Entity
public class TypeEquipment implements Serializable {

	private int id;
	private String typeEq;
	private List<Equipment> equipments;
	private static final long serialVersionUID = 1L;

	public TypeEquipment() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeEq() {
		return typeEq;
	}

	public void setTypeEq(String typeEq) {
		this.typeEq = typeEq;
	}

	@OneToMany(mappedBy = "typeEquipment")
	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	@Override
	public String toString() {
		return  typeEq ;
	}

}
