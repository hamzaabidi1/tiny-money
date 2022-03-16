package tn.esprit.spring.Services.Interfaces;

import java.util.List;

import tn.esprit.spring.entities.Account;


public interface AccountServices {
	List<Account> retrieveAllAccounts();
	public Account addAccount(Account account);
	public void deleteAccount(Long id);
	public Account updateAccount(Account account);
	public Account  retrieveAccount(Long id); 

}
