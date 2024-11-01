package br.com.gestao_oficina_api.domain.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record OrdemServicoUpdateDTO (

        @NotEmpty(message = "A descrição é obrigatória")
        String descricao,

        @NotEmpty(message = "O status é obrigatório")
        String status,

        @NotNull
        LocalDate dataAbertura,

        List<Long> servicosIds
) {}

