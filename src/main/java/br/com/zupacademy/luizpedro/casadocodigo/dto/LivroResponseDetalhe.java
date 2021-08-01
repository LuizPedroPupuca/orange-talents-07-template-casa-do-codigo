package br.com.zupacademy.luizpedro.casadocodigo.dto;

import br.com.zupacademy.luizpedro.casadocodigo.model.Autor;
import br.com.zupacademy.luizpedro.casadocodigo.model.Categoria;
import br.com.zupacademy.luizpedro.casadocodigo.model.Livro;
import br.com.zupacademy.luizpedro.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.luizpedro.casadocodigo.repository.CategoriaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public class LivroResponseDetalhe {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer npaginas;
    private String isbn;
    private String  autor;


     public LivroResponseDetalhe(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.npaginas = livro.getNpaginas();
        this.isbn = livro.getIsbn();
        this.autor = livro.getAutor().getNome();

     }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNpaginas() {
        return npaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAutor() {
        return autor;
    }
}
