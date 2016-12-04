package tn.esprit.thewalkingdev.services.contract;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.thewalkingdev.entites.Sponsor;

@Remote
public interface SponsorRemote {

	Boolean addSponsor(Sponsor sponsor);

	Boolean updateSponsor(Sponsor sponsor);

	Boolean deleteSponsor(Sponsor sponsor);

	Sponsor findSponsorById(Integer idSponsor);

	List<Sponsor> findAllSponsors();
	List<Sponsor> searchSponsor(String keyword);

}
