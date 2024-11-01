package br.com.gestao_oficina_api.domain.dto.request;

import java.math.BigDecimal;

public record ServicoUpdateDTO (

        String descricao,

        BigDecimal precoBase,

        Integer duracaoMedia
) {}

