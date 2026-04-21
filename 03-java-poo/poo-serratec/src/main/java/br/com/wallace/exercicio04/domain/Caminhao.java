package br.com.wallace.exercicio04.domain;

public final class Caminhao extends Veiculo {
    protected final double capacidadeCargaToneladas;

    public Caminhao(String placa, String marca, double valorLocacaoDiaria, int anoFabricacao, double precoFipe, double capacidadeCargaToneladas) {
        super(placa, marca, valorLocacaoDiaria, anoFabricacao, precoFipe);
        this.capacidadeCargaToneladas = capacidadeCargaToneladas;
    }

    @Override
    public double alugarVeiculo(double pesoCarga, int dias) {
        double valorTotal = valorLocacaoDiaria * dias;

        if (pesoCarga > capacidadeCargaToneladas) {
            valorTotal *= 1.10;
            System.out
                    .append("CAMINHAO \n")
                    .append("Locacao finalizada. Parabéns! \n")
                    .append("OBS: Sobrecarga detectada! Aplicando taxa de 10% \n")
                    .append("Valor total com taxas: R$ " + valorTotal + "\n");
        } else {
            System.out
                    .append("CAMINHAO \n")
                    .append("Locacao finalizada. Parabéns! \n")
                    .append("Valor total sem taxas: R$ " + valorTotal + "\n\n");
        }
        return valorTotal;
    }
    @Override
    public double calcularIpva() {
        return this.precoFipe * 0.015;
    }
}

