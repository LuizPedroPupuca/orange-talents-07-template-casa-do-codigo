package br.com.zupacademy.luizpedro.casadocodigo.dto;


import br.com.zupacademy.luizpedro.casadocodigo.controller.validation.UniqueValue;
import br.com.zupacademy.luizpedro.casadocodigo.model.Autor;
import br.com.zupacademy.luizpedro.casadocodigo.model.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


public class AutorRequest {
    @NotBlank @Email @NotBlank @UniqueValue(domainClass = Autor.class, fieldName = "email")
    String email;

    @NotBlank
    String nome;

    @NotBlank @Length(max = 400)
    String descricao;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor toModel(){
        return new Autor(this.email, this.nome, this.descricao);
    }
}
