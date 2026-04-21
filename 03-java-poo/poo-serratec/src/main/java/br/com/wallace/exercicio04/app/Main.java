package br.com.wallace.exercicio04.app;

import br.com.wallace.exercicio04.domain.Caminhao;
import br.com.wallace.exercicio04.domain.CarroPasseio;
import br.com.wallace.exercicio04.domain.Veiculo;

public class Main {
    public static void main(String[] args) {
        // Criando um caminhão
        Caminhao scania = new Caminhao("ABC-1234", "Scania", 500.00, 2022, 450000.00, 10.0);

        //Criando um Carro de Passeio
        CarroPasseio civic = new CarroPasseio("XYZ-9999", "Honda", 200.00, 2023, 120000.00);

        System.out.println("===== LOCAÇÕES =====");

        // Cenário A: Caminhão com carga dentro do limite
        double aluguelNormal = scania.alugarVeiculo(8.0, 5);

        // Cenário B: Caminhão com sobrecarga
        double aluguelComTaxa = scania.alugarVeiculo(12.0, 5);

        // Cenário C: Carro de passeio
        double aluguelCarro = civic.alugarVeiculo(0.0, 3);

        System.out.println("\n===== TRIBUTAÇÃO =====");

        System.out.printf("IPVA Scania: R$ %.2f\n", scania.calcularIpva());
        System.out.printf("IPVA Civic: R$ %.2f\n", civic.calcularIpva());

        };



}

