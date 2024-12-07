package br.com.gestao_oficina_api.service;

import br.com.gestao_oficina_api.domain.filter.VeiculoFilter;
import br.com.gestao_oficina_api.domain.model.Veiculo;

import java.util.List;

public interface IVeiculoService {

    List<Veiculo> findAll();
    List<Veiculo> filterBy(VeiculoFilter filter);
    Veiculo findById(Long id);
    Veiculo save(Veiculo veiculo);
    void deleteById(Long id);
}
