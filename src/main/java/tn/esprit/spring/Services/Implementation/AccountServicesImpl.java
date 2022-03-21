package tn.esprit.spring.Services.Implementation;

import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Account;
import tn.esprit.spring.entities.TypeAccount;
import tn.esprit.spring.entities.Repository.AccountRepository;

@Service
public class AccountServicesImpl {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServicesImpl.class);




		@Autowired
		AccountRepository accountrep;

	
		public List<Account> retrieveAllAccounts() {
			LOGGER.info("IN retrieve all Accounts ");
			List<Account> accounts=(List<Account>) (accountrep.findAll());
		
			return accounts;
		}

	
		public Account addAccount(Account account) {
			LOGGER.info("IN add Account ");
			accountrep.save(account);
			return account;
	
			
		}


		public void deleteAccount(Long id) {
			LOGGER.info("IN delete Account ");
			accountrep.deleteById(id);
	
			
		}

		
		public Account updateUser(Account account) {
			LOGGER.info("IN update Account ");
			accountrep.save(account);
			return account;
		}

		
		public Account retrieveAccount(Long id) {
			
			LOGGER.info("IN retrieve Account ");
			return accountrep.findById(id).get();
		}
		
		public void AddFinancialInterest() {
			LOGGER.info("IN add financial interest of Accounts ");
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







	
	


