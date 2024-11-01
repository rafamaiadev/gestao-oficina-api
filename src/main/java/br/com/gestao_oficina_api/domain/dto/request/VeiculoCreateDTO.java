package br.com.gestao_oficina_api.domain.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record VeiculoCreateDTO (

        @NotEmpty(message = "A placa é obrigatória")
        @Size(min = 7, max = 7, message = "A placa deve ter 7 caracteres")
        String placa,

        @NotEmpty(message = "O modelo é obrigatório")
        String modelo,

        @NotNull(message = "O ano de fabricação é obrigatório")
        Integer anoFabricacao,

        @NotEmpty(message = "O tipo de veículo é obrigatório")
        String tipo,

        @NotNull(message = "O cliente associado ao veículo é obrigatório")
        Long clienteId
) {}