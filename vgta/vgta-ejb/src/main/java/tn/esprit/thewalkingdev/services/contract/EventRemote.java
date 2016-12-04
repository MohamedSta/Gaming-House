package tn.esprit.thewalkingdev.services.contract;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.thewalkingdev.entites.Events;

@Remote
public interface EventRemote {

	Boolean addEvent(Events event);

	Boolean updateEvent(Events event);

	void deleteEvent(int id);

	Events findEventbyId(Integer idEvent);

	List<Events> findAllEvents();
}
