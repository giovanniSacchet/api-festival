package br.com.festivalNativista.repository;

import br.com.festivalNativista.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LoginRepository extends JpaRepository<Login, Long>, JpaSpecificationExecutor<Login> {
}
