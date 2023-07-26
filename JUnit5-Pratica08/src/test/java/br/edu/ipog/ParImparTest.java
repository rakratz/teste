package br.edu.ipog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ParImparTest {

    @Test
    public void testVerificarPar() {
        boolean resultado = ParImpar.verificarPar(4);
        assertEquals(true, resultado);
    }

    @Test
    public void testVerificarImpar() {
        boolean resultado = ParImpar.verificarPar(7);
        assertEquals(false, resultado);
    }
    
    @ParameterizedTest
    @CsvSource({
            "4, true",
            "7, false",
            "10, true",
            "15, false"
    })
    public void testVerificarPar(int numero, boolean expected) {
        boolean resultado = ParImpar.verificarPar(numero);
        assertEquals(expected, resultado);
    }
    
}