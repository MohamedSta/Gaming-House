package tn.esprit.thewalkingdev.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.thewalkingdev.entites.Events;
import tn.esprit.thewalkingdev.entites.Team;
import tn.esprit.thewalkingdev.services.contract.EventLocal;
import tn.esprit.thewalkingdev.services.contract.EventRemote;

/**
 * Session Bean implementation class GestionEvent
 */
@Stateless
public class EventCrud implements EventRemote, EventLocal {
	@PersistenceContext(unitName = "vgta")
	EntityManager entityManager;

	public EventCrud() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addEvent(Events event) {
		Team teamOrganisation = new Team();
		teamOrganisation.setId_team(3);
		event.setTeam(teamOrganisation);
		entityManager.persist(event);
		return true;

	}

	@Override
	public Boolean updateEvent(Events event) {

		entityManager.merge(event);
		return true;

	}

	@Override
	public Events findEventbyId(Integer idEvent) {
		Events event = null;

		event = entityManager.find(Events.class, idEvent);

		return event;
	}

	@Override
	public List<Events> findAllEvents() {
		Query query = entityManager.createQuery("select e from Event e");
		return query.getResultList();
	}

	@Override
	public void deleteEvent(int  id) {
		entityManager.remove(findEventbyId(id));

	}

}
