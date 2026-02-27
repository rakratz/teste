package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraSimplesTest {

	@Test
	void testSomaDoisValoresPositivo() {
		// Given (Dado que/Arranjo)
		CalculadoraSimples calculador = new CalculadoraSimples();
		
		// When/Act (Quando/Agir)
		Double resultado = calculador.soma(6.0D, 4.0D);
		
		// Then/Assert (Então/Certificar)
		assertEquals(resultado, 10.0D); 
		// assertEquals verifica se um valor (par1) é igual (par2)
	}
	
	@Test
	void testSomaDoisValoresNegativos() {
		// Given (Dado que/Arranjo)
		CalculadoraSimples calculador = new CalculadoraSimples();
		
		// When/Act (Quando/Agir)
		Double resultado = calculador.soma(-6.0D, -4.0D);
		
		// Then/Assert (Então/Certificar)
		assertEquals(resultado, -10.0D); 
		// assertEquals verifica se um valor (par1) é igual (par2)
	}
	
	@Test
	void testSomaDoisValoresNegativoPositivo() {
		// Given (Dado que/Arranjo)
		CalculadoraSimples calculador = new CalculadoraSimples();
		
		// When/Act (Quando/Agir)
		Double resultado = calculador.soma(-6.0D, 4.0D);
		
		// Then/Assert (Então/Certificar)
		assertEquals(resultado, -2.0D); 
		// assertEquals verifica se um valor (par1) é igual (par2)
	}
}
