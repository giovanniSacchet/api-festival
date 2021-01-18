package br.com.festivalNativista.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.festivalNativista.form.EmailForm;

@Service
public class EmailService {
	
	private JavaMailSender JavaMailSender;
	
	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.JavaMailSender = javaMailSender;
	}

	public ResponseEntity<HttpStatus> send(EmailForm form) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("contato@festivalcancaonativistars.com.br");
		mail.setSubject("Contato Festival Cancao Nativista");
		mail.setText(form.getMailBody());
		
		try {
			JavaMailSender.send(mail);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch(MailException ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
