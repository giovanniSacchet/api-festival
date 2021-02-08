package br.com.festivalNativista.repository;

import br.com.festivalNativista.model.Votar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VotarRepository extends JpaRepository<Votar, Long>, JpaSpecificationExecutor<Votar> {

    @Query(value = "SELECT COUNT(*) FROM votar where id_video = :idVideo", nativeQuery = true)
    Long contarVotos(@Param("idVideo") Long idVideo);

}
