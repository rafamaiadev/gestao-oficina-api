package br.com.gestao_oficina_api.service.impl;

import br.com.gestao_oficina_api.domain.model.Funcionario;
import br.com.gestao_oficina_api.exception.ResourceNotFoundException;
import br.com.gestao_oficina_api.repository.FuncionarioRepository;
import br.com.gestao_oficina_api.service.IFuncionarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements IFuncionarioService {


    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario findById(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("O funcionário com o id: " + id + " não foi encontrado"));
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        funcionarioRepository.deleteById(id);
    }
}

