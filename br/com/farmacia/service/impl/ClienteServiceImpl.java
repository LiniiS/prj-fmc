package br.com.farmacia.service.impl;

import br.com.farmacia.model.Cliente;
import br.com.farmacia.repository.IClienteRepository;
import br.com.farmacia.service.IClienteService;

import java.util.List;

public class ClienteServiceImpl implements IClienteService {

    private final IClienteRepository clienteRepository;

    public ClienteServiceImpl(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void cadastrarCliente(Cliente cliente) {
        if (clienteRepository.buscarPorDocumento(cliente.getDocumento()) != null) {
            throw new IllegalArgumentException("Cliente já cadastrado com o documento: " + cliente.getDocumento());
        }
        clienteRepository.salvar(cliente);
    }

    @Override
    public Cliente consultarClientePorDocumento(String documento) {
        return clienteRepository.buscarPorDocumento(documento);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.listar();
    }

    @Override
    public boolean removerCliente(String documento) {
        return clienteRepository.removerPorDocumento(documento);
    }
}
