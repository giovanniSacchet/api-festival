package br.com.festivalNativista.service;

import br.com.festivalNativista.model.Video;

import java.util.List;

public interface VideoService extends Service<Video> {

    List<Video> findAllProfissional();

    List<Video> findAllRevelacao();

    void deleteAllVideos();

}
