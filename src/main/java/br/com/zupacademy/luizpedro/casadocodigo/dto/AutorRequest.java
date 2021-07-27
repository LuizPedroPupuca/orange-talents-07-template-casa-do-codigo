package br.com.zupacademy.luizpedro.casadocodigo.dto;


import br.com.zupacademy.luizpedro.casadocodigo.model.Autor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


public class AutorRequest {


    @NotBlank @Email
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

    public Autor converte(AutorRequest autorRequest){
        return new Autor(autorRequest);
    }
}
