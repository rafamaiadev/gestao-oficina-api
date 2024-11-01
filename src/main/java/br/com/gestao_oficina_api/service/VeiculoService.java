package br.com.gestao_oficina_api.service;

import br.com.gestao_oficina_api.domain.filter.VeiculoFilter;
import br.com.gestao_oficina_api.domain.model.Veiculo;
import br.com.gestao_oficina_api.exception.ResourceNotFoundException;
import br.com.gestao_oficina_api.repository.VeiculoRepository;
import br.com.gestao_oficina_api.repository.spec.VeiculoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public List<Veiculo> filter(VeiculoFilter filter) {

        List<Veiculo> veiculos = veiculoRepository.findAll(VeiculoSpecification.filter(filter));

        if (veiculos.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum veículo encontrado com os critérios fornecidos.");
        }

        return veiculos;
    }

    public Veiculo findById(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O veículo com o id: " + id + " não foi encontrado"));
    }

    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void deleteById(Long id) {
        veiculoRepository.deleteById(id);
    }
}
