package br.com.zupacademy.luizpedro.casadocodigo.controller;
import br.com.zupacademy.luizpedro.casadocodigo.dto.LivroRequest;
import br.com.zupacademy.luizpedro.casadocodigo.dto.LivroResponseLista;
import br.com.zupacademy.luizpedro.casadocodigo.dto.LivroResponseDetalhe;
import br.com.zupacademy.luizpedro.casadocodigo.model.Livro;
import br.com.zupacademy.luizpedro.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.luizpedro.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.luizpedro.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?> cadastra(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = livroRequest.toModel(categoriaRepository, autorRepository);
        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseLista>> listaLivros() {
        List<Livro> livros = livroRepository.findAll();
        return ResponseEntity.ok().body(LivroResponseLista.toModel(livros));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDetalhe> detalhaLivro(@PathVariable Long id){
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if (livroOptional.isPresent()) {
            Livro livro = livroOptional.get();
            return ResponseEntity.status(HttpStatus.OK).body(new LivroResponseDetalhe(livro));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}