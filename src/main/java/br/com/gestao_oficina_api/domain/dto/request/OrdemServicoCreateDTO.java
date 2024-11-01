package br.com.gestao_oficina_api.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record OrdemServicoCreateDTO (

        @NotEmpty(message = "A descrição é obrigatória")
        String descricao,

        @NotEmpty(message = "O status é obrigatório")
        String status,

        @NotNull(message = "O valor estimado é obrigatório")
        Double valorEstimado,

        @NotNull
        LocalDate dataAbertura,

        @NotNull(message = "O veículo associado a ordem de serviço é obrigatório")
        Long veiculoId,

        List<Long> servicosIds
) {}
