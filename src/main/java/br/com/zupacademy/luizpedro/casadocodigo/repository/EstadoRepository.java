package br.com.zupacademy.luizpedro.casadocodigo.repository;

import br.com.zupacademy.luizpedro.casadocodigo.model.Autor;
import br.com.zupacademy.luizpedro.casadocodigo.model.Estado;
import br.com.zupacademy.luizpedro.casadocodigo.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Optional<Estado> findByNome(String nome);

    Boolean existsByNomeAndPais_Id(String nome, long idPais);
}
