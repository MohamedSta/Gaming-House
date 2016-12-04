package tn.esprit.thewalkingdev.services.contract;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.thewalkingdev.entites.Team;

@Local
public interface TeamLocal {

	Boolean addTeam(Team team);

	Boolean updateTeam(Team team);

	Boolean deleteTeam(Team team);

	Team findTeamById(Integer idTeam);

	List<Team> findAllTeams();

	List<String> findAllNameTeamOrganisation();
}
