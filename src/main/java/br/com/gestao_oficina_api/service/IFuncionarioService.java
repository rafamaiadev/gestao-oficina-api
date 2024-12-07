package br.com.gestao_oficina_api.service;

import br.com.gestao_oficina_api.domain.model.Funcionario;

import java.util.List;

public interface IFuncionarioService {

    List<Funcionario> findAll();
    Funcionario findById(Long id);
    Funcionario save(Funcionario funcionario);
    void deleteById(Long id);
}
