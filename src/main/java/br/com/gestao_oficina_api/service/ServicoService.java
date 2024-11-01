package br.com.gestao_oficina_api.service;

import br.com.gestao_oficina_api.domain.model.Servico;
import br.com.gestao_oficina_api.exception.ResourceNotFoundException;
import br.com.gestao_oficina_api.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    public List<Servico> findAllById(List<Long> ids) {

        return servicoRepository.findAllById(ids);
    }

    public Servico findById(Long id) {
        return servicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O serviço com o id: " + id + " não foi encontrado"));
    }

    public Servico save(Servico servico) {
        return servicoRepository.save(servico);
    }

    public void deleteById(Long id) {
        servicoRepository.deleteById(id);
    }

    public BigDecimal sumValorTotalServicos(List<Servico> servicos) {

        return servicos.stream()
                .map(Servico::getPrecoBase)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

