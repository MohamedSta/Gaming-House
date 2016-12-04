package tn.esprit.thewalkingdev.services.contract;

 
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.thewalkingdev.entites.Administrator;

@Remote
public interface AdministratorRemote {

	Boolean addAdministrator(Administrator Administrator);

	Boolean updateAdministrator(Administrator Administrator);

	Boolean deleteAdministrator(Administrator Administrator);

	Administrator findAdministratorById(Integer idAdministrator);

	List<Administrator> findAllAdministrators();
	
	Boolean authentifiacation(String login,String password);

	Boolean findBy(String username);
}