package br.com.gestao_oficina_api.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record ClienteCreateDTO(

        @NotEmpty(message = "O nome é obrigatório")
        String nome,

        @NotEmpty(message = "O telefone é obrigatório")
        @Size(min = 11, max = 11, message = "O telefone deve ter 11 dígitos")
        String telefone,

        @NotEmpty(message = "O endereço é obrigatório")
        String endereco,

        @Email(message = "Email deve ser válido")
        String email
) {}

