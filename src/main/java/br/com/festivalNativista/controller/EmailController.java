package br.com.festivalNativista.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.festivalNativista.form.EmailForm;
import br.com.festivalNativista.service.EmailService;

@CrossOrigin
@RestController
@RequestMapping("/api/email")
public class EmailController {
	
	@Autowired
	private EmailService service;
	
	@PostMapping
	public ResponseEntity<HttpStatus> sendEmail(@RequestBody @Valid EmailForm form) {
		return service.send(form);
	}
}