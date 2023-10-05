package model;

public class Funcionario extends Pessoa{

	private double salario;
	
	public Funcionario() {
		
	}
	
	public Funcionario(String nome, int idade, double salario) {
		super();
		this.setNome(nome);
		this.setIdade(idade);
		this.salario = salario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
