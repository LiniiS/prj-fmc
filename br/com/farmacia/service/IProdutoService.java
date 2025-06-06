package br.com.farmacia.service;

import br.com.farmacia.model.Cliente;
import br.com.farmacia.model.Compra;
import br.com.farmacia.model.Funcionario;
import br.com.farmacia.model.Produto;

import java.util.List;

public interface IProdutoService {
    void cadastrarProduto(Produto produto);
    Produto consultarProduto(String nome);
    List<Produto> listarProdutos();
    boolean removerProduto(String nome);

    interface ICompraService {
        Compra realizarCompra(Cliente cliente, Produto produto, Funcionario funcionario, int quantidade);
        List<Compra> listarTodas();
        List<Compra> listarPorCliente(String nomeCliente);
        List<Compra> listarPorProduto(String nomeProduto);
    }
}
