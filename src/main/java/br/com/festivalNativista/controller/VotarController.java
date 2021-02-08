package br.com.festivalNativista.controller;

import br.com.festivalNativista.model.Video;
import br.com.festivalNativista.model.Votar;
import br.com.festivalNativista.service.VideoService;
import br.com.festivalNativista.service.VotarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/votar")
public class VotarController {

    private final VotarService votarService;

    private final VideoService videoService;

    @Autowired
    public VotarController(VotarService votarService, VideoService videoService) {
        this.votarService = votarService;
        this.videoService = videoService;
    }

    @GetMapping("/votos")
    public Map<Long, String> getVotos() {
        List<Video> videos = videoService.findAll();
        Map<Long,String> hash_map = new HashMap<>();
        Long numVotos;
        for(int i = 0; i < videos.size(); i++) {
            numVotos = votarService.contarVotos(videos.get(i).getId());
            if (numVotos != 0) {
                hash_map.put(numVotos, videos.get(i).getTituloMusica());
            }
        }
        return hash_map;
    }

    @PostMapping("/cadastrar")
    public Votar saveVotar(@RequestBody Votar votar) {
        return this.votarService.save(votar);
    }

}
