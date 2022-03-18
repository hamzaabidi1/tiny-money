package tn.esprit.spring.entities.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Account;
import tn.esprit.spring.entities.Transaction;

@Repository

public interface AccountRepository extends JpaRepository<Account, Long>{
	@Query(value="select u.email from user u join account a on u.id_user=a.user_id_user\r\n"
			+ "join transaction t on a.id_account=t.account_id_account \r\n"
			+ "where t.amount_transaction > 100000 and t.date_transaction >=\r\n"
			+ "last_day(now()) + interval 1 day - interval 3 month \r\n"
			+ "having count(*)>3", nativeQuery = true)
	List<String> findAllAccountHight();
	@Query(value="select u.email from user u join account a on u.id_user=a.user_id_user\r\n"
			+ "join transaction t on a.id_account=t.account_id_account \r\n"
			+ "where t.amount_transaction < 100000 and t.date_transaction >= \r\n"
			+ "last_day(now()) + interval 1 day - interval 3 month having\r\n"
			+ " count(*)>5", nativeQuery = true)
	List<String> findAllAccountMedium();
	@Query(value="select u.email from user u join account a on u.id_user=a.user_id_user\r\n"
			+ "join transaction t on a.id_account=t.account_id_account \r\n"
			+ "where t.date_transaction >= last_day(now()) + interval 1 day - \r\n"
			+ "interval 12 month having\r\n"
			+ "count(*) < 1", nativeQuery = true)
	List<String> findAllAccountLow();
	
	
	
	/*
	//------------------------------Risque de blanchiment d'arrgent ---------------------------------------------------
	
		//-------Client potentil (count(transaction) dont le mantant de transaction récu dépasse les 100000)>3 dans un intervalle de temps de 3 mois )----------
	@Query("FROM Account  WHERE count((Transaction.Amount >?1))> 3 and now()-Transaction.DateTransaction=1  groupby IDc")
	List<Account> retrieveAccountsByAmount(Amount amount, DateTransaction dateTrasaction);
	
	
		//-------Client fidèle(nbre de transaction récu > 5 pandant 1 mois)
	@Query("SELECT a FROM Account a WHERE count(Transaction.idTransaction)> 3 and now()-Transaction.DateTransaction=1  groupby IDc")
	List<Account> retrieveAccountsBytransactionNumber(DateTransaction dateTrasaction);
	
	
		//-----Client a risque de quitter la banque (si le compte est un compte courant et il n'a pas émis ou récu de transaction durant 1 mois) ------------------
	@Query("SELECT a FROM Account a WHERE count(Account.TypeAccount = ?1) and now()-Transaction.DateTransaction=1  groupby IDc")
	List<Account> retrieveAccountsByTypeAccount(TypeAccount acountType , DateTransaction dateTrasaction);
*/

}
