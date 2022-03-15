package tn.esprit.spring.Services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Services.Interfaces.AgencyServices;
import tn.esprit.spring.entities.Agency;

import tn.esprit.spring.entities.Repository.AgencyRepository;

@Service
public class AgencyServicesImpl implements AgencyServices{
	@Autowired
	AgencyRepository ar;


	public List<Agency> retrieveAllAgencies() {
		List<Agency> agencies=(List<Agency>) (ar.findAll());
	
		return agencies;
	}

	
	public Agency addAgency(Agency agence) {
		ar.save(agence);
		return agence;

		
	}

	
	public void deleteAgency(Long id) {
		ar.deleteById(id);

		
	}


	public Agency updateAgency(Agency agency) {

		ar.save(agency);
		return agency;
	}


	public Agency retrieveAgency(Long id) {
		

		return ar.findById(id).get();
	}

}
