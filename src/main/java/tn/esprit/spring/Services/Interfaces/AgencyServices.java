package tn.esprit.spring.Services.Interfaces;

import java.util.List;


import tn.esprit.spring.entities.Agency;

public interface AgencyServices {
	List<Agency> retrieveAllAgencies();

	public Agency addAgency(Agency agency);


	public void deleteAgency(Long id);

	public Agency updateAgency(Agency agency);
	public Agency  retrieveAgency(Long id); 


}
