package br.com.zupacademy.luizpedro.casadocodigo.controller;
import br.com.zupacademy.luizpedro.casadocodigo.dto.ClienteRequest;
import br.com.zupacademy.luizpedro.casadocodigo.model.Cliente;
import br.com.zupacademy.luizpedro.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.luizpedro.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.luizpedro.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    ResponseEntity<?> cadastra(@RequestBody @Valid ClienteRequest clienteRequest){
        Cliente cliente = clienteRequest.toModel(paisRepository, estadoRepository);
        clienteRepository.save(cliente);
        return ResponseEntity.ok().build();
    }
}
