package br.com.festivalNativista.controller;

import br.com.festivalNativista.model.Votar;
import br.com.festivalNativista.service.VotarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votar")
@CrossOrigin
public class VotarController {

    private final VotarService votarService;

    @Autowired
    public VotarController(VotarService votarService) {
        this.votarService = votarService;
    }

    @PostMapping("/cadastrar")
    public Votar saveVotar(@RequestBody Votar votar) {
        return this.votarService.save(votar);
    }

}
