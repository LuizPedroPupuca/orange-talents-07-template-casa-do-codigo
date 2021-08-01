package br.com.zupacademy.luizpedro.casadocodigo.dto;

import br.com.zupacademy.luizpedro.casadocodigo.controller.validation.ExistId;
import br.com.zupacademy.luizpedro.casadocodigo.controller.validation.UniqueValue;
import br.com.zupacademy.luizpedro.casadocodigo.model.*;
import br.com.zupacademy.luizpedro.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.luizpedro.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class EstadoRequest {


    @NotBlank
    String nome;

    @NotNull @ExistId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public String getNome() {
        return nome;
    }

    public long getIdPais() {
        return idPais;
    }

    public Estado toModel(@Autowired PaisRepository paisRepository) {
        Optional<Pais> autorOptional = paisRepository.findById(this.idPais);
        Pais pais = autorOptional.get();
        return new Estado(this.nome, pais);
    }


}
