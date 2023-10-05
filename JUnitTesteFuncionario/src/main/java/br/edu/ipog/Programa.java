package br.edu.ipog;

import java.util.Scanner;

public class Programa {

	private static Scanner leitura;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Funcionario funcionario1 = new Funcionario();
		leitura = new Scanner(System.in);
		
		// Leitura dos dados no primeiro funcionário
		System.out.println("Informe os dados do primeiro funcionário.");
		System.out.print("Nome: ");
		funcionario1.setNome(leitura.nextLine());
		System.out.print("Valor por Hora: ");
		funcionario1.setValorPorHora(leitura.nextDouble());
		System.out.print("Hora Trabalhadas: ");
		funcionario1.setHorasTabalhadas(leitura.nextInt());
		
		// Limpar o buffer
		leitura.nextLine();
		
		Funcionario funcionario2 = new Funcionario();
		
		// Leitura dos dados no segundo funcionário
		System.out.println("Informe os dados do segundo funcionário.");
		System.out.print("Nome: ");
		funcionario2.setNome(leitura.nextLine());	
		System.out.print("Valor por Hora: ");
		funcionario2.setValorPorHora(leitura.nextDouble());
		System.out.print("Hora Trabalhadas: ");
		funcionario2.setHorasTabalhadas(leitura.nextInt());
		
		// Calculando os salários
		double salario1 = funcionario1.calcularSalario();
		double salario2 = funcionario2.calcularSalario();		
		
		double totalPago = salario1 + salario2;
		
		//Exibir os dados
		System.out.println("\nResumo de Pagamento: ");
		System.out.println("Funcionário: "+ funcionario1.getNome() + " Salário: R$ " + salario1);
		System.out.println("Funcionário: "+ funcionario2.getNome() + " Salário: R$ " + salario2);
		System.out.println("Valor total pago: R$ "+ totalPago);
	}

}
