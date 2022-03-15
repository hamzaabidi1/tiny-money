package tn.esprit.spring.entities.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Complaint;

@Repository

public interface ComplaintRepository extends CrudRepository<Complaint, Long> {

}
