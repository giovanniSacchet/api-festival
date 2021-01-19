package br.com.festivalNativista.service;

import br.com.festivalNativista.model.Login;
import br.com.festivalNativista.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<Login> implements LoginService {

    @Autowired
    public LoginServiceImpl(LoginRepository repository) {
        super(repository);
    }

    @Override
    public LoginRepository getRepository() {
        return (LoginRepository) super.getRepository();
    }

    @Override
    public Login save(Login login) {
        login.setSenha(login.codificar(login.getSenha()));
        return getRepository().save(login);
    }

    @Override
    public Boolean logar(String codigo, String senha) {
        //criptografa a senha na class para comparar com o banco
        Login login = new Login(codigo, senha);
        Login validar = getRepository().logar(login.getCodigo(), login.getSenha());
        if (validar != null) {
            return true;
        }
        return false;
    }
}
