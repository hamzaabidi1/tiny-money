package tn.esprit.spring.Services.Implementation;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Account;
import tn.esprit.spring.entities.TypeAccount;
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
		
		public void AddFinancialInterest() {
			List<Account> accounts = accountrep.findAll();
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -365);
			Calendar cal1 = Calendar.getInstance();
			cal1.add(Calendar.DATE, -30);
			for (int i = 0; i < accounts.size(); i++) {
				if (accounts.get(i).getTypeAccount()==TypeAccount.Savings) {
					if(accounts.get(i).getDateLastFinancialInterest().compareTo(cal.getTime())==0) {
						accounts.get(i).setDateLastFinancialInterest(cal.getTime());
						accounts.get(i).setTotalAccount((float) (accounts.get(i).getTotalAccount()*1.04));
					}
				}
				if (accounts.get(i).getTypeAccount()==TypeAccount.CurrentAccount) {
					accounts.get(i).setDateLastFinancialInterest(cal1.getTime());
					accounts.get(i).setTotalAccount((float) (accounts.get(i).getTotalAccount()*1.012));
				}
				
				
			}
			
			
		}
}







	
	


