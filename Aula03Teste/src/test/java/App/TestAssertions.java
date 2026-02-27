package App;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAssertions {

	@Test
	public void testEqualsIgnoreCase() {
		String str1 = "Hello";
		String str2 = "hello";
		
		assertTrue(str1.equalsIgnoreCase(str2));
		// assertTrue verifica se é verdadeido
		// Espera-se que as strings sejam iguais, independentemente do caso das letras
	}
	
	@Test
	public void testEqualsTrue() {
		int numero = 10;
		
		assertTrue(numero > 5);
		// Espera-se que a condição seja verdadeira (10 é maior que 5)
	}
	
	@Test
	public void testEqualsFalse() {
		int numero = 10;
		
		assertFalse(numero > 12);
		// Espera-se que a condição seja false (10 é menor que 12)
	}
	
	@Test
	public void testEquals() {
		int numero1 = 10;
		int numero2 = 10;
		
		assertEquals(numero1, numero2);
		// Espera-se os valores sejam iguais
	}
	
	@Test
	public void testNotEquals() {
		int numero1 = 10;
		int numero2 = 12;
		
		assertNotEquals(numero1, numero2);
		// Espera-se os valores sejam diferentes
	}
	
	@Test
	public void testNull() {
		Object obj = null;
		
		assertNull(obj);
		// Espera-se que o objeto seja nulo
	}

	
	@Test
	public void testNotNull() {
		Object obj = new Object();
		
		assertNotNull(obj);
		// Espera-se que o objeto seja nulo
	}
	
	
	@Test
	public void testSame() {
		Object obj1 = new Object();
		Object obj2 = obj1;
		
		assertSame(obj1, obj2);
		// Espera-se que os objetos sejam o mesmo (mesma referência)
	}
	
	@Test
	public void testNotSame() {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		assertNotSame(obj1, obj2);
		// Espera-se que os objetos sejam o mesmo (mesma referência)
	}
	
	@Test
	public void testArrayEquals() {
		int[] array1 = {1, 2, 3};
		int[] array2 = {1, 2, 3};
		
		assertArrayEquals(array1, array2);
		// Espera-se que os arrays sejam iguais (mesmos elementos)
	}
	

}
