package tn.esprit.spring.entities.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Insurance;

@Repository
public interface InsuranceRepository extends CrudRepository<Insurance, Long> {

}
