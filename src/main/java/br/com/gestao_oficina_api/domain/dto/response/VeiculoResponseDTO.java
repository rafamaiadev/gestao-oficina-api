package br.com.gestao_oficina_api.domain.dto.response;

import br.com.gestao_oficina_api.domain.model.Cliente;

public record VeiculoResponseDTO (

        Long id,

        String placa,

        String modelo,

        int anoFabricacao,

        String tipo,

        Cliente cliente
) {}

