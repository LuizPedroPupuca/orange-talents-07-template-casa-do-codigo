package br.com.zupacademy.luizpedro.casadocodigo.dto;

import br.com.zupacademy.luizpedro.casadocodigo.controller.validation.UniqueValue;
import br.com.zupacademy.luizpedro.casadocodigo.model.Pais;
import javax.validation.constraints.NotBlank;

public class PaisRequest {


    @NotBlank @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais toModel(){
        return  new Pais(this.nome);
    }



}
