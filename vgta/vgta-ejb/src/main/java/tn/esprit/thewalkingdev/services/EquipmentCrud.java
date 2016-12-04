package tn.esprit.thewalkingdev.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.thewalkingdev.entites.Equipment;
import tn.esprit.thewalkingdev.entites.Team;
import tn.esprit.thewalkingdev.services.contract.EquipmentLocal;
import tn.esprit.thewalkingdev.services.contract.EquipmentRemote;

/**
 * Session Bean implementation class EquipementDAO
 */
@Stateless
public class EquipmentCrud implements EquipmentRemote, EquipmentLocal {
	@PersistenceContext(unitName = "vgta")
	EntityManager entityManager;

	public EquipmentCrud() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addEquipement(Equipment equipment) {
		Team t = new Team();
		t.setId_team(1);
		equipment.setTeamLogistics(t);
		entityManager.persist(equipment);
		return true;

	}

	@Override
	public Boolean updateEquipement(Equipment equipment) {

		entityManager.merge(equipment);
		return true;

	}

	@Override
	public Boolean deleteEquipement(Equipment equipment) {

		entityManager.remove(entityManager.merge(equipment));
		return true;

	}

	@Override
	public Equipment findEquipementById(Integer idEquipement) {
		Equipment equipment = null;

		equipment = entityManager.find(Equipment.class, idEquipement);

		return equipment;
	}

	@Override
	public List<Equipment> findAllEquipements() {
		Query query = entityManager.createQuery("select e from Equipment e");
		return query.getResultList();
	}

	@Override
	public List<Equipment> search(Integer keyword) {
		Query query = entityManager.createQuery("select e from Equipment e where  e.quantity like :kw");

		query.setParameter("kw", "%"+keyword+"%");
		
				
		return query.getResultList();
	}

}
