package tn.esprit.thewalkingdev.services.contract;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.thewalkingdev.entites.Team;

@Remote
public interface TeamRemote {

	Boolean addTeam(Team team);

	Boolean updateTeam(Team team);

	Boolean deleteTeam(Team team);

	Team findTeamById(Integer idTeam);

	List<Team> findAllTeams();

	List<String> findAllNameTeamOrganisation();
}
