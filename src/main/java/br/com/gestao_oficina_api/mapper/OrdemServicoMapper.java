package br.com.gestao_oficina_api.mapper;

import br.com.gestao_oficina_api.domain.dto.request.OrdemServicoCreateDTO;
import br.com.gestao_oficina_api.domain.dto.request.OrdemServicoUpdateDTO;
import br.com.gestao_oficina_api.domain.dto.response.OrdemServicoResponseDTO;
import br.com.gestao_oficina_api.domain.model.OrdemServico;

import java.util.List;
import java.util.stream.Collectors;

public class OrdemServicoMapper {

    public static OrdemServico toOrdemServico(OrdemServicoCreateDTO dto) {

        OrdemServico ordemServico = new OrdemServico();

        ordemServico.setDescricao(dto.descricao());
        ordemServico.setDataAbertura(dto.dataAbertura());
        ordemServico.setStatus(dto.status());
        ordemServico.setValorEstimado(dto.valorEstimado());;

        return ordemServico;
    }

    public static void ordemServicoUpdateProperties(OrdemServicoUpdateDTO dto, OrdemServico ordemServico) {

        if (dto.descricao() != null) ordemServico.setDescricao(dto.descricao());
        if (dto.status() != null) ordemServico.setStatus(dto.status());
        if (dto.dataAbertura() != null) ordemServico.setDataAbertura(dto.dataAbertura());
        if (dto.valorEstimado() != null) ordemServico.setValorEstimado(dto.valorEstimado());
    }

    public static OrdemServicoResponseDTO toResponse(OrdemServico ordemServico) {

        return new OrdemServicoResponseDTO(
                ordemServico.getId(),
                ordemServico.getDescricao(),
                ordemServico.getDataAbertura(),
                ordemServico.getStatus(),
                ordemServico.getValorEstimado(),
                ordemServico.getVeiculo(),
                ordemServico.getServicos()
        );
    }

    public static List<OrdemServicoResponseDTO> toResponseList(List<OrdemServico> ordemServicoList) {
        return ordemServicoList.stream()
                .map(OrdemServicoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
