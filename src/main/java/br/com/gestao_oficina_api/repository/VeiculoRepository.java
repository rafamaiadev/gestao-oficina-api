package br.com.gestao_oficina_api.repository;

import br.com.gestao_oficina_api.domain.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
