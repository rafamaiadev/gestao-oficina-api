package br.com.gestao_oficina_api.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record ClienteCreateDTO(

        @NotEmpty(message = "O nome é obrigatório")
        String nome,

        @NotEmpty(message = "O telefone é obrigatório")
        String telefone,

        @NotEmpty(message = "O endereço é obrigatório")
        String endereco,

        @Email(message = "Email deve ser válido")
        String email
) {}

