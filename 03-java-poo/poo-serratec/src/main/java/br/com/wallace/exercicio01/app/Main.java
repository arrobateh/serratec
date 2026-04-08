package br.com.wallace.exercicio01.app; // Define package de origem;

import java.util.Scanner; // Importa a classe Scanner;

public class Main { //Declara a classe principal do programa;
    public static void main(String[] args) {
        int opcao; // Variavel que recebe a escolha do usuario no menu;
        Scanner leia = new Scanner(System.in); // Cria um objeto da classe Scanner chamado 'leia';
        int qtdSaque = 0; // Variavel que recebe a quantidade de saques realizado;
        int limiteSaque = 3; // Define o limite de saques diario;

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
                    if (qtdSaque < limiteSaque) { // Verifica se a quantidade de saques realizado e menor que o limite diario;
                        qtdSaque++;
                        System.out.println("\nRealizando um Saque...");
                    break;
                    } else {
                        System.out.println("\nLimite de Saques Atingido! Volte Amanha."); // Informa ao usuario que o limite de saques foi atingido;
                        break;
                    }
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