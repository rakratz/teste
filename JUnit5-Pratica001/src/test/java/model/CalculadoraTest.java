package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
	
	@Test
	public void testSomar() {
		Calculadora calc = new Calculadora();
		Double resultado = calc.somar(6.2D, 2D);
		assertEquals(8.2D, resultado, () -> "6.2 + 2 não retornou 8.2!");
	}
	
	@Test
	public void testSubtrair() {
		Calculadora calc = new Calculadora();
		Double resultado = calc.subtrair(6.2D, 2D);
		assertEquals(4.2D, resultado, () -> "6.2 - 2 não retornou 4.2!");
	}
	
	@Test
	public void testDividir() {
		Calculadora calc = new Calculadora();
		Double resultado = calc.dividir(6.2D, 2D);
		assertEquals(3.1D, resultado, () -> "6.2 / 2 não retornou 3.1!");
	}
	
	@Test
	public void testDividirPorZero() {
		Calculadora calc = new Calculadora();
		try {
			Double resultado = calc.dividir(6.2D, 0D);
			Assertions.fail("Aceitou Divisão por Zero");
		} catch (ArithmeticException e) {
			Assertions.assertEquals("Não é possível dividir por zero", e.getMessage());
		}
	}
	
	@Test
	public void testMultiplicar() {
		Calculadora calc = new Calculadora();
		Double resultado = calc.multiplicar(6.2D, 2D);
		assertEquals(12.4D, resultado, () -> "6.2 * 2 não retornou 12.4!");
	}
	
}
