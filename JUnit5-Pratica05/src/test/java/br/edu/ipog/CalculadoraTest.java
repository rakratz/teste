package br.edu.ipog;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculadoraTest {
	
	
	Calculadora calc = new Calculadora();
	private static int testContador = 0; 
	private static int passContador = 0; 
	
	@BeforeAll
	public static void testInicio() {
		System.out.println("********************************");
		System.out.println("*      Testes Iniciados        *");
		System.out.println("********************************");
	}
	
	
	@BeforeEach
	public void testSetup() {
		System.out.print(++testContador+"º Teste Iniciado...");
	}
	
	@AfterEach
	public void testEnd() {
		System.out.println("Pass");
	}
	
	@AfterAll
	public static void testRelatorio() {
	    System.out.println("********************************");
	    System.out.println("Total de Testes = " + testContador);
	    System.out.println("Sucessos = " + passContador);
	    System.out.println("Falhas = " + (testContador  - passContador));
	    float porcentagem = ((float) passContador / testContador) * 100;
	    System.out.println("Porcentagem = " + porcentagem + "%");
	    System.out.println("********************************");
	}
	
	@Test
	public void testSomar() {
		
		Assertions.assertTrue(calc.somar(2, 3) == 5);
		Assertions.assertEquals(5, calc.somar(2, 3));
		++passContador;
	}
	
	@Test
	public void testSubtrair() {
		Assertions.assertTrue(calc.subtrair(2, 3) == -1);
		Assertions.assertEquals(-1, calc.subtrair(2, 3));
		++passContador;
	}
	
	@Test
	public void testDividirValoresInteiroPositivosRetornaInteiro() {
		float resultado = calc.dividir(4, 2);
		Assertions.assertEquals(2, resultado);
		++passContador;
	}
	
	@Test
	public void testDividirValoresInteiroPositivosRetornaNegativo() {
		float resultado = calc.dividir(6, -3);
		Assertions.assertEquals(-2, resultado);
		++passContador;
	}
	
	@Test
	public void testDividirValoresInteiroPositivosRetornaFloat() {
		float resultado = calc.dividir(10, 3);
		Assertions.assertEquals(3.3333332538604736, resultado);
		// Ou posso passar a margem de erro (delta)
		Assertions.assertEquals(3.33, resultado, 0.01);
		++passContador;
	}
	
	@Test
	public void testDividirValoresNuloPorInteiroRetornarNulo() {
		float resultado = calc.dividir(0, 3);
		Assertions.assertEquals(0, resultado);
		++passContador;
	}
	
	@Test
	public void testDividirValoresZeroPorInteiroRetornarZero() {
		float resultado = calc.dividir(0, 3);
		Assertions.assertEquals(0, resultado);
		++passContador;
	}
	
	@Test
	public void testDividirValoresInteiroPorZeroRetornarNull() {
		try {
			float resultado = calc.dividir(3, 0);	
			Assertions.fail("Aceitou Divisão por Zero");
			
		} catch (ArithmeticException e) {
			Assertions.assertEquals("Divisão por zero não é permitida.", e.getMessage());
		}
		++passContador;
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Teste 1, Teste 2"})
	public void testStrings(String param) {
		System.out.println(param);
		Assertions.assertNotNull(param);
		++passContador;
	}	
	
	@ParameterizedTest
	@CsvSource(value = {
			"6, 3, 2",
			"5, 2, 2.5",
			"6, -2, -3",
			"10, 3, 3.3333332538604736",
			"0, 2, 0"
	})
	public void testDivisaoCorretamente(int num, int den, double res) {
		float resultado = calc.dividir(num, den);
		Assertions.assertEquals(res, resultado);
		++passContador;
	}
	

}

	

