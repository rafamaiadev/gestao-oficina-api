package br.com.gestao_oficina_api.service.impl;

import br.com.gestao_oficina_api.domain.model.Cliente;
import br.com.gestao_oficina_api.exception.ResourceNotFoundException;
import br.com.gestao_oficina_api.repository.ClienteRepository;
import br.com.gestao_oficina_api.service.IClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {


    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O cliente com o id: " + id + " não foi encontrado"));
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {

        findById(id);

        clienteRepository.deleteById(id);
    }
}
