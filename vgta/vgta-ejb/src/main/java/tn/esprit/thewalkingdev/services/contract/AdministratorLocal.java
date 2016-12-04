package tn.esprit.thewalkingdev.services.contract;

 

import java.util.List;

import javax.ejb.Local;

import tn.esprit.thewalkingdev.entites.Administrator;

@Local
public interface AdministratorLocal {
	Boolean addAdministrator(Administrator Administrator);

	Boolean updateAdministrator(Administrator Administrator);

	Boolean deleteAdministrator(Administrator Administrator);

	Administrator findAdministratorById(Integer idAdministrator);

	List<Administrator> findAllAdministrators();
	
	Boolean authentifiacation(String login,String password);
	Boolean findBy(String username);


}