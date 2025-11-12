package br.com.moicano.lojinha.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final ConnectionFactory connectionFactory = H2ConnectionFactory.getInstance();

    public static Connection getConnection() throws SQLException {
        return connectionFactory.getConnection();
    }

    public static void closeConnection(Connection connection) throws SQLException {
        connectionFactory.closeConnection(connection);
    }

    public static void initDatabase() {
        String createCategoriasSQL = """
                CREATE TABLE IF NOT EXISTS categorias (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nome VARCHAR(100) NOT NULL,
                    descricao VARCHAR(255)
                )
                """;

        String createProdutosSQL = """
                CREATE TABLE IF NOT EXISTS produtos (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nome VARCHAR(100) NOT NULL,
                    descricao VARCHAR(255),
                    preco DECIMAL(10, 2) NOT NULL,
                    quantidade INT NOT NULL,
                    categoria_id INT,
                    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
                )
                """;

        Connection conn = null;
        try {
            conn = getConnection();
            Statement stmt = conn.createStatement();

            stmt.execute(createCategoriasSQL);
            stmt.execute(createProdutosSQL);

            System.out.println("SUCESSO: Banco de dados inicializado com sucesso!");
            System.out.println("  Usando: " +
                    ((H2ConnectionFactory) connectionFactory).getUrl());
        } catch (SQLException e) {
            System.err.println("ERRO: Erro ao inicializar banco de dados: " + e.getMessage());
        } finally {
            try {
                closeConnection(conn);
            } catch (SQLException e) {
                System.err.println("ERRO: Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}