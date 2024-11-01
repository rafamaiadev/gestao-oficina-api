package br.com.gestao_oficina_api.domain.dto.request;

import jakarta.validation.constraints.Email;

public record ClienteUpdateDTO(

        String nome,

        String telefone,

        String endereco,

        @Email(message = "Email deve ser válido")
        String email
) {}

