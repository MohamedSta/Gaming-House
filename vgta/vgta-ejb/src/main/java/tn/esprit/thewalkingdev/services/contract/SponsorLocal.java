package tn.esprit.thewalkingdev.services.contract;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import tn.esprit.thewalkingdev.entites.Sponsor;

@Local
public interface SponsorLocal {

	Boolean addSponsor(Sponsor sponsor);

	Boolean updateSponsor(Sponsor sponsor);

	Boolean deleteSponsor(Sponsor sponsor);

	Sponsor findSponsorById(Integer idSponsor);

	List<Sponsor> findAllSponsors();
	List<Sponsor> searchSponsor(String keyword);
}
