package br.com.festivalNativista.service;

import br.com.festivalNativista.model.Login;

public interface LoginService extends Service<Login> {
    Boolean logar(String codigo, String senha);
}