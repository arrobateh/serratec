package br.com.wallace.exercicio02.domain;

public class ContaBancaria {
    private static int idConta = 1000; // Atribui um numero a conta sem a necessidade de digitar;
    private int NUMERO_CONTA; // Variavel constante que recebe o numero da conta;
    private String titular; // Recebe o nome do titular da conta;
    private double saldo; // Armazena o saldo da conta;
    private double BONUS = 50.0; // Variavel constante que define o valor do bonus na abertura da conta;
    private int quantidadeSaques; // Verifica a quantidade de saques realizados;

    // Define o construtor que espera receber apenas o nome do titular da conta;
    public ContaBancaria(String titular) {
        this.NUMERO_CONTA = idConta++;
        this.titular = titular;
        this.saldo = saldo + BONUS;
        this.quantidadeSaques = 0;

        System.out.printf("Parabéns %s! Conta criada com sucesso.\n", titular);
        System.out.printf("Como presente de boas vindas, voce recebeu um bonus de R$%s", BONUS);
    }

    // Define os metodos;
    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        this.saldo -= valor;
    }
    // Garante o acesso somente leitura ao saldo, numero da conta, titular e quantidade de saques;
    public double getSaldo() {
        return this.saldo;
    }
    public int getNUMERO_CONTA() {
        return this.NUMERO_CONTA;
    }
    public String getTitular() {
        return this.titular;
    }
    public int getQuantidadeSaques() {
        return this.quantidadeSaques;
    }

    // Garantindo permissao de escrita a quantidade de saques, para que o serviço possa atualizar o valor e ao titular em caso de necessidade de atualizacao do nome;
    public int setQuantidadeSaques(int quantidadeSaques) {
        return this.quantidadeSaques = quantidadeSaques;
    }
    public String setTitular(){
        return this.titular;
    }
}
