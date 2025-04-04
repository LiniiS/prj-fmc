package br.com.farmacia.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUtils {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Lê confirmação do tipo "sim/não" e retorna boolean
    public static boolean lerConfirmacao(Scanner scanner, String pergunta) {
        System.out.print(pergunta + " (sim/não): ");
        String resposta = scanner.nextLine().trim().toLowerCase();

        return switch (resposta) {
            case "sim", "s", "yes", "y" -> true;
            case "não", "nao", "n", "no" -> false;
            default -> {
                System.out.println("Resposta inválida. Digite 'sim' ou 'não'.");
                yield lerConfirmacao(scanner, pergunta);
            }
        };
    }

    // Lê uma data no formato dd/MM/yyyy com validação
    public static LocalDate lerData(Scanner scanner, String mensagem) {
        System.out.print(mensagem + " (formato dd/MM/yyyy): ");
        String texto = scanner.nextLine().trim();

        try {
            return LocalDate.parse(texto, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida. Tente novamente.");
            return lerData(scanner, mensagem);
        }
    }

    // Lê um número inteiro com validação
    public static int lerInt(Scanner scanner, String mensagem) {
        System.out.print(mensagem + ": ");
        while (!scanner.hasNextInt()) {
            System.out.println("Valor inválido. Digite um número inteiro.");
            scanner.nextLine();
            System.out.print(mensagem + ": ");
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // consome quebra de linha
        return valor;
    }

    // Lê um número decimal com validação
    public static double lerDouble(Scanner scanner, String mensagem) {
        System.out.print(mensagem + ": ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Valor inválido. Digite um número decimal.");
            scanner.nextLine();
            System.out.print(mensagem + ": ");
        }
        double valor = scanner.nextDouble();
        scanner.nextLine(); // consome quebra de linha
        return valor;
    }

    // Lê uma linha não vazia
    public static String lerLinha(Scanner scanner, String mensagem) {
        System.out.print(mensagem + ": ");
        String linha = scanner.nextLine().trim();
        while (linha.isEmpty()) {
            System.out.println("Entrada vazia. Digite novamente.");
            System.out.print(mensagem + ": ");
            linha = scanner.nextLine().trim();
        }
        return linha;
    }
}
