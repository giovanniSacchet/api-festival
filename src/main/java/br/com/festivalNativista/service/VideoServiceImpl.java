package br.com.festivalNativista.service;

import br.com.festivalNativista.model.Video;
import br.com.festivalNativista.repository.VideoRepository;
import br.com.festivalNativista.repository.VotarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl extends ServiceImpl<Video> implements VideoService{

    @Autowired
    public VideoServiceImpl(VideoRepository repository) {
        super(repository);
    }

    @Override
    public VideoRepository getRepository() {
        return (VideoRepository) super.getRepository();
    }

    @Override
    public List<Video> findAllProfissional() {
        return getRepository().findAllProfissional();
    }

    @Override
    public List<Video> findAllRevelacao() {
        return getRepository().findAllRevelacao();
    }

    @Override
    public void deleteAllVideos() {
        getRepository().deleteAll();
    }
}
