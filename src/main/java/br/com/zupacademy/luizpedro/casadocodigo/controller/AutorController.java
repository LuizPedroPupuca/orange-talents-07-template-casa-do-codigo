package br.com.zupacademy.luizpedro.casadocodigo.controller;


import br.com.zupacademy.luizpedro.casadocodigo.controller.validation.EmailInvalidDuplicate;
import br.com.zupacademy.luizpedro.casadocodigo.dto.AutorRequest;
import br.com.zupacademy.luizpedro.casadocodigo.model.Autor;
import br.com.zupacademy.luizpedro.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public void cadastra (@RequestBody @Valid AutorRequest autorRequest){
        Autor autor = autorRequest.toModel();
        autorRepository.save(autor);

    }

}


