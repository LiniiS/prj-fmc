package br.com.farmacia;

import br.com.farmacia.controller.*;
import br.com.farmacia.repository.impl.*;
import br.com.farmacia.service.impl.*;
import br.com.farmacia.ui.MenuUI;

public class Main {
    public static void main(String[] args) {
        var clienteService = new ClienteServiceImpl(new ClienteRepositoryMemoria());
        var produtoService = new ProdutoServiceImpl(new ProdutoRepositoryMemoria());
        var compraService = new CompraServiceImpl(new CompraRepositoryMemoria());
        var funcionarioService = new FuncionarioServiceImpl(new FuncionarioRepositoryMemoria());

        var clienteController = new ClienteController(clienteService);
        var produtoController = new ProdutoController(produtoService);
        var compraController = new CompraController(compraService, clienteService, produtoService, funcionarioService);
        var funcionarioController = new FuncionarioController(funcionarioService);

        var menuUI = new MenuUI(clienteController, produtoController, compraController, funcionarioController);
        menuUI.exibirMenu();
    }
}
