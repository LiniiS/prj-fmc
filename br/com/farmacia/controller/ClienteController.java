package br.com.farmacia.controller;

import br.com.farmacia.enums.Convenio;
import br.com.farmacia.model.Cliente;
import br.com.farmacia.service.IClienteService;

import java.time.LocalDate;
import java.util.Scanner;

import static br.com.farmacia.ui.ConsoleUtils.*;

public class ClienteController {

    private final IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void menuCliente(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n--- Menu Cliente ---");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Remover cliente");
            System.out.println("0 - Voltar");

            opcao = lerInt(scanner, "Escolha uma opção");

            switch (opcao) {
                case 1 -> cadastrarCliente(scanner);
                case 2 -> listarClientes();
                case 3 -> removerCliente(scanner);
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void cadastrarCliente(Scanner scanner) {
        String nome = lerLinha(scanner, "Nome completo");
        String documento = lerLinha(scanner, "Documento (CPF)");
        String telefone = lerLinha(scanner, "Telefone");
        String email = lerLinha(scanner, "E-mail");
        String endereco = lerLinha(scanner, "Endereço");
        LocalDate nascimento = lerData(scanner, "Data de nascimento");

        System.out.print("Convênio (Plano Bem, Saúde Total, Unimed, Não possui): ");
        Convenio convenio = Convenio.fromDescricao(scanner.nextLine());

        boolean aceitaPromocoes = lerConfirmacao(scanner, "Aceita receber promoções");

        Cliente cliente = new Cliente(nome, nascimento, documento, telefone, email, endereco, convenio, aceitaPromocoes);
        clienteService.cadastrarCliente(cliente);

        System.out.println("Cliente cadastrado com sucesso.");
    }

    private void listarClientes() {
        clienteService.listarClientes()
                .forEach(c -> System.out.println("• " + c.getNomeCompleto() + " (" + c.getDocumento() + ")"));
    }

    private void removerCliente(Scanner scanner) {
        String doc = lerLinha(scanner, "Documento do cliente");
        boolean removido = clienteService.removerCliente(doc);
        System.out.println(removido ? "Cliente removido." : "Cliente não encontrado.");
    }
}
