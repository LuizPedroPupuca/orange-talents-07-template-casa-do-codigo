package br.com.zupacademy.luizpedro.casadocodigo.controller;

import br.com.zupacademy.luizpedro.casadocodigo.controller.validation.NomeInvalidDuplicate;
import br.com.zupacademy.luizpedro.casadocodigo.dto.CategoriaRequest;
import br.com.zupacademy.luizpedro.casadocodigo.model.Categoria;
import br.com.zupacademy.luizpedro.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private NomeInvalidDuplicate nomeInvalidDuplicate;

    @InitBinder
    public void init(WebDataBinder binder){

        binder.addValidators(nomeInvalidDuplicate);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastra(@RequestBody @Valid CategoriaRequest categoriaRequest){
        Categoria categoria = categoriaRequest.converte(categoriaRequest);
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }

}
