package br.com.festivalNativista.repository;

import br.com.festivalNativista.model.Votar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VotarRepository extends JpaRepository<Votar, Long>, JpaSpecificationExecutor<Votar> {
}
