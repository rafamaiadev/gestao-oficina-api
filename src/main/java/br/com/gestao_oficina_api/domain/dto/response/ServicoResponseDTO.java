package br.com.gestao_oficina_api.domain.dto.response;

public record ServicoResponseDTO (

        Long id,

        String descricao,

        Double precoBase,

        Integer duracaoMedia
) {}

