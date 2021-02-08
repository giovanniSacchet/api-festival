package br.com.festivalNativista.service;

import br.com.festivalNativista.model.Votar;
import br.com.festivalNativista.repository.VotarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotarServiceImpl extends ServiceImpl<Votar> implements VotarService {

    @Autowired
    public VotarServiceImpl(VotarRepository repository) {
        super(repository);
    }

    @Override
    public VotarRepository getRepository() {
        return (VotarRepository) super.getRepository();
    }

    @Override
    public Long contarVotos(Long idVideo) {
        return getRepository().contarVotos(idVideo);
    }
}
