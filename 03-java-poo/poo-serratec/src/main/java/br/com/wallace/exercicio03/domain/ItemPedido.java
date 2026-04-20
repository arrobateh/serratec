package br.com.wallace.exercicio03.domain;

public class ItemPedido {
    private String produto;
    private double preco;
    private int quantidade;

    public ItemPedido(String produto, double preco, int quantidade) {
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return preco * quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
