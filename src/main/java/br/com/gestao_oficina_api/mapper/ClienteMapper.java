package br.com.gestao_oficina_api.mapper;

import br.com.gestao_oficina_api.domain.dto.request.ClienteCreateDTO;
import br.com.gestao_oficina_api.domain.dto.request.ClienteUpdateDTO;
import br.com.gestao_oficina_api.domain.dto.response.ClienteResponseDTO;
import br.com.gestao_oficina_api.domain.model.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteMapper {

    public static Cliente toCliente(ClienteCreateDTO dto) {

        Cliente cliente = new Cliente();

        cliente.setNome(dto.nome());
        cliente.setTelefone(dto.telefone());
        cliente.setEndereco(dto.endereco());
        cliente.setEmail(dto.email());

        return cliente;
    }

    public static void clienteUpdateProperties(ClienteUpdateDTO dto, Cliente cliente) {

        if (dto.nome() != null) cliente.setNome(dto.nome());
        if (dto.telefone() != null) cliente.setTelefone(dto.telefone());
        if (dto.endereco() != null) cliente.setEndereco(dto.endereco());
        if (dto.email() != null) cliente.setEmail(dto.email());
    }

    public static ClienteResponseDTO toResponse(Cliente cliente) {

        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEndereco(),
                cliente.getEmail()
        );
    }

    public static List<ClienteResponseDTO> toResponseList(List<Cliente> clienteList) {
        return clienteList.stream()
                .map(ClienteMapper::toResponse)
                .collect(Collectors.toList());
    }
}
