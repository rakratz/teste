package br.edu.ipog;

public class Funcionario {
	String nome;
	double valorPorHora;
	int horasTabalhadas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public int getHorasTabalhadas() {
		return horasTabalhadas;
	}

	public void setHorasTabalhadas(int horasTabalhadas) {
		this.horasTabalhadas = horasTabalhadas;
	}

	double calcularSalario() {
		if ((this.valorPorHora < 0 ) || (this.horasTabalhadas < 0) ){
			return 0.0;
		}
		return this.valorPorHora * this.horasTabalhadas;
	}
}
