package br.com.gestao_oficina_api.controller;

import br.com.gestao_oficina_api.domain.dto.request.FuncionarioCreateDTO;
import br.com.gestao_oficina_api.domain.dto.request.FuncionarioUpdateDTO;
import br.com.gestao_oficina_api.domain.dto.response.FuncionarioResponseDTO;
import br.com.gestao_oficina_api.domain.model.Funcionario;
import br.com.gestao_oficina_api.exception.ResourceNotFoundException;
import br.com.gestao_oficina_api.mapper.FuncionarioMapper;
import br.com.gestao_oficina_api.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDTO>> getAllFuncionarios() {

        List<Funcionario> funcionarios = funcionarioService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(FuncionarioMapper.toResponseList(funcionarios));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDTO> getFuncionarioById(@PathVariable Long id) {

        Funcionario funcionario = funcionarioService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(FuncionarioMapper.toResponse(funcionario));
    }

    @PostMapping
    public ResponseEntity<FuncionarioResponseDTO> createFuncionario(@Valid @RequestBody FuncionarioCreateDTO funcionarioCreateDTO) {

        Funcionario funcionario = FuncionarioMapper.toFuncionario(funcionarioCreateDTO);

        funcionario = funcionarioService.save(funcionario);

        return ResponseEntity.status(HttpStatus.CREATED).body(FuncionarioMapper.toResponse(funcionario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDTO> updateFuncionario(@PathVariable Long id,
                                                                    @Valid @RequestBody FuncionarioUpdateDTO funcionarioUpdateDTO) {
        Funcionario funcionario = funcionarioService.findById(id);

        FuncionarioMapper.funcionarioUpdateProperties(funcionarioUpdateDTO, funcionario);

        funcionario = funcionarioService.save(funcionario);

        return ResponseEntity.status(HttpStatus.OK).body(FuncionarioMapper.toResponse(funcionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {

        Funcionario funcionario = funcionarioService.findById(id);

        funcionarioService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
