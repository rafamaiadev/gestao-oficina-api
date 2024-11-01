package br.com.gestao_oficina_api.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record FuncionarioCreateDTO (

        @NotEmpty(message = "O nome é obrigatório")
        String nome,

        @NotEmpty(message = "A função é obrigatória")
        String funcao,

        @NotEmpty(message = "O telefone é obrigatório")
        String telefone,

        @Email(message = "Email deve ser válido")
        String email
) {}

