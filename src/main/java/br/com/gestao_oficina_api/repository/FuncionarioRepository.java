package br.com.gestao_oficina_api.repository;

import br.com.gestao_oficina_api.domain.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
