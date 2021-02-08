package br.com.festivalNativista.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Getter
@Setter
@Entity
@Table(name = "video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "id_video")
    private String idVideo;

    @NotBlank
    @Column(name = "autor")
    private String autor;

    @NotBlank
    @Column(name = "titulo_musica")
    private String tituloMusica;

    @Column(name = "modalidade")
    private boolean modalidade; //True profissional, False revelação;

    public Video () {
        super();
    }

}
