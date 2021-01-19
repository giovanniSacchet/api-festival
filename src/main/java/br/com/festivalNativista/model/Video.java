package br.com.festivalNativista.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table(name = "video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotEmpty
    @Column(name = "id_video")
    private String idVideo;

    @NotNull @NotEmpty
    @Column(name = "autor")
    private String autor;

    @NotNull @NotEmpty
    @Column(name = "titulo_musica")
    private String tituloMusica;

    @NotNull @NotEmpty
    @Column(name = "modalidade")
    private boolean modalidade; //True profissional, False iniciante;

    public Video () {
        super();
    }

}
