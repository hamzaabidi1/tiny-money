package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Services.Interfaces.AgencyServices;
import tn.esprit.spring.entities.Agency;


@RestController
public class AgencyController {
	
	@Autowired
	AgencyServices as;
	
	  @GetMapping("getAllAgencies")
	    public List<Agency> getAllAgencies() {			
			return as.retrieveAllAgencies();
		}
	 @GetMapping("retrieve-agency/{agencyId}")
	    public Agency retrieveAgency(@PathVariable("agencyId") Long agencyId) {
	    return as.retrieveAgency(agencyId);
	    } 
		@PostMapping("/addAgency")
		public Agency addAgency(@RequestBody Agency agence)
			{	as.addAgency(agence);
			return agence;
			}
		@DeleteMapping("/deleteagency/{agnecyId}")
		public void deleteUser(@PathVariable("agencyId")Long agencyId){
			as.deleteAgency(agencyId);
			
		}
		@PutMapping("/PutAgency")
		public Agency updateAgency(@RequestBody Agency agence){
			Agency ags=as.updateAgency(agence);
			return ags;}
	

}
