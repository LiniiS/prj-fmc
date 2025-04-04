package br.com.farmacia.repository;

import br.com.farmacia.model.Funcionario;

import java.util.List;

public interface IFuncionarioRepository {
    void salvar(Funcionario funcionario);
    Funcionario buscarPorNome(String nome);
    List<Funcionario> listar();
    boolean removerPorNome(String nome);
}
