package br.com.zupacademy.luizpedro.casadocodigo.dto;

import br.com.zupacademy.luizpedro.casadocodigo.controller.validation.UniqueValue;
import br.com.zupacademy.luizpedro.casadocodigo.model.Categoria;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    String nome;

    public String getNome() {
        return nome;
    }



    public Categoria converte(CategoriaRequest categoriaRequest){
        return new Categoria(categoriaRequest);
    }
}
