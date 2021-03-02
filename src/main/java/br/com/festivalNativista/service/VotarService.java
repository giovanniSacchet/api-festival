package br.com.festivalNativista.service;

import br.com.festivalNativista.model.Votar;

public interface VotarService extends Service<Votar>{

    Long contarVotos(Long idVideo);

    void zerarVotosByIdVideo(Long idVideo);

}
