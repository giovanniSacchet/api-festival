package br.com.festivalNativista.controller;

import br.com.festivalNativista.controller.dto.VotosDTO;
import br.com.festivalNativista.model.Video;
import br.com.festivalNativista.model.Votar;
import br.com.festivalNativista.service.VideoService;
import br.com.festivalNativista.service.VotarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<VotosDTO> getVotos() {
        List<Video> videos = videoService.findAll();
        Long numVotos;
        List<VotosDTO> listDTO = new ArrayList<>();
        VotosDTO dto;
        for(int i = 0; i < videos.size(); i++) {
            numVotos = votarService.contarVotos(videos.get(i).getId());
            if (numVotos != 0) {
                dto = new VotosDTO(videos.get(i).getTituloMusica(), numVotos);
                listDTO.add(dto);
            }
        }
        //this.votarService.zerarVotacao(); //Habilitar essa linha para zerar votacao;
        return listDTO;
    }

    @PostMapping("/cadastrar")
    public Votar saveVotar(@RequestBody Votar votar) {
        return this.votarService.save(votar);
    }

}
