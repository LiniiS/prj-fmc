package br.com.farmacia.service;

import br.com.farmacia.model.Cliente;

import java.util.List;

public interface IClienteService {
    void cadastrarCliente(Cliente cliente);
    Cliente consultarClientePorDocumento(String documento);
    List<Cliente> listarClientes();
    boolean removerCliente(String documento);
}
