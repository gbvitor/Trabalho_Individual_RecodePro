package br.com.agenciaViagens.model;

public class Destinos {
	private double valorPassagem;
	private String nomeDestino;
	private int CEPDestino;

	public double getValorPassagem(){
		return valorPassagem;
	}

	public void setValorPassagem(double valorPassagem) {
		this.valorPassagem = valorPassagem;
	}

	public String getNomeDestino() {
		return nomeDestino;
	}
	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}
	public int getCEPDestino() {
		return CEPDestino;
	}
	public void setCEPDestino(int CEPDestino) {
		this.CEPDestino = CEPDestino;
	}

}
