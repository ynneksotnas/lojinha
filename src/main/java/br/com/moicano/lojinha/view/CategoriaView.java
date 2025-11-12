package br.com.moicano.lojinha.view;

import br.com.moicano.lojinha.model.Categoria;

import java.util.List;
import java.util.Scanner;

public class CategoriaView {
    private final Scanner scanner;

    public CategoriaView() {
        this.scanner = new Scanner(System.in);
    }

    public int exibirMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("GERENCIAMENTO DE CATEGORIAS");
        System.out.println("=".repeat(50));
        System.out.println("1 - Cadastrar Categoria");
        System.out.println("2 - Listar Categorias");
        System.out.println("3 - Buscar Categoria por ID");
        System.out.println("4 - Atualizar Categoria");
        System.out.println("5 - Remover Categoria");
        System.out.println("0 - Voltar");
        System.out.println("=".repeat(50));
        System.out.print("Escolha uma opção: ");

        return lerInteiro();
    }

    public Categoria lerDadosCategoria() {
        System.out.println("\n--- CADASTRAR CATEGORIA ---");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        return new Categoria(nome, descricao);
    }

    public int lerIdCategoria() {
        System.out.print("Digite o ID da categoria: ");
        return lerInteiro();
    }

    public Categoria lerAtualizacaoCategoria(Categoria categoriaAtual) {
        System.out.println("\n--- ATUALIZAR CATEGORIA ---");
        System.out.println("Categoria atual: " + categoriaAtual);
        System.out.println("\nDigite os novos dados (Enter para manter o atual):");

        System.out.print("Nome [" + categoriaAtual.getNome() + "]: ");
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) categoriaAtual.setNome(nome);

        System.out.print("Descrição [" + categoriaAtual.getDescricao() + "]: ");
        String descricao = scanner.nextLine();
        if (!descricao.isEmpty()) categoriaAtual.setDescricao(descricao);

        return categoriaAtual;
    }

    public boolean confirmarRemocao(Categoria categoria) {
        System.out.println("\n--- REMOVER CATEGORIA ---");
        System.out.println("Categoria: " + categoria);
        System.out.print("Confirma a remoção? (S/N): ");
        String confirmacao = scanner.nextLine();
        return confirmacao.equalsIgnoreCase("S");
    }

    public void exibirCategoria(Categoria categoria) {
        if (categoria != null) {
            System.out.println("\n" + categoria);
        } else {
            exibirErro("Categoria não encontrada!");
        }
    }

    public void exibirListaCategorias(List<Categoria> categorias) {
        System.out.println("\n--- LISTA DE CATEGORIAS ---");
        if (categorias.isEmpty()) {
            System.out.println("Nenhuma categoria cadastrada.");
        } else {
            categorias.forEach(System.out::println);
        }
    }

    public void exibirMensagemSucesso(String mensagem) {
        System.out.println("SUCESSO" + mensagem);
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
}