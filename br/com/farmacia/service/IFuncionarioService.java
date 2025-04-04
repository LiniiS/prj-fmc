package br.com.farmacia.service;

import br.com.farmacia.model.Funcionario;

import java.util.List;

public interface IFuncionarioService {
    void cadastrarFuncionario(Funcionario funcionario);
    Funcionario consultarFuncionarioPorNome(String nome);
    List<Funcionario> listarFuncionarios();
    boolean removerFuncionario(String nome);
}
