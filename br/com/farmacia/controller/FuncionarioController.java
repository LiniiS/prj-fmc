package br.com.farmacia.controller;

import br.com.farmacia.enums.Funcao;
import br.com.farmacia.model.Funcionario;
import br.com.farmacia.service.IFuncionarioService;

import java.util.List;
import java.util.Scanner;

import static br.com.farmacia.ui.ConsoleUtils.*;

public class FuncionarioController {

    private final IFuncionarioService funcionarioService;

    public FuncionarioController(IFuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    public void menuFuncionario(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n--- Menu Funcionário ---");
            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Listar funcionários");
            System.out.println("3 - Consultar por nome");
            System.out.println("4 - Remover por nome");
            System.out.println("0 - Voltar");

            opcao = lerInt(scanner, "Escolha uma opção");

            switch (opcao) {
                case 1 -> cadastrarFuncionario(scanner);
                case 2 -> listarFuncionarios();
                case 3 -> consultarFuncionario(scanner);
                case 4 -> removerFuncionario(scanner);
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void cadastrarFuncionario(Scanner scanner) {
        String nome = lerLinha(scanner, "Nome do funcionário");

        System.out.print("Função (Caixa, Farmacêutico, Gerente, Atendente): ");
        Funcao funcao = Funcao.fromDescricao(scanner.nextLine());

        Funcionario funcionario = new Funcionario(nome, funcao);
        funcionarioService.cadastrarFuncionario(funcionario);

        System.out.println("Funcionário cadastrado com sucesso.");
    }

    private void listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            funcionarios.forEach(f ->
                    System.out.println("• " + f.getNome() + " (" + f.getFuncao().getDescricao() + ")")
            );
        }
    }

    private void consultarFuncionario(Scanner scanner) {
        String nome = lerLinha(scanner, "Nome do funcionário");
        Funcionario funcionario = funcionarioService.consultarFuncionarioPorNome(nome);

        if (funcionario != null) {
            System.out.println("Funcionário: " + funcionario.getNome());
            System.out.println("Função: " + funcionario.getFuncao().getDescricao());
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private void removerFuncionario(Scanner scanner) {
        String nome = lerLinha(scanner, "Nome do funcionário");
        boolean removido = funcionarioService.removerFuncionario(nome);
        System.out.println(removido ? "Funcionário removido com sucesso." : "Funcionário não encontrado.");
    }
}
