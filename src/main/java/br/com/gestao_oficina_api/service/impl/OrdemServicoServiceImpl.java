package br.com.gestao_oficina_api.service.impl;

import br.com.gestao_oficina_api.domain.model.OrdemServico;
import br.com.gestao_oficina_api.exception.ResourceNotFoundException;
import br.com.gestao_oficina_api.repository.OrdemServicoRepository;
import br.com.gestao_oficina_api.service.IOrdemServicoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemServicoServiceImpl implements IOrdemServicoService {


    private final OrdemServicoRepository ordemServicoRepository;

    public OrdemServicoServiceImpl(OrdemServicoRepository ordemServicoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
    }

    @Override
    public List<OrdemServico> findAll() {
        return ordemServicoRepository.findAll();
    }

    @Override
    public OrdemServico findById(Long id) {
        return ordemServicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("A ordem de serviço com o id: " + id + " não foi encontrada"));
    }

    @Override
    public OrdemServico save(OrdemServico ordemServico) {
        return ordemServicoRepository.save(ordemServico);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        ordemServicoRepository.deleteById(id);
    }
}

