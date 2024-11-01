package br.com.gestao_oficina_api.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ServicoCreateDTO (

        @NotEmpty(message = "A descrição é obrigatória")
        String descricao,

        @NotNull(message = "O preço base é obrigatório")
        Double precoBase,

        @NotNull(message = "A duração média é obrigatória")
        Integer duracaoMedia
) {}

