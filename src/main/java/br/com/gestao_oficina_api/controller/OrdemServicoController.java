package br.com.gestao_oficina_api.controller;

import br.com.gestao_oficina_api.domain.dto.request.OrdemServicoCreateDTO;
import br.com.gestao_oficina_api.domain.dto.request.OrdemServicoUpdateDTO;
import br.com.gestao_oficina_api.domain.dto.response.OrdemServicoResponseDTO;
import br.com.gestao_oficina_api.domain.model.OrdemServico;
import br.com.gestao_oficina_api.mapper.OrdemServicoMapper;
import br.com.gestao_oficina_api.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

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

        OrdemServico ordemServico = OrdemServicoMapper.toOrdemServico(ordemServicoCreateDTO);

        ordemServico = ordemServicoService.save(ordemServico);

        return ResponseEntity.status(HttpStatus.OK).body(OrdemServicoMapper.toResponse(ordemServico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdemServicoResponseDTO> updateOrdemServico(@PathVariable Long id,
                                                                      @Valid @RequestBody OrdemServicoUpdateDTO ordemServicoUpdateDTO) {
        OrdemServico ordemServico = ordemServicoService.findById(id);

        OrdemServicoMapper.ordemServicoUpdateProperties(ordemServicoUpdateDTO, ordemServico);

        ordemServico = ordemServicoService.save(ordemServico);

        return ResponseEntity.status(HttpStatus.OK).body(OrdemServicoMapper.toResponse(ordemServico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrdemServico(@PathVariable Long id) {

        ordemServicoService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
