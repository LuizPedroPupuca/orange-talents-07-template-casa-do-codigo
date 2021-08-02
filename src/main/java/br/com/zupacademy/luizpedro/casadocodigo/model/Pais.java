package br.com.zupacademy.luizpedro.casadocodigo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pais {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Deprecated
    public Pais(){}

    public Pais(String nome) {
        this.nome = nome;
    }

    public Pais(Long id){
        this.id = id;
    }

}
