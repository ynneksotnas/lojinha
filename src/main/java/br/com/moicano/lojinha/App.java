package br.com.moicano.lojinha;

import br.com.moicano.lojinha.controller.CategoriaController;
import br.com.moicano.lojinha.controller.ProdutoController;
import br.com.moicano.lojinha.database.DatabaseConnection;
import br.com.moicano.lojinha.view.MenuPrincipalView;

public class App {
    public static void main(String[] args) {

        DatabaseConnection.initDatabase();

        MenuPrincipalView menuView = new MenuPrincipalView();
        ProdutoController produtoController = new ProdutoController();
        CategoriaController categoriaController = new CategoriaController();

        int opcao;
        do {
            opcao = menuView.exibirMenu();

            switch (opcao) {
                case 1 -> produtoController.iniciar();
                case 2 -> categoriaController.iniciar();
                case 0 -> menuView.exibirMensagemEncerramento();
                default -> menuView.exibirErro("Opção inválida!");
            }

        } while (opcao != 0);

        menuView.fechar();
    }
}