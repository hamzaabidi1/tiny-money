package tn.esprit.spring.Services.Implementation;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Services.Interfaces.LoanServices;
import tn.esprit.spring.entities.Account;
import tn.esprit.spring.entities.Loan;
import tn.esprit.spring.entities.Repository.LoanRepository;

@Service
public class LoanServicesImpl implements LoanServices {
	@Autowired
	public JavaMailSender emailSender;
	@Autowired
	LoanRepository loanRepo;

	public void NotificationLoan() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -2);
		List<Loan> loans = new ArrayList<Loan>();
		loans = (List<Loan>)(loanRepo.findAll());
		for (int i = 0; i < loans.size(); i++) {
			if (loans.get(i).getDatePayLoan().compareTo(cal.getTime()) == 0) {
				  SimpleMailMessage message = new SimpleMailMessage();
			        message.setTo(loans.get(i).getAccount().getUser().getEmail());
			        message.setSubject("Loan");
			        message.setText("your date pay Loan is in two days");
			        this.emailSender.send(message);
		}
		}

	}

}
