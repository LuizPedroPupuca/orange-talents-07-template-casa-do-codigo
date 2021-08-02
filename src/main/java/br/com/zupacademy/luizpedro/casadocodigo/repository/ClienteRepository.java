package br.com.zupacademy.luizpedro.casadocodigo.repository;

import br.com.zupacademy.luizpedro.casadocodigo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
