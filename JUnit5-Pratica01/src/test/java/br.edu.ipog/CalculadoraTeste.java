package br.edu.ipog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
	@Test
	public void testSomar() {
		Calculadora calc = new Calculadora();
		Assertions.assertTrue(calc.soma(2, 3) == 5);
		Assertions.assertTrue(calc.soma(4, 3) == 7);	
		Assertions.assertTrue(calc.soma(5, 5) == 8);
		
		
	}
}
