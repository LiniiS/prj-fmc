package br.com.farmacia.repository.impl;

import br.com.farmacia.model.Cliente;
import br.com.farmacia.repository.IClienteRepository;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryMemoria implements IClienteRepository {

    private final List<Cliente> clientes = new ArrayList<>();

    @Override
    public void salvar(Cliente cliente) {
        if (cliente == null) throw new IllegalArgumentException("Cliente não pode ser nulo.");
        clientes.add(cliente);
    }

    @Override
    public Cliente buscarPorDocumento(String documento) {
        return clientes.stream()
                .filter(c -> c.getDocumento().equalsIgnoreCase(documento))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Cliente> listar() {
        return new ArrayList<>(clientes);
    }

    @Override
    public boolean removerPorDocumento(String documento) {
        return clientes.removeIf(c -> c.getDocumento().equalsIgnoreCase(documento));
    }
}
