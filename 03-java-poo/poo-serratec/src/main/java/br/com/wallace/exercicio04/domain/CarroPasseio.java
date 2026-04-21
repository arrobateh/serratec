package br.com.wallace.exercicio04.domain;

public final class CarroPasseio extends Veiculo {

    public CarroPasseio(String placa, String marca, double valorLocacaoDiaria, int anoFabricacao, double precoFipe) {

        super(placa, marca, valorLocacaoDiaria, anoFabricacao, precoFipe);
    }

    @Override
    public double alugarVeiculo(double pesoCarga, int dias) {

        System.out
                .append("\nCARRO DE PASSEIO \n")
                .append("Locacao finalizada. Parabéns! \n")
                .append("Valor total: R$ " + valorLocacaoDiaria * dias + "\n");
        return valorLocacaoDiaria * dias;
    }

    @Override
    public double calcularIpva() {
        return this.precoFipe * 0.04;
    }
}
