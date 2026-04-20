package br.com.wallace.exercicio03.domain;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(Cliente cliente) { 
        this.cliente = cliente; 
    }

    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
    }

    // Getters e Setters
    public Cliente getCliente() {
        return cliente;
    }
    public List<ItemPedido> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido do Cliente: ").append(cliente.getNome()).append("\n");
        sb.append("Itens:\n");

        for (ItemPedido item : itens) {
            sb.append("- ").append(item.toString()).append("\n");
        }
        return sb.toString();
    }
}