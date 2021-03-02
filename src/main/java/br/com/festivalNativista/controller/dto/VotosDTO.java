package br.com.festivalNativista.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VotosDTO {
    private String nome;
    private long votos;

    public VotosDTO(String nome, Long votos) {
        this.nome = nome;
        this.votos = votos;
    }
}
