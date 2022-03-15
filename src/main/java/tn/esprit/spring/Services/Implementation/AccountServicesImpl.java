package tn.esprit.spring.Services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Account;

import tn.esprit.spring.entities.Repository.AccountRepository;

@Service
public class AccountServicesImpl {



		@Autowired
		AccountRepository accountrep;

	
		public List<Account> retrieveAllAccounts() {
			List<Account> accounts=(List<Account>) (accountrep.findAll());
		
			return accounts;
		}

	
		public Account addAccount(Account account) {
			accountrep.save(account);
			return account;
	
			
		}


		public void deleteAccount(Long id) {
			accountrep.deleteById(id);
	
			
		}

		
		public Account updateUser(Account account) {
	
			accountrep.save(account);
			return account;
		}

		
		public Account retrieveAccount(Long id) {
			
	
			return accountrep.findById(id).get();
		}
}







	
	


