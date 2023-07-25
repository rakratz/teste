package br.edu.ipog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestAssertions {

    @Test
    public void testEqualsIgnoreCase() {
        String str1 = "Hello";
        String str2 = "hello";
        assertEqualsIgnoreCase(str1, str2);
        // Espera-se que as strings sejam iguais, independentemente do caso das letras
    }

    @Test
    public void testAssertTrue() {
        int numero = 10;
        assertTrue(numero > 5);
        // Espera-se que a condição seja verdadeira (10 é maior que 5)
    }

    @Test
    public void testAssertFalse() {
        int numero = 3;
        assertFalse(numero > 5);
        // Espera-se que a condição seja falsa (3 não é maior que 5)
    }

    @Test
    public void testAssertEquals() {
        int resultado = metodoParaTestar(); // Suponha que esse método retorna 5
        assertEquals(5, resultado);
        // Espera-se que o resultado seja igual a 5
    }

    @Test
    public void testAssertNotEquals() {
        int resultado = metodoParaTestar() + 5; // Suponha que esse método retorna 10
        assertNotEquals(5, resultado);
        // Espera-se que o resultado seja diferente de 5
    }

    @Test
    public void testAssertNull() {
        Object obj = null;
        assertNull(obj);
        // Espera-se que o objeto seja nulo
    }

    @Test
    public void testAssertNotNull() {
        Object obj = new Object();
        assertNotNull(obj);
        // Espera-se que o objeto não seja nulo
    }

    // Outras asserções interessantes:

    @Test
    public void testAssertSame() {
        Object obj1 = new Object();
        Object obj2 = obj1;
        assertSame(obj1, obj2);
        // Espera-se que os objetos sejam o mesmo (mesma referência)
    }

    @Test
    public void testAssertNotSame() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertNotSame(obj1, obj2);
        // Espera-se que os objetos não sejam o mesmo (referências diferentes)
    }

    @Test
    public void testAssertArrayEquals() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        assertArrayEquals(array1, array2);
        // Espera-se que os arrays sejam iguais (mesmos elementos)
    }

    // Métodos auxiliares

    private int metodoParaTestar() {
        return 5;
    }

    private void assertEqualsIgnoreCase(String str1, String str2) {
        assertTrue(str1.equalsIgnoreCase(str2));
    }
}

