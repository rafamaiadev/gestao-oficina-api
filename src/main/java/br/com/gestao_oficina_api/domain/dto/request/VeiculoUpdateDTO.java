package br.com.gestao_oficina_api.domain.dto.request;

import jakarta.validation.constraints.Size;

public record VeiculoUpdateDTO(

        @Size(min = 7, max = 7, message = "A placa deve ter 7 caracteres")
        String placa,

        String modelo,

        Integer anoFabricacao,

        String tipo,

        Long clienteId
) {}

