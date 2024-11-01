package br.com.gestao_oficina_api.mapper;

import br.com.gestao_oficina_api.domain.dto.request.FuncionarioCreateDTO;
import br.com.gestao_oficina_api.domain.dto.request.FuncionarioUpdateDTO;
import br.com.gestao_oficina_api.domain.dto.response.FuncionarioResponseDTO;
import br.com.gestao_oficina_api.domain.model.Funcionario;

import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioMapper {

    public static Funcionario toFuncionario(FuncionarioCreateDTO dto) {
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(dto.nome());
        funcionario.setFuncao(dto.funcao());
        funcionario.setTelefone(dto.telefone());
        funcionario.setEmail(dto.email());

        return funcionario;
    }

    public static void funcionarioUpdateProperties(FuncionarioUpdateDTO dto, Funcionario funcionario) {

        if (dto.nome() != null) funcionario.setNome(dto.nome());
        if (dto.funcao() != null) funcionario.setFuncao(dto.funcao());
        if (dto.telefone() != null) funcionario.setTelefone(dto.telefone());
        if (dto.email() != null) funcionario.setEmail(dto.email());
    }

    public static FuncionarioResponseDTO toResponse(Funcionario funcionario) {

        return new FuncionarioResponseDTO(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getFuncao(),
                funcionario.getTelefone(),
                funcionario.getEmail()
        );
    }

    public static List<FuncionarioResponseDTO> toResponseList(List<Funcionario> funcionarioList) {
        return funcionarioList.stream()
                .map(FuncionarioMapper::toResponse)
                .collect(Collectors.toList());
    }
}
