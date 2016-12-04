package tn.esprit.thewalkingdev.services.contract;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.thewalkingdev.entites.Brand;
import tn.esprit.thewalkingdev.entites.TypeEquipment;;

@Remote
public interface TypeEquipmentDAORemote {
	Boolean addTypeEquipment(TypeEquipment typeEquipment);
	Boolean updateTypeEquipment(TypeEquipment typeEquipment);
	Boolean deleteTypeEquipment(TypeEquipment typeEquipment);
	TypeEquipment findTypeEquipmentById(Integer typeEquipment);
	List<TypeEquipment> findAllTypeEquipment();
	List<TypeEquipment> search(String keyword);
}
