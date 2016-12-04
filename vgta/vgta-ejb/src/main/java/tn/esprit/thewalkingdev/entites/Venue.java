package tn.esprit.thewalkingdev.entites;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

@Entity
public class Venue implements Serializable {

	private int id_venue;
	private String adress;
	private String city;
	private String longitude;
	private String latitude;
	private List<Events> events;
	private static final long serialVersionUID = 1L;

	public Venue() {
	}


	public Venue(String adress, String city) {
		super();
		this.adress = adress;
		this.city = city;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_venue() {
		return id_venue;
	}


	public void setId_venue(int id_venue) {
		this.id_venue = id_venue;
	}


	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	
	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

	

	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	@OneToMany(mappedBy="venue")
	public List<Events> getEvents() {
		return events;
	}


	public void setEvents(List<Events> events) {
		this.events = events;
	}


	@Override
	public String toString() {
		return "Venue [adress=" + adress + ", city=" + city + "]";
	}


}
