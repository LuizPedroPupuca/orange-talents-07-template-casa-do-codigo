package br.com.zupacademy.luizpedro.casadocodigo.controller;
import br.com.zupacademy.luizpedro.casadocodigo.dto.LivroRequest;
import br.com.zupacademy.luizpedro.casadocodigo.dto.LivroResponse;
import br.com.zupacademy.luizpedro.casadocodigo.model.Livro;
import br.com.zupacademy.luizpedro.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.luizpedro.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.luizpedro.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public void cadastra(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = livroRequest.toModel(categoriaRepository, autorRepository);
        livroRepository.save(livro);
    }

    @GetMapping
    public List<LivroResponse> listaLivros() {
        List<Livro> livros = livroRepository.findAll();
        return LivroResponse.toModel(livros);
    }
}