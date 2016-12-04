package tn.esprit.thewalkingdev.services.contract;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.thewalkingdev.entites.Events;

@Local
public interface EventLocal {

	Boolean addEvent(Events event);

	Boolean updateEvent(Events event);

	void deleteEvent(int id);

	Events findEventbyId(Integer idEvent);

	List<Events> findAllEvents();
}
