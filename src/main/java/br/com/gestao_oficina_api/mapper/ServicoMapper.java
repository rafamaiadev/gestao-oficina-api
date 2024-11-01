package br.com.gestao_oficina_api.mapper;

import br.com.gestao_oficina_api.domain.dto.request.ServicoCreateDTO;
import br.com.gestao_oficina_api.domain.dto.request.ServicoUpdateDTO;
import br.com.gestao_oficina_api.domain.dto.response.ServicoResponseDTO;
import br.com.gestao_oficina_api.domain.model.Servico;

import java.util.List;
import java.util.stream.Collectors;

public class ServicoMapper {

    public static Servico toServico(ServicoCreateDTO dto) {

        Servico servico = new Servico();

        servico.setDescricao(dto.descricao());
        servico.setPrecoBase(dto.precoBase());
        servico.setDuracaoMedia(dto.duracaoMedia());

        return servico;
    }

    public static void servicoUpdateProperties(ServicoUpdateDTO dto, Servico servico) {

        if (dto.descricao() != null) servico.setDescricao(dto.descricao());
        if (dto.precoBase() != null) servico.setPrecoBase(dto.precoBase());
        if (dto.duracaoMedia() != null) servico.setDuracaoMedia(dto.duracaoMedia());
    }

    public static ServicoResponseDTO toResponse(Servico servico) {
        return new ServicoResponseDTO(
                servico.getId(),
                servico.getDescricao(),
                servico.getPrecoBase(),
                servico.getDuracaoMedia()
        );
    }

    public static List<ServicoResponseDTO> toResponseList(List<Servico> servicoList) {
        return servicoList.stream()
                .map(ServicoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
