package br.com.farmacia.service.impl;

import br.com.farmacia.model.Produto;
import br.com.farmacia.repository.IProdutoRepository;
import br.com.farmacia.service.IProdutoService;

import java.util.List;

public class ProdutoServiceImpl implements IProdutoService {

    private final IProdutoRepository produtoRepo;

    public ProdutoServiceImpl(IProdutoRepository produtoRepo) {
        this.produtoRepo = produtoRepo;
    }

    @Override
    public void cadastrarProduto(Produto produto) {
        if (produtoRepo.buscarPorNome(produto.getNome()) != null) {
            throw new IllegalArgumentException("Produto já cadastrado: " + produto.getNome());
        }
        produtoRepo.salvar(produto);
    }

    @Override
    public Produto consultarProduto(String nome) {
        return produtoRepo.buscarPorNome(nome);
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepo.listar();
    }

    @Override
    public boolean removerProduto(String nome) {
        return produtoRepo.removerPorNome(nome);
    }
}
