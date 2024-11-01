package br.com.gestao_oficina_api.mapper;

import br.com.gestao_oficina_api.domain.dto.request.VeiculoCreateDTO;
import br.com.gestao_oficina_api.domain.dto.request.VeiculoUpdateDTO;
import br.com.gestao_oficina_api.domain.dto.response.VeiculoResponseDTO;
import br.com.gestao_oficina_api.domain.model.Veiculo;

import java.util.List;
import java.util.stream.Collectors;

public class VeiculoMapper {

    public static Veiculo toVeiculo(VeiculoCreateDTO dto) {

        Veiculo veiculo = new Veiculo();

        veiculo.setPlaca(dto.placa());
        veiculo.setModelo(dto.modelo());
        veiculo.setAnoFabricacao(dto.anoFabricacao());
        veiculo.setTipo(dto.tipo());

        return veiculo;
    }

    public static void veiculoUpdateProperties(VeiculoUpdateDTO dto, Veiculo veiculo) {

        if (dto.modelo() != null) veiculo.setModelo(dto.modelo());
        if (dto.placa() != null) veiculo.setPlaca(dto.placa());
        if (dto.anoFabricacao() != null) veiculo.setAnoFabricacao(dto.anoFabricacao());
        if (dto.tipo() != null) veiculo.setTipo(dto.tipo());
    }

    public static VeiculoResponseDTO toResponse(Veiculo veiculo) {

        return new VeiculoResponseDTO(
                veiculo.getId(),
                veiculo.getModelo(),
                veiculo.getPlaca(),
                veiculo.getAnoFabricacao(),
                veiculo.getTipo(),
                veiculo.getCliente()
        );
    }

    public static List<VeiculoResponseDTO> toResponseList(List<Veiculo> veiculoList) {
        return veiculoList.stream()
                .map(VeiculoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
