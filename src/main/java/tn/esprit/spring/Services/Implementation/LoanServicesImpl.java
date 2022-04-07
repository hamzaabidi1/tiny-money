package tn.esprit.spring.Services.Implementation;


import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Services.Interfaces.LoanServices;
import tn.esprit.spring.entities.Account;
import tn.esprit.spring.entities.Loan;
import tn.esprit.spring.entities.Repository.AccountRepository;
import tn.esprit.spring.entities.Repository.LoanRepository;

@Service
public class LoanServicesImpl implements LoanServices {
	@Autowired
	public JavaMailSender emailSender;
	@Autowired
	LoanRepository loanRepo;
	@Autowired
	AccountRepository accountRepository;

	@Scheduled(cron = "0 15 10 15 * ?", zone = "Europe/Paris")
	public void NotificationLoan() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -2);
		//List<Loan> loans = new ArrayList<Loan>();
		List<Loan> loans = (List<Loan>)(loanRepo.findAll());
		for (int i = 0; i < loans.size(); i++) {
			if (loans.get(i).getDatePayLoan().compareTo(cal.getTime()) == 0) {
				  SimpleMailMessage message = new SimpleMailMessage();
			        message.setTo(loans.get(i).getAccount().getUser().getEmail());
			        message.setSubject("Loan");
			        message.setText("your date pay Loan is in two days");
			        this.emailSender.send(message);
		}
			if (loans.get(i).getDatePayLoan().compareTo(cal.getTime()) == -2) {
				Account account=accountRepository.findById(loans.get(i).getAccount().getIdAccount()).get();
				account.setTotalAccount(loans.get(i).getMontant());
			}
		}

	}

}
