package tn.esprit.thewalkingdev.services.contract;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.thewalkingdev.entites.Gamer;

@Local
public interface GamerLocal {
	Boolean addGamer(Gamer gamer);

	Boolean updateGamer(Gamer gamer);

	Boolean deleteGamer(Gamer gamer);

	Gamer findGamerById(Integer idGamer);

	List<Gamer> findAllGamers();

	List<Gamer> searchemail(String email);

	Gamer authentifiacation(String login, String password);

	List<Gamer> searchlastname(String lastname);

	List<Gamer> searchfirstname(String firstname);
	
	double calculNbGamerTeam1();

	double calculNbGamerTeam2();

	double calculNbGamerTeam3();

	double calculNbGamerTeam4();
}
