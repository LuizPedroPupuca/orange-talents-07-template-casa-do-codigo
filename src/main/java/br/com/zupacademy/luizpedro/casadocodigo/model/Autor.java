package br.com.zupacademy.luizpedro.casadocodigo.model;


import br.com.zupacademy.luizpedro.casadocodigo.dto.AutorRequest;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Deprecated
    public Autor(){ }


    public Autor(AutorRequest cadastraAutorDto){
        this.email = cadastraAutorDto.getEmail();
        this.nome = cadastraAutorDto.getNome();
        this.descricao = cadastraAutorDto.getDescricao();
    }




    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime data = LocalDateTime.now();

    @NotBlank @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank @Length(max = 400)
    private String descricao;

    public Long getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}

