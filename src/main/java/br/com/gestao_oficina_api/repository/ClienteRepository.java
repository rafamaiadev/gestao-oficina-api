package br.com.gestao_oficina_api.repository;

import br.com.gestao_oficina_api.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
