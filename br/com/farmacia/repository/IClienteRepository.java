package br.com.farmacia.repository;

import br.com.farmacia.model.Cliente;

import java.util.List;

public interface IClienteRepository {
    void salvar(Cliente cliente);
    Cliente buscarPorDocumento(String documento);
    List<Cliente> listar();
    boolean removerPorDocumento(String documento);
}
