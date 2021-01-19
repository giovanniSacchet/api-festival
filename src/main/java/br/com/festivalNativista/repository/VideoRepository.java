package br.com.festivalNativista.repository;

import br.com.festivalNativista.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long>, JpaSpecificationExecutor<Video> {

    @Query("SELECT v FROM Video v WHERE v.modalidade = true")
    List<Video> findAllProfissional();

    @Query("SELECT v FROM Video v WHERE v.modalidade = false")
    List<Video> findAllIniciante();

}
