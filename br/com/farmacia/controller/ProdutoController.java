package br.com.farmacia.controller;

import br.com.farmacia.enums.Categoria;
import br.com.farmacia.model.Produto;
import br.com.farmacia.service.IProdutoService;

import java.util.List;
import java.util.Scanner;

import static br.com.farmacia.ui.ConsoleUtils.*;

public class ProdutoController {

    private final IProdutoService produtoService;

    public ProdutoController(IProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public void menuProduto(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n--- Menu Produto ---");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Consultar produto por nome");
            System.out.println("4 - Remover produto por nome");
            System.out.println("0 - Voltar");

            opcao = lerInt(scanner, "Escolha uma opção");

            switch (opcao) {
                case 1 -> cadastrarProduto(scanner);
                case 2 -> listarProdutos();
                case 3 -> consultarProduto(scanner);
                case 4 -> removerProduto(scanner);
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void cadastrarProduto(Scanner scanner) {
        String nome = lerLinha(scanner, "Nome do produto");

        System.out.print("Categoria (Medicamento, Skin Care, Higiene Pessoal, Utilidades, Outra): ");
        Categoria categoria = Categoria.fromDescricao(scanner.nextLine());

        double preco = lerDouble(scanner, "Preço");
        int quantidade = lerInt(scanner, "Quantidade em estoque");
        var dataAquisicao = lerData(scanner, "Data da última aquisição");
        String fornecedor = lerLinha(scanner, "Fornecedor");

        Produto produto = new Produto(nome, categoria, preco, quantidade, dataAquisicao, fornecedor);
        produtoService.cadastrarProduto(produto);

        System.out.println("Produto cadastrado com sucesso.");
    }

    private void listarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            produtos.forEach(p -> System.out.println("• " + p.getNome() + " | Estoque: " + p.getQuantidade()));
        }
    }

    private void consultarProduto(Scanner scanner) {
        String nome = lerLinha(scanner, "Nome do produto");
        Produto produto = produtoService.consultarProduto(nome);

        if (produto != null) {
            System.out.println("Produto encontrado:");
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Categoria: " + produto.getCategoria().getDescricao());
            System.out.println("Preço: R$" + produto.getPreco());
            System.out.println("Estoque: " + produto.getQuantidade());
            System.out.println("Fornecedor: " + produto.getFornecedor());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void removerProduto(Scanner scanner) {
        String nome = lerLinha(scanner, "Nome do produto");
        boolean removido = produtoService.removerProduto(nome);
        System.out.println(removido ? "Produto removido com sucesso." : "Produto não encontrado.");
    }
}
