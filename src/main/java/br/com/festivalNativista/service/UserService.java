package br.com.festivalNativista.service;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.festivalNativista.FestivalNativistaApplication;
import br.com.festivalNativista.form.UserForm;
import br.com.festivalNativista.model.User;
import br.com.festivalNativista.repository.UserRepository;

@Service
public class UserService {
	
	private static Logger logger = LoggerFactory.getLogger(FestivalNativistaApplication.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public ResponseEntity<User> CadastrarUsuario(@Valid UserForm form) {
		logger.info("Cadastro de um novo usuario");
		
		String encodedSenha = bCryptPasswordEncoder.encode(form.getSenha());
		
		User novoUsuario = form.converter(encodedSenha);
		
		try {
			Optional<User> verificaUsuario =  userRepository.findByEmail("admin@festivalcancaonativistars.com.br");
			if(verificaUsuario.isPresent()) {
				logger.info("Usuario ja existente");
				return ResponseEntity.badRequest().build();
			}
				
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		try {
			userRepository.save(novoUsuario);
			logger.info("Usuario cadastrado com sucesso");
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
