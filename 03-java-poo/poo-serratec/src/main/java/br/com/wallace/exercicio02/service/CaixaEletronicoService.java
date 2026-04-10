package br.com.wallace.exercicio02.service;


import br.com.wallace.exercicio02.domain.ContaBancaria;

public class CaixaEletronicoService {
    // Define o metodo para realizar deposito;
    public void realizarDeposito(ContaBancaria conta, double valorDeposito){
        // Valida o valor do deposito, para que seja positivo;
        if(valorDeposito <= 0) {
            System.out.print("Valor invalido!");
        }
        conta.depositar(valorDeposito);
    }

    // Define o metodo para validar se o cliente pode realizar o saque, verificando a quantidade de saques realizados;
    public boolean podeSacar(ContaBancaria conta) {
        if (conta.getQuantidadeSaques() >= 3) {
            System.out.print("Limites de saques diarios atingido!");
            return false;
        } return true;
    }

    // Define o metodo para realizar saques;
    public void realizarSaque(ContaBancaria conta, double valorSaque) {
        if (valorSaque > 1000.00) { // Define um valor para limite de saques;
            System.out.print("Valor acima do permitido!");
            return;
        } else if (valorSaque > conta.getSaldo()) { // Verifica se o valor do saque e maior que o saldo;
            System.out.print("Saldo insuficiente!");
        } else {
            double novoSaldo = conta.getSaldo() - valorSaque;
            conta.sacar(valorSaque);

            int totalSaques = conta.getQuantidadeSaques() + 1;
            conta.setQuantidadeSaques(totalSaques);
        }
    }
}
