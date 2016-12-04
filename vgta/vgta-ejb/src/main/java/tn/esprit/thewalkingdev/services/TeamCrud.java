package tn.esprit.thewalkingdev.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.thewalkingdev.entites.Team;
import tn.esprit.thewalkingdev.services.contract.TeamLocal;
import tn.esprit.thewalkingdev.services.contract.TeamRemote;

@Stateless
public class TeamCrud implements TeamLocal, TeamRemote {

	@PersistenceContext(unitName = "vgta")
	EntityManager entityManager;

	@Override
	public Boolean addTeam(Team team) {
		entityManager.persist(team);
		return true;
	}

	@Override
	public Boolean updateTeam(Team team) {
		entityManager.merge(team);
		return true;
	}

	@Override
	public Boolean deleteTeam(Team team) {
		entityManager.remove(team);
		return true;
	}

	@Override
	public Team findTeamById(Integer idTeam) {
		Team team = null;

		team = entityManager.find(Team.class, idTeam);

		return team;
	}

	@Override
	public List<Team> findAllTeams() {
	
		javax.persistence.Query query= entityManager.createQuery("select t from Team t");
		return query.getResultList();
	
	
	}

	@Override
	public List<String> findAllNameTeamOrganisation() {
		javax.persistence.Query query = entityManager.createQuery("select name from team t where t.DTYPE='t_organisation'");
		return query.getResultList();
	}

}
