package br.com.agenciaViagens.model;

public class CadastroDestino {
	private String email;
	private String nome;
	private int id;
	private double valorPassagem;
	private int CEPDestino;
	private int CEPOrigem;

	public String getEmail(){
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCEPDestino() {
		return CEPDestino;
	}
	public void setCEPDestino(int CEPDestino) {
		this.CEPDestino = CEPDestino;
	}
	
	public int getCEPOrigem() {
		return CEPOrigem;
	}
	public void setCEPOrigem(int CEPOrigem) {
		this.CEPOrigem = CEPOrigem;
	}
	
	public double getValorPassagem() {
		return valorPassagem;
	}
	
	public void setValorPassagem(double valorPassagem) {
		this.valorPassagem = valorPassagem;
	}
}
