package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;
import java.lang.String;





import java.util.List;

import javax.persistence.*;

@Entity
public class TypeEvent implements Serializable {

	private int id_type;
	private String type_event;
	private List<Events> events;
	private static final long serialVersionUID = 1L;

	public TypeEvent() {
	}

	public TypeEvent(String type_event) {
		super();
		this.type_event = type_event;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_type() {
		return id_type;
	}

	public void setId_type(int id_type) {
		this.id_type = id_type;
	}


	public String getType_event() {
		return type_event;
	}

	public void setType_event(String type_event) {
		this.type_event = type_event;
	}
	
	@OneToMany(mappedBy="typeevent")
	public List<Events> getEvents() {
		return events;
	}

	public void setEvents(List<Events> events) {
		this.events = events;
	}

}
