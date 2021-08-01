package br.com.zupacademy.luizpedro.casadocodigo.controller;

import br.com.zupacademy.luizpedro.casadocodigo.controller.validation.ErroValidacaoEstadoPais;
import br.com.zupacademy.luizpedro.casadocodigo.dto.EstadoRequest;
import br.com.zupacademy.luizpedro.casadocodigo.dto.LivroRequest;
import br.com.zupacademy.luizpedro.casadocodigo.model.Estado;
import br.com.zupacademy.luizpedro.casadocodigo.model.Livro;
import br.com.zupacademy.luizpedro.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.luizpedro.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastra(@RequestBody @Valid EstadoRequest estadoRequest) {
      Boolean existsStateInCountry = estadoRepository.existsByNomeAndPais_Id(estadoRequest.getNome(),estadoRequest.getIdPais());

      if (existsStateInCountry) {
          return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                  .body(new ErroValidacaoEstadoPais(estadoRequest.getNome(),estadoRequest.getIdPais() ));
      }
      Estado estado = estadoRequest.toModel(paisRepository);
      estadoRepository.save(estado);
      return ResponseEntity.ok().body(estadoRequest);

    }
}
