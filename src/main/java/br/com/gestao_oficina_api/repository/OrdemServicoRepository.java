package br.com.gestao_oficina_api.repository;

import br.com.gestao_oficina_api.domain.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
}
