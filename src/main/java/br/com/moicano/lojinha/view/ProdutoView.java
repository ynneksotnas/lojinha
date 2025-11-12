package br.com.moicano.lojinha.view;

import br.com.moicano.lojinha.model.Categoria;
import br.com.moicano.lojinha.model.Produto;

import java.util.List;
import java.util.Scanner;

public class ProdutoView {
    private final Scanner scanner;

    public ProdutoView() {
        this.scanner = new Scanner(System.in);
    }

    public int exibirMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("GERENCIAMENTO DE PRODUTOS");
        System.out.println("=".repeat(50));
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Listar Produtos");
        System.out.println("3 - Buscar Produto por ID");
        System.out.println("4 - Atualizar Produto");
        System.out.println("5 - Remover Produto");
        System.out.println("6 - Listar Produtos por Categoria");
        System.out.println("0 - Voltar");
        System.out.println("=".repeat(50));
        System.out.print("Escolha uma opção: ");

        return lerInteiro();
    }

    public Produto lerDadosProduto(List<Categoria> categorias) {
        System.out.println("\n--- CADASTRAR PRODUTO ---");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = lerDouble();

        System.out.print("Quantidade em estoque: ");
        int quantidade = lerInteiro();

        Integer categoriaId = selecionarCategoria(categorias);

        return new Produto(nome, descricao, preco, quantidade, categoriaId);
    }

    public Integer selecionarCategoria(List<Categoria> categorias) {
        if (categorias.isEmpty()) {
            System.out.println("\n Nenhuma categoria cadastrada. Produto será criado sem categoria.");
            return null;
        }

        System.out.println("\n--- SELECIONAR CATEGORIA ---");
        System.out.println("0 - Sem categoria");
        for (Categoria cat : categorias) {
            System.out.println(cat.getId() + " - " + cat.getNome());
        }

        System.out.print("Digite o ID da categoria: ");
        int id = lerInteiro();

        return id == 0 ? null : id;
    }

    public int lerIdProduto() {
        System.out.print("Digite o ID do produto: ");
        return lerInteiro();
    }

    public int lerIdCategoria() {
        System.out.print("Digite o ID da categoria: ");
        return lerInteiro();
    }

    public Produto lerAtualizacaoProduto(Produto produtoAtual, List<Categoria> categorias) {
        System.out.println("\n--- ATUALIZAR PRODUTO ---");
        System.out.println("Produto atual: " + produtoAtual);
        System.out.println("\nDigite os novos dados (Enter para manter o atual):");

        System.out.print("Nome [" + produtoAtual.getNome() + "]: ");
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) produtoAtual.setNome(nome);

        System.out.print("Descrição [" + produtoAtual.getDescricao() + "]: ");
        String descricao = scanner.nextLine();
        if (!descricao.isEmpty()) produtoAtual.setDescricao(descricao);

        System.out.print("Preço [" + produtoAtual.getPreco() + "]: ");
        String precoStr = scanner.nextLine();
        if (!precoStr.isEmpty()) produtoAtual.setPreco(Double.parseDouble(precoStr));

        System.out.print("Quantidade [" + produtoAtual.getQuantidade() + "]: ");
        String quantidadeStr = scanner.nextLine();
        if (!quantidadeStr.isEmpty()) produtoAtual.setQuantidade(Integer.parseInt(quantidadeStr));

        System.out.print("Deseja alterar a categoria? (S/N): ");
        String alterarCategoria = scanner.nextLine();
        if (alterarCategoria.equalsIgnoreCase("S")) {
            Integer categoriaId = selecionarCategoria(categorias);
            produtoAtual.setCategoriaId(categoriaId);
        }

        return produtoAtual;
    }

    public boolean confirmarRemocao(Produto produto) {
        System.out.println("\n--- REMOVER PRODUTO ---");
        System.out.println("Produto: " + produto);
        System.out.print("Confirma a remoção? (S/N): ");
        String confirmacao = scanner.nextLine();
        return confirmacao.equalsIgnoreCase("S");
    }

    public void exibirProduto(Produto produto) {
        if (produto != null) {
            System.out.println("\n" + produto);
        } else {
            exibirErro("Produto não encontrado!");
        }
    }

    public void exibirListaProdutos(List<Produto> produtos) {
        System.out.println("\n--- LISTA DE PRODUTOS ---");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            produtos.forEach(System.out::println);
        }
    }

    public void exibirMensagemSucesso(String mensagem) {
        System.out.println("SUCESSO:" + mensagem);
    }

    public void exibirErro(String mensagem) {
        System.out.println("ERRO: " + mensagem);
    }

    private int lerInteiro() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private double lerDouble() {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}