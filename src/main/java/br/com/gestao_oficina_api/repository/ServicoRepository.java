package br.com.gestao_oficina_api.repository;

import br.com.gestao_oficina_api.domain.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
