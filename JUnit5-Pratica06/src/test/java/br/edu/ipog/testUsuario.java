package br.edu.ipog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import br.edu.ipog.exceptions.ValidationException;

public class testUsuario {

	@Test
	public void testCriarUsuarioValido() {
		Usuario usuario = new Usuario(1L,"Nome do Usuário","nome@email.com","123456");
        Assertions.assertAll("Usuario",
                () -> assertEquals(1L, usuario.getId()),
                () -> assertEquals("Nome do Usuário", usuario.getNome()),
                () -> assertEquals("nome@email.com", usuario.getEmail()),
                () -> assertEquals("123456", usuario.getSenha())
        );
	}
	
    @Test
    public void testNaoPermitirUsuarioSemNome() {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> {
            Usuario usuario = new Usuario(1L, null, "nome@email.com", "123456");  });
        assertEquals("Nome é Obrigatório", ex.getMessage());
	}
    
    @Test
    public void testNaoPermitirUsuarioSemEmail() {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> {
            Usuario usuario = new Usuario(1L, "Nome do Usuário", null, "123456");  });
        assertEquals("E-mail é Obrigatório", ex.getMessage());
	}
    
    @Test
    public void testNaoPermitirUsuarioSemSenha() {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> {
            Usuario usuario = new Usuario(1L, "Nome do Usuário", "nome@email.com", null);  });
        assertEquals("Senha é Obrigatória", ex.getMessage());
	}
    
    @ParameterizedTest(name = "[{index}] - {4}")
    @CsvFileSource(files = "src\\test\\resources\\usuariosCSV.csv", nullValues = "null", numLinesToSkip = 1)
    
/*
    @CsvSource(value = {
    		"1, null, nome@email.com, 123456, Nome é Obrigatório",
    		"1, Nome do Usuário, null, 123456, E-mail é Obrigatório",
    		"1, Nome do Usuário, nome@email.com, null, Senha é Obrigatória"
    }, nullValues = "null")
*/
    public void testValidarCamposObrigatorios(Long id, String nome, String email, String senha, String msn) {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> {
            Usuario usuario = new Usuario(id, nome, email, senha);  });
        assertEquals(msn, ex.getMessage());
    }
}