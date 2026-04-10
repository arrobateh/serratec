package br.com.wallace.exercicio02.app;

import java.util.Scanner;
import br.com.wallace.exercicio02.domain.ContaBancaria;
import br.com.wallace.exercicio02.service.CaixaEletronicoService;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        //Instanciando os objetos
        CaixaEletronicoService servico = new CaixaEletronicoService();
        ContaBancaria conta1 = new ContaBancaria("Atreus");

        int opcaoMenu;

        do {
            System.out.println("\n===== CAIXA ELETRONICO =====");
            System.out.println("1 - Ver Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Sair");
            System.out.print("Escola uma opcao: ");
            opcaoMenu = leia.nextInt();

            switch (opcaoMenu) {
                case 1:
                    //Leitura do saldo;
                    System.out.println("\nTitular: " + conta1.getTitular());
                    System.out.printf("Saldo atual: R$ " + conta1.getSaldo() + "\n");
                    break;
                case 2:
                    // Realiza o deposito;
                    System.out.print("Valor do deposito: ");
                    double valorDeposito = leia.nextDouble();
                    servico.realizarDeposito(conta1, valorDeposito);
                    System.out.print("Deposito realizado com sucesso!\n");
                    break;
                case 3:
                    // Realiza o saque;
                    if (servico.podeSacar(conta1)) { // Verifica se a condicao para realizar o saque e verdadeira, ou seja, se a quantidade de saques e menor que 3;
                        System.out.print("Valor do saque: R$ ");
                        double valorSaque = leia.nextDouble();
                        servico.realizarSaque(conta1, valorSaque);
                    } else if (!servico.podeSacar(conta1)) { // Verifica se a condicao para realizar o saque e falsa e, se sim, encerra o sistema;
                        return;
                    }
                    break;
                case 4:
                    System.out.print("Encerrando o sistema...");
                    break;
                default:
                    System.out.print("Opcao invalida");
            }
        } while (opcaoMenu != 4);
    }
}