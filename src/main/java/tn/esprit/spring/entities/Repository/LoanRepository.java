package tn.esprit.spring.entities.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Loan;

@Repository

public interface LoanRepository extends CrudRepository<Loan, Long>{

}
