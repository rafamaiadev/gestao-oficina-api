package br.com.gestao_oficina_api.domain.dto.request;

import jakarta.validation.constraints.Email;

public record FuncionarioUpdateDTO (

        String nome,

        String funcao,

        String telefone,

        @Email(message = "Email deve ser válido")
        String email
) {}

