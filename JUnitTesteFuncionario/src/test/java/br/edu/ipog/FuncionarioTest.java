package br.edu.ipog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FuncionarioTest {

	@Test
	public void testeCalcularSalarioComHorasZero() {
		Funcionario funcionario = new Funcionario();
		funcionario.setValorPorHora(40.0);
		funcionario.setHorasTabalhadas(0);
		
		double salario = funcionario.calcularSalario();
		
		assertEquals(0.0, salario);
	}
	
	@Test
	public void testeCalcularSalarioComHorasPositivas() {
		Funcionario funcionario = new Funcionario();
		funcionario.setValorPorHora(40.0);
		funcionario.setHorasTabalhadas(15);
		
		double salario = funcionario.calcularSalario();
		
		assertEquals(600.0, salario);
	}
	
	@Test
	public void testeCalcularSalarioComValorZero() {
		Funcionario funcionario = new Funcionario();
		funcionario.setValorPorHora(0.0);
		funcionario.setHorasTabalhadas(40);
		
		double salario = funcionario.calcularSalario();
		
		assertEquals(0.0, salario);
	}
	
	@Test
	public void testeCalcularSalarioComValorNegativo() {
		Funcionario funcionario = new Funcionario();
		funcionario.setValorPorHora(-40.0);
		funcionario.setHorasTabalhadas(40);
		
		double salario = funcionario.calcularSalario();
		System.out.println("Salário retornado no teste: R$ " + salario);
		assertEquals(0.0, salario);
	}
	
	@Test
	public void testeCalcularSalarioComHorasNegativo() {
		Funcionario funcionario = new Funcionario();
		funcionario.setValorPorHora(40.0);
		funcionario.setHorasTabalhadas(-40);
		
		double salario = funcionario.calcularSalario();
		System.out.println("Salário retornado no teste: R$ " + salario);
		assertEquals(0.0, salario);
	}
	
	@Test
	public void testeGetsSetsFuncionario() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("João");
		funcionario.setValorPorHora(40.0);
		funcionario.setHorasTabalhadas(40);
		
		String nome = funcionario.getNome();
		double valorHora = funcionario.getValorPorHora();
		int horasTrabalhadas = funcionario.getHorasTabalhadas();
		
		assertEquals("João", nome);
		assertEquals(40.0, valorHora);
		assertEquals(40, horasTrabalhadas);
	}
}
