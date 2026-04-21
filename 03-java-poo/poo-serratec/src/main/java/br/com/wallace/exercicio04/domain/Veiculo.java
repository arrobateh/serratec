package br.com.wallace.exercicio04.domain;

public abstract sealed class Veiculo implements Fretavel, Tributavel permits Caminhao, CarroPasseio {
    protected final String placa;
    protected final String marca;
    protected double valorLocacaoDiaria;
    protected final int anoFabricacao;
    protected double precoFipe;

    public Veiculo(String  placa, String marca, double valorLocacaoDiaria, int anoFabricacao,  double precoFipe) {
        this.placa = "";
        this.marca = "";
        this.valorLocacaoDiaria = valorLocacaoDiaria;
        this.anoFabricacao = anoFabricacao;
        this.precoFipe = precoFipe;
    }

    public String getPlaca() {
        return placa;
    }
    public String getMarca() {
        return marca;
    }
    public double getValorLocacaoDiaria() {
        return valorLocacaoDiaria;
    }
    public int getAnoFabricacao() {
        return anoFabricacao;
    }
    public double getPrecoFipe() {
        return precoFipe;
    }
}
