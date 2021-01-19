package br.com.festivalNativista.repository;

import br.com.festivalNativista.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Long>, JpaSpecificationExecutor<Login> {

    @Query("FROM Login l WHERE l.codigo = :codigo and l.senha = :senha")
    Login logar(@Param("codigo") String codigo, @Param("senha") String senha);

}
