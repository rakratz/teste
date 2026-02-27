package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;

class CalculadoraTest {
	
	private Calculadora calculadora;
	
	// Variáveis estatísticas
	private static int totalTestes = 0;
	private static int totalSucesso = 0;
	private static int totalFalha = 0;
	
	
	// Executa uma única vez antes de todos os testes
	@BeforeAll
	static void iniciarEstatisticas() {
		System.out.println("=== INICIANDO EXECUÇÃO DOS TESTES ===");
	}
	
	// Executa uma única vez depois de Todos os testes
	@AfterAll 
	static void exibeEstatisticas() {
		
		totalFalha = totalTestes - totalSucesso;
		
		System.out.println("\n=== RELATÓRIO ESTATÍSTICO ===");
        System.out.println("Total de testes: " + totalTestes);
        System.out.println("Testes com sucesso: " + totalSucesso);
        System.out.println("Testes com falha: " + totalFalha);

        double percentual = (totalSucesso * 100.0) / totalTestes;
        System.out.printf("Percentual de sucesso: %.2f%%\n", percentual);
	}
	
	// Executa essa função ante de cada teste
	@BeforeEach
	void setup() {
		calculadora = new Calculadora();
		totalTestes += 1;
	}
	
		

	

	// ================ Testes ==================
	
	@Test
	void deveSomarDoisNumerosPositivos() {
		assertEquals(5, calculadora.somar(2, 3));
		totalSucesso +=1;
	}
	
	@Test
	void deveSomarNumeroPositivoNegativo() {
		assertEquals(3, calculadora.somar(5, -2));
		totalSucesso +=1;
	}
	
	@Test
	void deveSomarNumeroPositivoComZero() {
		assertEquals(5, calculadora.somar(5, 0));
		totalSucesso +=1;
	}
	
	@Test
	void deveSomarNumeroDecimais() {
		assertEquals(5, calculadora.somar(2.5, 2.5));
		totalSucesso +=1;
	}
	
	@Test
	void deveSubtrairDoisNumeros() {
	    assertEquals(6, calculadora.subtrair(10, 4));
	    totalSucesso +=1;
	}

	@Test
	void deveGerarResultadoNegativo() {
	    assertEquals(-2, calculadora.subtrair(3, 5));
	    totalSucesso +=1;
	}

	@Test
	void deveSubtrairComZero() {
	    assertEquals(8, calculadora.subtrair(8, 0));
	    totalSucesso +=1;
	}
	
	
	@Test
	void deveMultiplicarDoisNumeros() {
	    assertEquals(20, calculadora.multiplicar(4, 5));
	    totalSucesso +=1;
	}

	@Test
	void deveMultiplicarPorZero() {
	    assertEquals(0, calculadora.multiplicar(7, 0));
	    totalSucesso +=1;
	}

	@Test
	void deveMultiplicarNumeroNegativo() {
	    assertEquals(-6, calculadora.multiplicar(3, -2));
	    totalSucesso +=1;
	}
	
	@Test
	void deveDividirDoisNumeros() {
		assertEquals(5, calculadora.dividir(10, 2));
		totalSucesso +=1;
	}
	
	@Test
	void deveDividirGerandoDecimal() {
	    assertEquals(2.5, calculadora.dividir(5, 2));
	    totalSucesso +=1;
	    
	}
	
	@Test
	void deveLancarExcecaoAoDividirPorZero() {
		assertThrows(ArithmeticException.class, () -> {
			calculadora.dividir(10, 0);
		});
		totalSucesso +=1;
	}


}
