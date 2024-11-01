package br.com.gestao_oficina_api.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record ClienteUpdateDTO(

        String nome,

        @Size(min = 11, max = 11, message = "O telefone deve ter 11 dígitos")
        String telefone,

        String endereco,

        @Email(message = "Email deve ser válido")
        String email
) {}

