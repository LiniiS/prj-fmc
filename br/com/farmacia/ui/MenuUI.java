// simular a interface web/desktop
package br.com.farmacia.ui;

import br.com.farmacia.controller.ClienteController;
import br.com.farmacia.controller.ProdutoController;
import br.com.farmacia.controller.CompraController;
import br.com.farmacia.controller.FuncionarioController;

import java.util.Scanner;

public class MenuUI {

    private final ClienteController clienteController;
    private final ProdutoController produtoController;
    private final CompraController compraController;
    private final FuncionarioController funcionarioController;

    public MenuUI(
            ClienteController clienteController,
            ProdutoController produtoController,
            CompraController compraController,
            FuncionarioController funcionarioController
    ) {
        this.clienteController = clienteController;
        this.produtoController = produtoController;
        this.compraController = compraController;
        this.funcionarioController = funcionarioController;
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n====== MENU FARMÁCIA ======");
            System.out.println("1 - Gerenciar Clientes");
            System.out.println("2 - Gerenciar Produtos");
            System.out.println("3 - Realizar Compra");
            System.out.println("4 - Gerenciar Funcionários");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            // consome quebra de linha
            scanner.nextLine();

            switch (opcao) {
                case 1 -> clienteController.menuCliente(scanner);
                case 2 -> produtoController.menuProduto(scanner);
                case 3 -> compraController.menuCompra(scanner);
                case 4 -> funcionarioController.menuFuncionario(scanner);
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
