package tn.esprit.spring.entities.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Agency;

@Repository

public interface AgencyRepository extends CrudRepository<Agency, Long>{

}
