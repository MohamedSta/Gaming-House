package tn.esprit.thewalkingdev.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.thewalkingdev.entites.Brand;
import tn.esprit.thewalkingdev.entites.TypeEquipment;
import tn.esprit.thewalkingdev.services.contract.TypeEquipmentDAOLocal;
import tn.esprit.thewalkingdev.services.contract.TypeEquipmentDAORemote;

/**
 * Session Bean implementation class TypeEquipementDAO
 */
@Stateless
public class TypeEquipmentCrud implements TypeEquipmentDAORemote,
		TypeEquipmentDAOLocal {

	@PersistenceContext(unitName = "vgta")
	EntityManager entityManager;

	public TypeEquipmentCrud() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addTypeEquipment(TypeEquipment typeEquipment) {

		entityManager.persist(typeEquipment);
		return true;

	}

	@Override
	public Boolean updateTypeEquipment(TypeEquipment typeEquipment) {

		entityManager.merge(typeEquipment);
		return true;

	}

	@Override
	public Boolean deleteTypeEquipment(TypeEquipment typeEquipment) {

		entityManager.remove(entityManager.merge(typeEquipment));
		return true;

	}

	@Override
	public TypeEquipment findTypeEquipmentById(Integer idTypeEquipment) {
		TypeEquipment typeEquipment = null;

		typeEquipment = entityManager
				.find(TypeEquipment.class, idTypeEquipment);

		return typeEquipment;
	}

	@Override
	public List<TypeEquipment> findAllTypeEquipment() {
		Query query = entityManager
				.createQuery("select e from TypeEquipment e");
		return query.getResultList();
	}

	@Override
	public List<TypeEquipment> search(String keyword) {
		Query query = entityManager
				.createQuery("select e from TypeEquipment e where  e.typeEq like :kw");

		query.setParameter("kw", "%" + keyword + "%");

		return query.getResultList();
	}

}
