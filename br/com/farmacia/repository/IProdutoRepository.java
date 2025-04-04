package br.com.farmacia.repository;

import br.com.farmacia.model.Produto;

import java.util.List;

public interface IProdutoRepository {
    void salvar(Produto produto);
    Produto buscarPorNome(String nome);
    List<Produto> listar();
    boolean removerPorNome(String nome);
}
