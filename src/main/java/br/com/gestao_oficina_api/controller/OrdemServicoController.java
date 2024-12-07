package br.com.gestao_oficina_api.controller;

import br.com.gestao_oficina_api.domain.dto.request.OrdemServicoCreateDTO;
import br.com.gestao_oficina_api.domain.dto.request.OrdemServicoUpdateDTO;
import br.com.gestao_oficina_api.domain.dto.response.OrdemServicoResponseDTO;
import br.com.gestao_oficina_api.domain.model.OrdemServico;
import br.com.gestao_oficina_api.domain.model.Servico;
import br.com.gestao_oficina_api.domain.model.Veiculo;
import br.com.gestao_oficina_api.exception.ResourceNotFoundException;
import br.com.gestao_oficina_api.mapper.OrdemServicoMapper;
import br.com.gestao_oficina_api.service.IOrdemServicoService;
import br.com.gestao_oficina_api.service.IServicoService;
import br.com.gestao_oficina_api.service.IVeiculoService;
import br.com.gestao_oficina_api.service.impl.OrdemServicoServiceImpl;
import br.com.gestao_oficina_api.service.impl.ServicoServiceImpl;
import br.com.gestao_oficina_api.service.impl.VeiculoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    private final IOrdemServicoService ordemServicoService;
    private final IVeiculoService veiculoService;
    private final IServicoService servicoService;

    public OrdemServicoController(OrdemServicoServiceImpl ordemServicoService, VeiculoServiceImpl veiculoService, ServicoServiceImpl servicoService) {
        this.ordemServicoService = ordemServicoService;
        this.veiculoService = veiculoService;
        this.servicoService = servicoService;
    }

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
