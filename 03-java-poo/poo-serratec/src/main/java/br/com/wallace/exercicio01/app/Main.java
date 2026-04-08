package br.com.wallace.exercicio01.app; // Define package de origem;

import java.util.Scanner; // Importa a classe Scanner;

public class Main { //Declara a classe principal do programa;
    public static void main(String[] args) {
        int opcao; // Variavel que recebe a escolha do usuario no menu;
        Scanner leia = new Scanner(System.in); // Cria um objeto da classe Scanner chamado 'leia';
        int qtdSaque = 0; // Variavel que recebe a quantidade de saques realizado;
        int limiteSaqueDiario = 3; // Define o limite de saques diario;
        double saldoConta = 2000.00;
        double limiteSaqueValor = 1000.00;

        do {
            // Cria o menu;
            System.out.println("\n==== MENU ====");
            System.out.println("1 - Ver Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = leia.nextInt(); // Cria uma variavel para receber e guardar a opcao do usuario;

            // Realiza uma acao de acordo com a opcao do usuario;
            switch (opcao) {
                case 1:
                    System.out.println("\nVerificando Saldo");
                    break;
                case 2:
                    System.out.println("\nDepositando um Valor");
                    break;
                case 3:
                    if (qtdSaque >= limiteSaqueDiario) {
                        System.out.println("\nLimite de saques diarios atingido!");
                        break;
                    }
                    System.out.print("Digite um valor de saque: R$");
                    double saqueValor = leia.nextDouble();

                    if (saqueValor <= 0){
                        System.out.println("\nValor invalido. Tente novamente.");
                        break;
                    }
                    if (saqueValor > limiteSaqueValor) {
                        System.out.println("\nLimite Indisponivel!");
                        break;
                    }
                    if (saqueValor > saldoConta) {
                        System.out.println("\nSaldo Insuficiente!");
                        break;
                    }
                    saldoConta -= saqueValor;
                    qtdSaque++;

                    System.out.println("\nSaque realizado com sucesso!)");
                    System.out.println("Saldo atual: " + saldoConta);
                    break;
                case 4:
                    System.out.println("\nSaindo do menu");
                    return;
                default:
                    System.out.println("\nOpcao invalida. Tente novamente!");
                    break;
            }
        } while (opcao != 4); // Define a condicao de parada do loop;
    }
}