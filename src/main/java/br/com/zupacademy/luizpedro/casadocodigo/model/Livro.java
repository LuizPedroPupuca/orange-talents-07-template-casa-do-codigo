package br.com.zupacademy.luizpedro.casadocodigo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
public class Livro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String titulo;
    String resumo;
    String sumario;
    BigDecimal preco;
    Integer npaginas;
    @Column(unique = true)
    String isbn;

    LocalDate dataPublicacao;

    @ManyToOne
    Categoria categoria;

    @ManyToOne
    Autor autor;

    @Deprecated
    public Livro(){}

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer npaginas, String isbn, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.npaginas = npaginas;
        this.isbn = isbn;
        this.categoria = categoria;
        this.autor = autor;
    }

}
