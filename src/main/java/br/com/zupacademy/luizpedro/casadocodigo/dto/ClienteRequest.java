package br.com.zupacademy.luizpedro.casadocodigo.dto;

import br.com.zupacademy.luizpedro.casadocodigo.controller.validation.Documento;
import br.com.zupacademy.luizpedro.casadocodigo.controller.validation.UniqueValue;
import br.com.zupacademy.luizpedro.casadocodigo.model.Cliente;
import br.com.zupacademy.luizpedro.casadocodigo.model.Estado;
import br.com.zupacademy.luizpedro.casadocodigo.model.Livro;
import br.com.zupacademy.luizpedro.casadocodigo.model.Pais;
import br.com.zupacademy.luizpedro.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.luizpedro.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ClienteRequest {

    @NotBlank @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank @Documento
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    private Long idPais;
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;{
    }

    public ClienteRequest(String email, String nome, String sobrenome,
                          String documento, String endereco, String complemento,
                          String cidade, Long idPais, Long idEstado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Cliente toModel(@Autowired PaisRepository paisRepository, @Autowired EstadoRepository estadoRepository){
        Optional<Pais> paisOptional = paisRepository.findById(this.idPais);
        Pais pais = paisOptional.get();
        if(this.idEstado == null)
            return new Cliente(email, nome, sobrenome, documento,
                    endereco, complemento, cidade,
                    pais,telefone, cep);
        Optional<Estado> estadoOptional = estadoRepository.findById(this.idEstado);
        Estado estado = estadoOptional.get();
        return new Cliente(email, nome, sobrenome, documento,
                endereco, complemento, cidade,
                pais, estado, telefone, cep);
    }
}
