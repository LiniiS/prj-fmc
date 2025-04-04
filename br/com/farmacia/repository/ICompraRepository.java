package br.com.farmacia.repository;

import br.com.farmacia.model.Compra;

import java.util.List;

public interface ICompraRepository {
    void salvar(Compra compra);
    List<Compra> listar();
    List<Compra> listarPorCliente(String nomeCliente);
    List<Compra> listarPorProduto(String nomeProduto);
}
