package tn.esprit.thewalkingdev.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.thewalkingdev.entites.Administrator;
import tn.esprit.thewalkingdev.services.contract.AdministratorLocal;
import tn.esprit.thewalkingdev.services.contract.AdministratorRemote;

/**
 * Session Bean implementation class GestionAdministrator
 */
@Stateless
public class AdministratorCrud implements AdministratorRemote,
		AdministratorLocal {
	@PersistenceContext(unitName = "vgta")
	EntityManager entityManager;

	public AdministratorCrud() {
	}

	@Override
	public Boolean addAdministrator(Administrator Administrator) {

		entityManager.persist(Administrator);
		return true;

	}

	@Override
	public Boolean updateAdministrator(Administrator Administrator) {
		try {
			entityManager.merge(Administrator);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteAdministrator(Administrator Administrator) {
		try {
			entityManager.remove(entityManager.merge(Administrator));
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	@Override
	public Administrator findAdministratorById(Integer idAdministrator) {
		Administrator Administrator = null;
		try {
			Administrator = entityManager.find(Administrator.class,
					idAdministrator);
		} catch (Exception e) {
		}
		return Administrator;
	}

	public List<Administrator> findAllAdministrators() {
		Query query = (Query) entityManager
				.createQuery("select g from Administrator g");
		return ((javax.persistence.Query) query).getResultList();

	}

	@Override
	public Boolean authentifiacation(String login, String password) {
		try {
			Administrator Administrator = new Administrator();

			Query query = (Query) entityManager
					.createQuery("select g from Administrator g where g.password=:k and g.username=:j");

			((javax.persistence.Query) query).setParameter("j", login)
					.setParameter("k", password);

			Administrator = (Administrator) ((javax.persistence.Query) query)
					.getSingleResult();

			return true;
		} catch (Exception e) {
return false;
		}
	}

	@Override
	public Boolean findBy(String username) {
		Administrator Administrator = new Administrator();

		try {

			Query query = (Query) entityManager
					.createQuery("select g from Administrator g where g.username=:j");

			((javax.persistence.Query) query).setParameter("j", username);

			Administrator = (Administrator) ((javax.persistence.Query) query)
					.getSingleResult();

			return true;
		} catch (Exception e) {
			return false;
		}
	}

}