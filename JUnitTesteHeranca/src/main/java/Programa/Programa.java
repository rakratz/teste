package Programa;

import model.Funcionario;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome("João");
		funcionario.setIdade(30);
		funcionario.setSalario(2500.0);
		
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("Idade: " + funcionario.getIdade());
		System.out.println("Salário: R$ " + funcionario.getSalario());
	}

}
