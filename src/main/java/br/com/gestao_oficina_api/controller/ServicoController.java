package br.com.gestao_oficina_api.controller;

import br.com.gestao_oficina_api.domain.dto.request.ServicoCreateDTO;
import br.com.gestao_oficina_api.domain.dto.request.ServicoUpdateDTO;
import br.com.gestao_oficina_api.domain.dto.response.ServicoResponseDTO;
import br.com.gestao_oficina_api.domain.model.OrdemServico;
import br.com.gestao_oficina_api.domain.model.Servico;
import br.com.gestao_oficina_api.exception.ResourceNotFoundException;
import br.com.gestao_oficina_api.mapper.ServicoMapper;
import br.com.gestao_oficina_api.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<ServicoResponseDTO>> getAllServicos() {

        List<Servico> servicos = servicoService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(ServicoMapper.toResponseList(servicos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> getServicoById(@PathVariable Long id) {

        Servico servico = servicoService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(ServicoMapper.toResponse(servico));
    }

    @PostMapping
    public ResponseEntity<ServicoResponseDTO> createServico(@Valid @RequestBody ServicoCreateDTO servicoCreateDTO) {

        Servico servico = ServicoMapper.toServico(servicoCreateDTO);

        servico = servicoService.save(servico);

        return ResponseEntity.status(HttpStatus.CREATED).body(ServicoMapper.toResponse(servico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> updateServico(@PathVariable Long id,
                                                            @Valid @RequestBody ServicoUpdateDTO servicoUpdateDTO) {
        Servico servico = servicoService.findById(id);

        ServicoMapper.servicoUpdateProperties(servicoUpdateDTO, servico);

        servico = servicoService.save(servico);

        return ResponseEntity.status(HttpStatus.OK).body(ServicoMapper.toResponse(servico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServico(@PathVariable Long id) {

        Servico servico = servicoService.findById(id);

        servicoService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}