package br.com.farmacia.repository.impl;

import br.com.farmacia.model.Produto;
import br.com.farmacia.repository.IProdutoRepository;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositoryMemoria implements IProdutoRepository {

    private final List<Produto> produtos = new ArrayList<>();

    @Override
    public void salvar(Produto produto) {
        if (produto == null) throw new IllegalArgumentException("Produto não pode ser nulo.");
        produtos.add(produto);
    }

    @Override
    public Produto buscarPorNome(String nome) {
        return produtos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    //retornar a lista de forma segura
    @Override
    public List<Produto> listar() {
        return new ArrayList<>(produtos);
    }

    @Override
    public boolean removerPorNome(String nome) {
        return produtos.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
    }
}
