package br.com.farmacia.repository.impl;

import br.com.farmacia.model.Compra;
import br.com.farmacia.repository.ICompraRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementação em memória, pdoe ser
 */
public class CompraRepositoryMemoria implements ICompraRepository {

    private final List<Compra> compras = new ArrayList<>();

    @Override
    public void salvar(Compra compra) {
        if (compra == null) throw new IllegalArgumentException("Compra não pode ser nula.");
        compras.add(compra);
    }

    @Override
    public List<Compra> listar() {
        return new ArrayList<>(compras);
    }

    @Override
    public List<Compra> listarPorCliente(String nomeCliente) {
        return compras.stream()
                .filter(c -> c.getCliente().getNomeCompleto().equalsIgnoreCase(nomeCliente))
                .collect(Collectors.toList());
    }

    @Override
    public List<Compra> listarPorProduto(String nomeProduto) {
        return compras.stream()
                .filter(c -> c.getProduto().getNome().equalsIgnoreCase(nomeProduto))
                .collect(Collectors.toList());
    }
}

