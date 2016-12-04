package tn.esprit.thewalkingdev.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.thewalkingdev.entites.Administrator;
import tn.esprit.thewalkingdev.entites.Gamer;
import tn.esprit.thewalkingdev.services.contract.GamerLocal;
import tn.esprit.thewalkingdev.services.contract.GamerRemote;

/**
 * Session Bean implementation class GestionGamer
 */
@Stateless
public class GamerCrud implements GamerRemote, GamerLocal {
	@PersistenceContext(unitName = "vgta")
	EntityManager entityManager;

	public GamerCrud() {
	}

	@Override
	public Boolean addGamer(Gamer gamer) {
		
			entityManager.persist(gamer);
			return true;

	}

	@Override
	public Boolean updateGamer(Gamer gamer) {
	
			entityManager.merge(gamer);
			return true;

	}

	@Override
	public Boolean deleteGamer(Gamer gamer) {
		
			entityManager.remove(entityManager.merge(gamer));
			return true;

	}

	@Override
	public Gamer findGamerById(Integer idGamer) {
		Gamer gamer = null;

			gamer = entityManager.find(Gamer.class, idGamer);
		
		return gamer;
	}

	@Override
	public List<Gamer> findAllGamers() {
		System.out.println("cjcj");
		Query query = (Query) entityManager
				.createQuery("select g from Gamer g");
		return ((javax.persistence.Query) query).getResultList();

	}

	@Override
	public Gamer authentifiacation(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gamer> searchemail(String email) {
 
		Query query = (Query) entityManager
				.createQuery("select g from Gamer g where g.email=:S");

		((javax.persistence.Query) query).setParameter("S", email);
				 
 
		return ((javax.persistence.Query) query).getResultList();
	}

	@Override
	public List<Gamer> searchlastname(String lastname) {

		Query query = (Query) entityManager
				.createQuery("select g from Gamer g where g.lastName=:S");

		((javax.persistence.Query) query).setParameter("S", lastname);
				 
 
		return ((javax.persistence.Query) query).getResultList();
	}

	 
 

	@Override
	public List<Gamer> searchfirstname(String firstname) {
	 

			Query query = (Query) entityManager
					.createQuery("select g from Gamer g where g.firstName=:S");

			((javax.persistence.Query) query).setParameter("S", firstname);
					 
	 
			return ((javax.persistence.Query) query).getResultList();
		 		 
	}

	@Override
	public double calculNbGamerTeam1() {
		Query query = (Query) entityManager
				.createQuery("select count(*) as Logistics from Gamer where team=1");
		Long result1 = (Long) query.getSingleResult();
		double res = result1.doubleValue();

		return res;
	}

	@Override
	public double calculNbGamerTeam2() {
		Query query = (Query) entityManager
				.createQuery("select count(*) as Media from Gamer where team=2");
		Long result1 = (Long) query.getSingleResult();
		double res = result1.doubleValue();

		return res;
	}

	@Override
	public double calculNbGamerTeam3() {
		Query query = (Query) entityManager
				.createQuery("select count(*) as Organisation from Gamer where team=3");
		Long result1 = (Long) query.getSingleResult();
		double res = result1.doubleValue();

		return res;
	}

	@Override
	public double calculNbGamerTeam4() {
		Query query = (Query) entityManager
				.createQuery("select count(*) as Sponsoring from Gamer where team=4");
		Long result1 = (Long) query.getSingleResult();
		double res = result1.doubleValue();

		return res;
	}

}
