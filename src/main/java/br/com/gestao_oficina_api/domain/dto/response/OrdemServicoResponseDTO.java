package br.com.gestao_oficina_api.domain.dto.response;

import br.com.gestao_oficina_api.domain.model.Servico;
import br.com.gestao_oficina_api.domain.model.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record OrdemServicoResponseDTO(

        Long id,

        String descricao,

        LocalDate dataAbertura,

        String status,

        BigDecimal valorEstimado,

        Veiculo veiculo,

        List<Servico> servicos
) {}

