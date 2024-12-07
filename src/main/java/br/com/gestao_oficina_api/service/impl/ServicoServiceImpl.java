package br.com.gestao_oficina_api.service.impl;

import br.com.gestao_oficina_api.domain.model.Servico;
import br.com.gestao_oficina_api.exception.ResourceNotFoundException;
import br.com.gestao_oficina_api.repository.ServicoRepository;
import br.com.gestao_oficina_api.service.IServicoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ServicoServiceImpl implements IServicoService {


    private final ServicoRepository servicoRepository;

    public ServicoServiceImpl(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    @Override
    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    @Override
    public List<Servico> findAllById(List<Long> ids) {

        return servicoRepository.findAllById(ids);
    }

    @Override
    public Servico findById(Long id) {
        return servicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O serviço com o id: " + id + " não foi encontrado"));
    }

    @Override
    public Servico save(Servico servico) {
        return servicoRepository.save(servico);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        servicoRepository.deleteById(id);
    }

    @Override
    public BigDecimal sumValorTotalServicos(List<Servico> servicos) {

        return servicos.stream()
                .map(Servico::getPrecoBase)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

