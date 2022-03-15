package tn.esprit.spring.entities.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	@Query("FROM Transaction ORDER BY AmountTransaction ASC")
	List<Transaction> findAllOrderByAmountTransactionAsc();
	@Query("FROM Transaction ORDER BY AmountTransaction DESC")
	List<Transaction> findAllOrderByAmountTransactionDesc();
	List<Transaction> findAllByTypeTransactionLike(String TypeTransaction);
	List<Transaction> findAllByTransactionNatureLike(String TransactionNature);
	
	/*
	//------------------------------Risque de blanchiment d'arrgent ---------------------------------------------------
	
		//-------Client potentil (count(transaction) dont le mantant de transaction récu dépasse les 100000)>3 dans un intervalle de temps de 3 mois )----------
	@Query("SELECT a FROM Account a WHERE count((Transaction.Amount >?1))> 3 and now()-Transaction.DateTransaction=1  groupby IDc")
	List<Account> retrieveAccountsByAmount(Amount amount, DateTransaction dateTrasaction);
	
	
		//-------Client fidèle(nbre de transaction récu > 5 pandant 1 mois)
	@Query("SELECT a FROM Account a WHERE count(Transaction.idTransaction)> 3 and now()-Transaction.DateTransaction=1  groupby IDc")
	List<Account> retrieveAccountsBytransactionNumber(DateTransaction dateTrasaction);
	
	
		//-----Client a risque de quitter la banque (si le compte est un compte courant et il n'a pas émis ou récu de transaction durant 1 mois) ------------------
	@Query("SELECT a FROM Account a WHERE count(Account.TypeAccount = ?1) and now()-Transaction.DateTransaction=1  groupby IDc")
	List<Account> retrieveAccountsByTypeAccount(TypeAccount acountType , DateTransaction dateTrasaction);
*/

}
