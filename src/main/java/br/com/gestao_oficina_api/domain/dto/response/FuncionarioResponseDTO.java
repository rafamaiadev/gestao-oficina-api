package br.com.gestao_oficina_api.domain.dto.response;

public record FuncionarioResponseDTO (

        Long id,

        String nome,

        String funcao,

        String telefone,

        String email
) {}

