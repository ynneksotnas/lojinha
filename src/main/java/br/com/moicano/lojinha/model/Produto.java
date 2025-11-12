package br.com.moicano.lojinha.model;

public class Produto {
    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidade;
    private Integer categoriaId;
    private String categoriaNome;

    public Produto() {}

    public Produto(String nome, String descricao, Double preco, Integer quantidade, Integer categoriaId) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoriaId = categoriaId;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    @Override
    public String toString() {
        String categoria = categoriaNome != null ? categoriaNome : "Sem categoria";
        return String.format("ID: %d | Nome: %s | Descrição: %s | Preço: R$ %.2f | Estoque: %d | Categoria: %s",
                id, nome, descricao, preco, quantidade, categoria);
    }
}