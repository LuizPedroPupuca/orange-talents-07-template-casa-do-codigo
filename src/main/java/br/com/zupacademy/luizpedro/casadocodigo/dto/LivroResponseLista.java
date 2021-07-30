package br.com.zupacademy.luizpedro.casadocodigo.dto;

import br.com.zupacademy.luizpedro.casadocodigo.model.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroResponseLista {

    public LivroResponseLista(Livro livro) {
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

    public static List<LivroResponseLista> toModel(List<Livro> livros){
        return livros.stream().map(LivroResponseLista::new).collect(Collectors.toList());
    }
}
