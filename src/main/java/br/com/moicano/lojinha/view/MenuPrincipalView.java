package br.com.moicano.lojinha.view;

import java.util.Scanner;

public class MenuPrincipalView {
    private final Scanner scanner;

    public MenuPrincipalView() {
        this.scanner = new Scanner(System.in);
    }

    public int exibirMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("E-COMMERCE - SISTEMA DE GERENCIAMENTO");
        System.out.println("=".repeat(50));
        System.out.println("1 - Gerenciar Produtos");
        System.out.println("2 - Gerenciar Categorias");
        System.out.println("0 - Sair");
        System.out.println("=".repeat(50));
        System.out.print("Escolha uma opção: ");

        return lerInteiro();
    }

    public void exibirMensagemEncerramento() {
        System.out.println("\nSaindo...");
    }

    public void exibirErro(String mensagem) {
        System.out.println("ERRO " + mensagem);
    }

    private int lerInteiro() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void fechar() {
        scanner.close();
    }
}