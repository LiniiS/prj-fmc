package br.com.farmacia.service.impl;

import br.com.farmacia.model.Funcionario;
import br.com.farmacia.repository.IFuncionarioRepository;
import br.com.farmacia.service.IFuncionarioService;

import java.util.List;

public class FuncionarioServiceImpl implements IFuncionarioService {

    private final IFuncionarioRepository funcionarioRepository;

    public FuncionarioServiceImpl(IFuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public void cadastrarFuncionario(Funcionario funcionario) {
        if (funcionarioRepository.buscarPorNome(funcionario.getNome()) != null) {
            throw new IllegalArgumentException("Funcionário já cadastrado: " + funcionario.getNome());
        }
        funcionarioRepository.salvar(funcionario);
    }

    @Override
    public Funcionario consultarFuncionarioPorNome(String nome) {
        return funcionarioRepository.buscarPorNome(nome);
    }

    @Override
    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.listar();
    }

    @Override
    public boolean removerFuncionario(String nome) {
        return funcionarioRepository.removerPorNome(nome);
    }
}
