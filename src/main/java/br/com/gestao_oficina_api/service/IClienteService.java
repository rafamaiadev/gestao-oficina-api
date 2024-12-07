package br.com.gestao_oficina_api.service;

import br.com.gestao_oficina_api.domain.model.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente save(Cliente cliente);
    void deleteById(Long id);
}
