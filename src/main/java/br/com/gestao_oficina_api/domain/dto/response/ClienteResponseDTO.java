package br.com.gestao_oficina_api.domain.dto.response;

public record ClienteResponseDTO(

        Long id,
        String nome,
        String telefone,
        String endereco,
        String email
) {}

