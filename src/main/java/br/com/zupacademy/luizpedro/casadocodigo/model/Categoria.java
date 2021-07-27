package br.com.zupacademy.luizpedro.casadocodigo.model;

import br.com.zupacademy.luizpedro.casadocodigo.dto.CategoriaRequest;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Deprecated
    public Categoria(){}

    public Categoria(CategoriaRequest categoriaRequest){
        this.nome = categoriaRequest.getNome();
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank @Column(unique = true)
    String nome;

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
