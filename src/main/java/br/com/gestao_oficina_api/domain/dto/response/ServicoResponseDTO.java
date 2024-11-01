package br.com.gestao_oficina_api.domain.dto.response;

import java.math.BigDecimal;

public record ServicoResponseDTO (

        Long id,

        String descricao,

        BigDecimal precoBase,

        Integer duracaoMedia
) {}

