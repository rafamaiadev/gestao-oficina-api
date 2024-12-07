package br.com.gestao_oficina_api.service;

import br.com.gestao_oficina_api.domain.model.OrdemServico;

import java.util.List;

public interface IOrdemServicoService {

    List<OrdemServico> findAll();
    OrdemServico findById(Long id);
    OrdemServico save(OrdemServico ordemServico);
    void deleteById(Long id);
}
