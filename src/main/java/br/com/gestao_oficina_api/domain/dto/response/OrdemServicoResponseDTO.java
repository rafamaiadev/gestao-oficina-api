package br.com.gestao_oficina_api.domain.dto.response;

import br.com.gestao_oficina_api.domain.model.Servico;
import br.com.gestao_oficina_api.domain.model.Veiculo;

import java.time.LocalDate;
import java.util.List;

public record OrdemServicoResponseDTO(

        Long id,

        String descricao,

        LocalDate dataAbertura,

        String status,

        Double valorEstimado,

        Veiculo veiculo,

        List<Servico> servicos
) {}

