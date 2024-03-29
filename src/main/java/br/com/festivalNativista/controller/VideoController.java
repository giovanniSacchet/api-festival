package br.com.festivalNativista.controller;

import br.com.festivalNativista.model.Video;
import br.com.festivalNativista.service.VideoService;
import br.com.festivalNativista.service.VotarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/videos")
public class VideoController {

    private final VideoService videoService;
    private final VotarService votarService;


    @Autowired
    public VideoController(VideoService videoService, VotarService votarService) {
        this.videoService = videoService;
        this.votarService = votarService;
    }

    private String getYouTubeId (String youTubeUrl) {
        String pattern = "(?<=youtu.be/|watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(youTubeUrl);
        if (matcher.find()) {
            return matcher.group();
        } else {
            return "false";
        }
    }

    @PostMapping(value = "/cadastrar", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Video> save (@RequestBody @Valid Video video) {
        video.setIdVideo(getYouTubeId(video.getIdVideo()));
        if (video.getIdVideo() != "false") {
            return ResponseEntity.status(HttpStatus.OK).body(videoService.save(video));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

//    @GetMapping(value = "/deleteAll", produces = "application/json;charset=UTF-8")
//    public Video deleteAllVideos () {
//        List<Video> videos = new ArrayList<>();
//        Long numVotos;
//        for(int i = 0; i < videos.size(); i++) {
//            numVotos = this.votarService.contarVotos(videos.get(i).getId());
//            if (numVotos != 0) {
//                this.votarService.zerarVotosByIdVideo(videos.get(i).getId());
//            }
//        }
//        this.videoService.deleteAllVideos();
//        return new Video();
//    }

//    @GetMapping(value = "/editar", produces = "application/json;charset=UTF-8")
//    public Video updateVideo() {
//        Video video = new Video();
//        video.setId(Long.valueOf(3));
//        video.setIdVideo("sYZuxF1y3to");
//        video.setAutor("Enio Dias Santos Filho");
//        video.setTituloMusica("O Centauro sem rumo (Nativista)");
//        video.setModalidade(false);
//        return this.videoService.save(video);
//    }

    @GetMapping("/profissional")
    public List<Video> getAllVideosProfissional() {
        return this.videoService.findAllProfissional();
    }

    @GetMapping("/revelacao")
    public List<Video> getAllVideosRevelacao() {
        return this.videoService.findAllRevelacao();
    }

}
