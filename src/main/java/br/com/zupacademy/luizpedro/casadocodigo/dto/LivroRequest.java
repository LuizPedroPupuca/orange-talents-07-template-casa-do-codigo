package br.com.zupacademy.luizpedro.casadocodigo.dto;

import br.com.zupacademy.luizpedro.casadocodigo.controller.validation.ExistId;
import br.com.zupacademy.luizpedro.casadocodigo.controller.validation.UniqueValue;
import br.com.zupacademy.luizpedro.casadocodigo.model.Autor;
import br.com.zupacademy.luizpedro.casadocodigo.model.Categoria;
import br.com.zupacademy.luizpedro.casadocodigo.model.Livro;
import br.com.zupacademy.luizpedro.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.luizpedro.casadocodigo.repository.CategoriaRepository;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class LivroRequest {

    @NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull @Min(value = 20)
    private BigDecimal preco;

    @NotNull @Min(value = 100)
    private Integer nPaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @NotNull @ExistId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;

    @NotNull @ExistId(domainClass = Categoria.class, fieldName = "id")
    private Long idAutor;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Future
    LocalDate dataPublicacao;

    public Livro toModel(CategoriaRepository categoriaRepository, AutorRepository autorRepository){
        Optional<Autor> autorOptional = autorRepository.findById(idAutor);
        Autor autor = autorOptional.get();
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(idCategoria);
        Categoria categoria = categoriaOptional.get();
        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.nPaginas,
        this.isbn, categoria, autor);
    }

    public LivroRequest(String titulo, String resumo, String sumario, BigDecimal preco, Integer nPaginas, String isbn, Long idCategoria, Long idAutor, LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.nPaginas = nPaginas;
        this.isbn = isbn;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
        this.dataPublicacao = dataPublicacao;
    }
}
