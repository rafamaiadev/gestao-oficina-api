package br.com.gestao_oficina_api.controller;

import br.com.gestao_oficina_api.domain.dto.request.VeiculoCreateDTO;
import br.com.gestao_oficina_api.domain.dto.request.VeiculoUpdateDTO;
import br.com.gestao_oficina_api.domain.dto.response.VeiculoResponseDTO;
import br.com.gestao_oficina_api.domain.filter.VeiculoFilter;
import br.com.gestao_oficina_api.domain.model.Cliente;
import br.com.gestao_oficina_api.domain.model.Veiculo;
import br.com.gestao_oficina_api.mapper.VeiculoMapper;
import br.com.gestao_oficina_api.service.ClienteService;
import br.com.gestao_oficina_api.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<VeiculoResponseDTO>> getAllVeiculos() {

        List<Veiculo> veiculos = veiculoService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(VeiculoMapper.toResponseList(veiculos));

    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> getVeiculoById(@PathVariable Long id) {

        Veiculo veiculo = veiculoService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(VeiculoMapper.toResponse(veiculo));
    }

    @GetMapping("/filterBy")
    public List<Veiculo> filter(VeiculoFilter filter) {
        return veiculoService.filter(filter);
    }

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> createVeiculo(@Valid @RequestBody VeiculoCreateDTO veiculoCreateDTO) {

        Cliente cliente = clienteService.findById(veiculoCreateDTO.clienteId());

        Veiculo veiculo = VeiculoMapper.toVeiculo(veiculoCreateDTO);
        veiculo.setCliente(cliente);

        veiculo = veiculoService.save(veiculo);

        return ResponseEntity.status(HttpStatus.CREATED).body(VeiculoMapper.toResponse(veiculo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> updateVeiculo(@PathVariable Long id,
                                                            @Valid @RequestBody VeiculoUpdateDTO veiculoUpdateDTO) {
        Veiculo veiculo = veiculoService.findById(id);

        VeiculoMapper.veiculoUpdateProperties(veiculoUpdateDTO, veiculo);

        veiculo = veiculoService.save(veiculo);

        return ResponseEntity.status(HttpStatus.OK).body(VeiculoMapper.toResponse(veiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable Long id) {

        veiculoService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
