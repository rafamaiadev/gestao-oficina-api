package br.com.gestao_oficina_api.controller;

import br.com.gestao_oficina_api.domain.dto.request.OrdemServicoCreateDTO;
import br.com.gestao_oficina_api.domain.dto.request.OrdemServicoUpdateDTO;
import br.com.gestao_oficina_api.domain.dto.response.OrdemServicoResponseDTO;
import br.com.gestao_oficina_api.domain.model.OrdemServico;
import br.com.gestao_oficina_api.domain.model.Servico;
import br.com.gestao_oficina_api.domain.model.Veiculo;
import br.com.gestao_oficina_api.exception.ResourceNotFoundException;
import br.com.gestao_oficina_api.mapper.OrdemServicoMapper;
import br.com.gestao_oficina_api.service.OrdemServicoService;
import br.com.gestao_oficina_api.service.ServicoService;
import br.com.gestao_oficina_api.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<OrdemServicoResponseDTO>> getAllOrdensServico() {

        List<OrdemServico> ordensServico = ordemServicoService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(OrdemServicoMapper.toResponseList(ordensServico));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemServicoResponseDTO> getOrdemServicoById(@PathVariable Long id) {

        OrdemServico ordemServico = ordemServicoService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(OrdemServicoMapper.toResponse(ordemServico));
    }

    @PostMapping
    public ResponseEntity<OrdemServicoResponseDTO> createOrdemServico(@Valid @RequestBody OrdemServicoCreateDTO ordemServicoCreateDTO) {

        Veiculo veiculo = veiculoService.findById(ordemServicoCreateDTO.veiculoId());
        List<Servico> servicos = servicoService.findAllById(ordemServicoCreateDTO.servicosIds());

        if (servicos.size() != ordemServicoCreateDTO.servicosIds().size()) {
            throw new ResourceNotFoundException("Um ou mais serviços não foram encontrados.");
        }

        BigDecimal valorEstimado = servicoService.sumValorTotalServicos(servicos);

        OrdemServico ordemServico = OrdemServicoMapper.toOrdemServico(ordemServicoCreateDTO);

        ordemServico.setValorEstimado(valorEstimado);
        ordemServico.setVeiculo(veiculo);
        ordemServico.setServicos(servicos);

        ordemServico = ordemServicoService.save(ordemServico);

        return ResponseEntity.status(HttpStatus.CREATED).body(OrdemServicoMapper.toResponse(ordemServico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdemServicoResponseDTO> updateOrdemServico(@PathVariable Long id,
                                                                      @Valid @RequestBody OrdemServicoUpdateDTO ordemServicoUpdateDTO) {
        OrdemServico ordemServico = ordemServicoService.findById(id);
        List<Servico> servicos = servicoService.findAllById(ordemServicoUpdateDTO.servicosIds());

        if (servicos.size() != ordemServicoUpdateDTO.servicosIds().size()) {
            throw new ResourceNotFoundException("Um ou mais serviços não foram encontrados.");
        }

        BigDecimal valorEstimado = servicoService.sumValorTotalServicos(servicos);

        OrdemServicoMapper.ordemServicoUpdateProperties(ordemServicoUpdateDTO, ordemServico);

        ordemServico.setValorEstimado(valorEstimado);
        ordemServico.setServicos(servicos);

        ordemServico = ordemServicoService.save(ordemServico);

        return ResponseEntity.status(HttpStatus.OK).body(OrdemServicoMapper.toResponse(ordemServico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrdemServico(@PathVariable Long id) {

        ordemServicoService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
