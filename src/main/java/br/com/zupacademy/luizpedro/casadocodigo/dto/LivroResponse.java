package br.com.zupacademy.luizpedro.casadocodigo.dto;

import br.com.zupacademy.luizpedro.casadocodigo.model.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroResponse {

    public LivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }


    private Long id;
    private String titulo;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<LivroResponse> toModel(List<Livro> livros){
        return livros.stream().map(LivroResponse::new).collect(Collectors.toList());
    }
}
