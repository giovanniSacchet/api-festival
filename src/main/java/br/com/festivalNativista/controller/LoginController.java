package br.com.festivalNativista.controller;
import br.com.festivalNativista.model.Login;
import br.com.festivalNativista.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(value = "/salvar", produces = "application/json;charset=UTF-8")
    public Login save(@Valid @RequestBody Login login) {
        return this.loginService.save(login);
    }

    @PostMapping(value = "/logar", produces = "application/json;charset=UTF-8")
    public Boolean logar(@Valid @RequestBody Login login) {
        return this.loginService.logar(login.getCodigo(), login.getSenha());
    }

}
