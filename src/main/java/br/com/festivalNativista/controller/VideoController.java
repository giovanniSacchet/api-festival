package br.com.festivalNativista.controller;

import br.com.festivalNativista.model.Video;
import br.com.festivalNativista.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/videos")
public class VideoController {

    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
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
    public Video save (@RequestBody @Valid Video video) {
        video.setIdVideo(getYouTubeId(video.getIdVideo()));
        if (video.getIdVideo() != "false") {
            return videoService.save(video);
        }
        return null;
    }

    @GetMapping("/profissional")
    public List<Video> getAllVideosProfissional() {
        return this.videoService.findAllProfissional();
    }

    @GetMapping("/revelacao")
    public List<Video> getAllVideosRevelacao() {
        return this.videoService.findAllRevelacao();
    }

}
