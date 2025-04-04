package br.com.farmacia.service.impl;

import br.com.farmacia.model.Cliente;
import br.com.farmacia.model.Compra;
import br.com.farmacia.model.Funcionario;
import br.com.farmacia.model.Produto;
import br.com.farmacia.repository.ICompraRepository;
import br.com.farmacia.service.ICompraService;

import java.util.Date;
import java.util.List;

public class CompraServiceImpl implements ICompraService {

    private final ICompraRepository compraRepository;

    public CompraServiceImpl(ICompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public Compra realizarCompra(Cliente cliente, Produto produto, Funcionario funcionario, int quantidade) {
        if (quantidade <= 0) throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        if (produto.getQuantidade() < quantidade) {
            throw new IllegalArgumentException("Estoque insuficiente para o produto: " + produto.getNome());
        }

        // Gestão para reduzir estoque diretamente no domínio rico
        produto.reduzirEstoque(quantidade);

        double total = produto.getPreco() * quantidade;
        double desconto = cliente.temConvenio() ? total * 0.1 : 0.0;
        double valorFinal = total - desconto;

        Compra compra = new Compra(funcionario, cliente, produto, desconto, valorFinal, new Date());
        compraRepository.salvar(compra);
        return compra;
    }

    @Override
    public List<Compra> listarTodas() {
        return compraRepository.listar();
    }

    @Override
    public List<Compra> listarPorCliente(String nomeCliente) {
        return compraRepository.listarPorCliente(nomeCliente);
    }

    @Override
    public List<Compra> listarPorProduto(String nomeProduto) {
        return compraRepository.listarPorProduto(nomeProduto);
    }
}
