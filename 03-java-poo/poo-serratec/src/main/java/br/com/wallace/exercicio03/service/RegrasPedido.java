package br.com.wallace.exercicio03.service;

import br.com.wallace.exercicio03.domain.ItemPedido;
import br.com.wallace.exercicio03.domain.Pedido;

public class RegrasPedido {
    public void fecharPedido(Pedido pedido) {
        double totalItenspedido = calcularTotal(pedido);
        double frete = (totalItenspedido > 250.00) ? 0.0 : 25.0;

        imprimirRecibo(pedido, totalItenspedido, frete);
    }

    private double calcularTotal(Pedido pedido) {
        double total = 0.0;
        for (ItemPedido item : pedido.getItens()) {
            total += item.getSubtotal();
        }
        return total;
    }

    private void imprimirRecibo(Pedido pedido, double total, double frete) {
        System.out.println("===== RECIBO =====");
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.print("Produtos: \n");
        for (int i = 0; i < pedido.getItens().size(); i++) {
            ItemPedido item = pedido.getItens().get(i);
            System.out.print((item.getQuantidade()) + " x " + item.getProduto());

            // Só uma firula: coloca vírgula entre os itens, menos no último
            if (i < pedido.getItens().size() - 1) {
                System.out.print(", \n");
            }
        }
        System.out.printf("\nTOTAL: R$%s\n", (total + frete));
    }
}