package br.com.wallace.exercicio03.app;

import br.com.wallace.exercicio03.domain.Cliente;
import br.com.wallace.exercicio03.domain.ItemPedido;
import br.com.wallace.exercicio03.domain.Pedido;
import br.com.wallace.exercicio03.service.RegrasPedido;

public class Main {
   public static void main(String[] args) {
       Cliente cliente = new Cliente("Atreus");
       Pedido pedido = new Pedido(cliente);
       pedido.adicionarItem(new ItemPedido("Teclado Mecânico", 100.00, 1));
       pedido.adicionarItem(new ItemPedido("Mouse Gamer", 150.00, 5));

       RegrasPedido service = new RegrasPedido();
       service.fecharPedido(pedido);
   }
}