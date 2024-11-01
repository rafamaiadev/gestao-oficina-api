package br.com.gestao_oficina_api.controller;

import br.com.gestao_oficina_api.domain.dto.request.ClienteCreateDTO;
import br.com.gestao_oficina_api.domain.dto.request.ClienteUpdateDTO;
import br.com.gestao_oficina_api.domain.dto.response.ClienteResponseDTO;
import br.com.gestao_oficina_api.domain.model.Cliente;
import br.com.gestao_oficina_api.mapper.ClienteMapper;
import br.com.gestao_oficina_api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> getAllClientes() {

        List<Cliente> clientes = clienteService.findAll();

        return ResponseEntity.status(HttpStatus.CREATED).body(ClienteMapper.toResponseList(clientes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> getClienteById(@PathVariable Long id) {

        Cliente cliente = clienteService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(ClienteMapper.toResponse(cliente));
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> createCliente(@Valid @RequestBody ClienteCreateDTO clienteCreateDTO) {

        Cliente cliente = ClienteMapper.toCliente(clienteCreateDTO);

        cliente = clienteService.save(cliente);

        return ResponseEntity.status(HttpStatus.OK).body(ClienteMapper.toResponse(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> updateCliente(@PathVariable Long id,
                                                            @Valid @RequestBody ClienteUpdateDTO clienteUpdateDTO) {
        Cliente cliente = clienteService.findById(id);

        ClienteMapper.clienteUpdateProperties(clienteUpdateDTO, cliente);

        cliente = clienteService.save(cliente);

        return ResponseEntity.status(HttpStatus.OK).body(ClienteMapper.toResponse(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {

        clienteService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
