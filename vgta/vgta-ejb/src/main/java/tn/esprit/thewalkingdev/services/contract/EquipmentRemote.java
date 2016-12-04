package tn.esprit.thewalkingdev.services.contract;

import java.util.List;

import javafx.scene.chart.PieChart;

import javax.ejb.Remote;

import tn.esprit.thewalkingdev.entites.Equipment;

@Remote
public interface EquipmentRemote {

	Boolean addEquipement(Equipment equipment);
	Boolean updateEquipement(Equipment equipment);
	Boolean deleteEquipement(Equipment equipment);
	Equipment findEquipementById(Integer idEquipement);
	List<Equipment> findAllEquipements();
	List<Equipment> search(Integer keyword);
	

}
