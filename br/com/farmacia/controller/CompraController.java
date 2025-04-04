package br.com.farmacia.controller;

import br.com.farmacia.model.Cliente;
import br.com.farmacia.model.Compra;
import br.com.farmacia.model.Funcionario;
import br.com.farmacia.model.Produto;
import br.com.farmacia.service.*;

import java.util.List;
import java.util.Scanner;

import static br.com.farmacia.ui.ConsoleUtils.*;

public class CompraController {

    private final ICompraService compraService;
    private final IClienteService clienteService;
    private final IProdutoService produtoService;
    private final IFuncionarioService funcionarioService;

    public CompraController(
            ICompraService compraService,
            IClienteService clienteService,
            IProdutoService produtoService,
            IFuncionarioService funcionarioService
    ) {
        this.compraService = compraService;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
        this.funcionarioService = funcionarioService;
    }

    public void menuCompra(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n--- Menu Compra ---");
            System.out.println("1 - Realizar compra");
            System.out.println("2 - Listar todas as compras");
            System.out.println("3 - Listar compras por cliente");
            System.out.println("4 - Listar compras por produto");
            System.out.println("0 - Voltar");

            opcao = lerInt(scanner, "Escolha uma opção");

            switch (opcao) {
                case 1 -> realizarCompra(scanner);
                case 2 -> listarTodas();
                case 3 -> listarPorCliente(scanner);
                case 4 -> listarPorProduto(scanner);
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void realizarCompra(Scanner scanner) {
        String docCliente = lerLinha(scanner, "Documento do cliente");
        Cliente cliente = clienteService.consultarClientePorDocumento(docCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        String nomeProduto = lerLinha(scanner, "Nome do produto");
        Produto produto = produtoService.consultarProduto(nomeProduto);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        int quantidade = lerInt(scanner, "Quantidade desejada");
        if (produto.getQuantidade() < quantidade) {
            System.out.println("Estoque insuficiente.");
            return;
        }

        String nomeFuncionario = lerLinha(scanner, "Nome do funcionário (caixa)");
        Funcionario funcionario = funcionarioService.consultarFuncionarioPorNome(nomeFuncionario);
        if (funcionario == null) {
            System.out.println("Funcionário não encontrado.");
            return;
        }

        try {
            Compra compra = compraService.realizarCompra(cliente, produto, funcionario, quantidade);
            System.out.println("Compra realizada com sucesso!");
            System.out.println("Valor total: R$" + compra.getValorTotal() + " (Desconto: R$" + compra.getValorDesconto() + ")");
        } catch (Exception e) {
            System.out.println("Erro ao realizar compra: " + e.getMessage());
        }
    }

    private void listarTodas() {
        List<Compra> compras = compraService.listarTodas();
        if (compras.isEmpty()) {
            System.out.println("Nenhuma compra registrada.");
            return;
        }
        compras.forEach(this::exibirResumo);
    }

    private void listarPorCliente(Scanner scanner) {
        String doc = lerLinha(scanner, "Documento do cliente");
        List<Compra> compras = compraService.listarPorCliente(doc);
        if (compras.isEmpty()) {
            System.out.println("Nenhuma compra encontrada para este cliente.");
            return;
        }
        compras.forEach(this::exibirResumo);
    }

    private void listarPorProduto(Scanner scanner) {
        String nome = lerLinha(scanner, "Nome do produto");
        List<Compra> compras = compraService.listarPorProduto(nome);
        if (compras.isEmpty()) {
            System.out.println("Nenhuma compra encontrada para este produto.");
            return;
        }
        compras.forEach(this::exibirResumo);
    }

    private void exibirResumo(Compra compra) {
        System.out.println("Compra #" + compra.getNumeroCompra() +
                " | Produto: " + compra.getProduto().getNome() +
                " | Cliente: " + compra.getCliente().getNomeCompleto() +
                " | Valor: R$" + compra.getValorTotal() +
                " | Data: " + compra.getData());
    }
}
