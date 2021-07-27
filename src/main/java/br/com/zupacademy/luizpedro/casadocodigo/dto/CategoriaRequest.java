package br.com.zupacademy.luizpedro.casadocodigo.dto;

import br.com.zupacademy.luizpedro.casadocodigo.model.Categoria;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    String nome;

    public String getNome() {
        return nome;
    }



    public Categoria converte(CategoriaRequest categoriaRequest){
        return new Categoria(categoriaRequest);
    }
}
