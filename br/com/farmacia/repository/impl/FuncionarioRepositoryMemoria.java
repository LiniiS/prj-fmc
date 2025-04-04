package br.com.farmacia.repository.impl;

import br.com.farmacia.model.Funcionario;
import br.com.farmacia.repository.IFuncionarioRepository;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepositoryMemoria implements IFuncionarioRepository {

    private final List<Funcionario> funcionarios = new ArrayList<>();

    @Override
    public void salvar(Funcionario funcionario) {
        if (funcionario == null) throw new IllegalArgumentException("Funcionário não pode ser nulo.");
        funcionarios.add(funcionario);
    }

    @Override
    public Funcionario buscarPorNome(String nome) {
        return funcionarios.stream()
                .filter(f -> f.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Funcionario> listar() {
        return new ArrayList<>(funcionarios);
    }

    @Override
    public boolean removerPorNome(String nome) {
        return funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
    }
}
