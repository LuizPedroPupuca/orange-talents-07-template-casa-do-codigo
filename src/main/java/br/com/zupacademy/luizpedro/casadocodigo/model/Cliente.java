package br.com.zupacademy.luizpedro.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    private String nome;

    private String sobrenome;

    @Column(unique = true)
    private String documento;

    private String endereco;

    private String complemento;

    private String cidade;

    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;

    private String telefone;

    private String cep;

    public Cliente(String email, String nome, String sobrenome, String documento,
                   String endereco, String complemento, String cidade,
                   Pais pais, @NotNull Estado estado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente(String email, String nome, String sobrenome, String documento,
                   String endereco, String complemento, String cidade,
                   Pais pais, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }
}
