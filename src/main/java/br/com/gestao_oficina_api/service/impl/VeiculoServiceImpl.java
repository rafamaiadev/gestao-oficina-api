package br.com.gestao_oficina_api.service.impl;

import br.com.gestao_oficina_api.domain.filter.VeiculoFilter;
import br.com.gestao_oficina_api.domain.model.Veiculo;
import br.com.gestao_oficina_api.exception.ResourceNotFoundException;
import br.com.gestao_oficina_api.repository.VeiculoRepository;
import br.com.gestao_oficina_api.repository.spec.VeiculoSpecification;
import br.com.gestao_oficina_api.service.IVeiculoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoServiceImpl implements IVeiculoService {


    private final VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public List<Veiculo> filterBy(VeiculoFilter veiculoFilter) {

        List<Veiculo> veiculos = veiculoRepository.findAll(VeiculoSpecification.filterBy(veiculoFilter));

        if (veiculos.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum veículo encontrado com os critérios fornecidos.");
        }

        return veiculos;
    }

    @Override
    public Veiculo findById(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O veículo com o id: " + id + " não foi encontrado"));
    }

    @Override
    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        veiculoRepository.deleteById(id);
    }
}
