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
    private String nomeAutor;
    private String emailAutor;
    private String descricaoAutor;
    private String nomeCategoria;



    public LivroResponseDetalhe(Livro livro, String nomeAutor, String emailAutor,
                                String descricaoAutor, String nomeCategoria) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.npaginas = livro.getNpaginas();
        this.isbn = livro.getIsbn();
        this.nomeAutor = nomeAutor;
        this.emailAutor = emailAutor;
        this.descricaoAutor = descricaoAutor;
        this.nomeCategoria = nomeCategoria;

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

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getEmailAutor() {
        return emailAutor;
    }

    public String getDescricaoAutor() {
        return descricaoAutor;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public static LivroResponseDetalhe toModel(Livro livro, CategoriaRepository categoriaRepository,
                                               AutorRepository autorRepository) {
        Long idCategoria = livro.getCategoria().getId();
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(idCategoria);
        Categoria categoria = categoriaOptional.get();

        Long idAutor = livro.getAutor().getId();
        Optional<Autor> autorOptional = autorRepository.findById(idAutor);
        Autor autor = autorOptional.get();

        return new LivroResponseDetalhe(livro, autor.getNome(),autor.getEmail(), autor.getDescricao(),
                categoria.getNome());
    }
}
