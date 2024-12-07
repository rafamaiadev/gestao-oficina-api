package br.com.gestao_oficina_api.service;

import br.com.gestao_oficina_api.domain.model.Servico;

import java.math.BigDecimal;
import java.util.List;

public interface IServicoService {

    List<Servico> findAll();
    List<Servico> findAllById(List<Long> ids);
    Servico findById(Long id);
    Servico save(Servico servico);
    void deleteById(Long id);
    BigDecimal sumValorTotalServicos(List<Servico> servicos);
}
