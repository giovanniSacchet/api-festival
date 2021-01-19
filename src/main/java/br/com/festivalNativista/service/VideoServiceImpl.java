package br.com.festivalNativista.service;

import br.com.festivalNativista.model.Video;
import br.com.festivalNativista.repository.VideoRepository;
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
    public List<Video> findAllIniciante() {
        return getRepository().findAllIniciante();
    }
}
