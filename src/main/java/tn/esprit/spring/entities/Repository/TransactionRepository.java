package tn.esprit.spring.entities.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Transaction;
import tn.esprit.spring.entities.TransactionNature;
import tn.esprit.spring.entities.TypeTransaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
	
	@Query("FROM Transaction ORDER BY AmountTransaction ASC")
	List<Transaction> findAllOrderByAmountTransactionAsc();
	@Query("FROM Transaction ORDER BY AmountTransaction DESC")
	List<Transaction> findAllOrderByAmountTransactionDesc();
	@Query("FROM Transaction WHERE TypeTransaction=?1")
	List<Transaction> findAllByTypeTransaction(String typeTransaction);
	@Query("FROM Transaction WHERE TransactionNature=?1")
	List<Transaction> findAllByTransactionNature(String transactionNature);
	


}
