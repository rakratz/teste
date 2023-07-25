package br.edu.ipog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
	@Test
	public void testSomar() {
		Calculadora calc = new Calculadora();
		Assertions.assertTrue(calc.somar(2, 3) == 5);
		Assertions.assertTrue(calc.somar(4, 3) == 7);	
		Assertions.assertTrue(calc.somar(5, 5) == 10);	
		
		Assertions.assertTrue(calc.subtrair(2, 3) == -1);
		Assertions.assertTrue(calc.subtrair(4, 3) == 1);	
		Assertions.assertTrue(calc.subtrair(5, 5) == 0);	
	}
}