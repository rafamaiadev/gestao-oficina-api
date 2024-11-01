package br.com.gestao_oficina_api.domain.dto.request;

public record ServicoUpdateDTO (

        String descricao,

        Double precoBase,

        Integer duracaoMedia
) {}

